package thito.nodeflow.internal.settings;

import thito.nodeflow.internal.language.*;
import thito.nodeflow.internal.settings.canvas.*;

public class PluginSettings extends SettingsCategory {

    private SettingsItem<Boolean> enable;
    public PluginSettings(String key, I18n displayName, SettingsContext context) {
        super(key, displayName, context);
        getItems().add(enable = new SimpleSettingsItem<>("enable", I18n.$("settings.plugins.enable"), Boolean.class, true));
    }

    public SettingsItem<Boolean> getEnable() {
        return enable;
    }
}
