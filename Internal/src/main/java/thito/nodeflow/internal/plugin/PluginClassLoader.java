package thito.nodeflow.internal.plugin;

import thito.nodeflow.library.config.*;

import java.io.*;
import java.net.*;
import java.util.*;
import java.util.stream.*;

public class PluginClassLoader extends URLClassLoader {
    private Plugin plugin;
    public PluginClassLoader(URL[] urls, ClassLoader parent) {
        super(urls, parent);
    }

    public Plugin getPlugin() {
        if (plugin == null) throw new IllegalStateException("not loaded");
        return plugin;
    }

    public boolean isLoaded() {
        return plugin != null;
    }

    public void load() {
        try (InputStreamReader reader = new InputStreamReader(Objects.requireNonNull(getResourceAsStream("plugin.yml")))) {
            Section pluginProperties = Section.parseToMap(reader);
            String name = pluginProperties.getString("name").orElseThrow();
            String version = pluginProperties.getString("version").orElseThrow();
            String main = pluginProperties.getString("main").orElseThrow();
            List<String> authors = pluginProperties.getList("authors").orElse(new ListSection())
                    .stream().map(String::valueOf).collect(Collectors.toList());
            Class<?> mainClass = Class.forName(main, true, this);
            if (PluginInstance.class.isAssignableFrom(mainClass)) throw new ClassNotFoundException("main class does not extend "+PluginInstance.class.getName());
            plugin = new Plugin(name, version, mainClass, authors, this);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}