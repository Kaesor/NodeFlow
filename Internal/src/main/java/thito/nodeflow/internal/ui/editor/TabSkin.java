package thito.nodeflow.internal.ui.editor;

import javafx.beans.property.*;
import javafx.scene.layout.*;
import thito.nodeflow.internal.project.*;
import thito.nodeflow.internal.project.module.*;
import thito.nodeflow.library.resource.*;
import thito.nodeflow.library.task.*;
import thito.nodeflow.library.ui.*;

import java.io.*;

public class TabSkin extends Skin {

    private ObjectProperty<FileViewer> fileViewer = new SimpleObjectProperty<>();

    @Component("content")
    BorderPane content;

    private Project project;
    private FileModule module;
    private Resource resource;

    public TabSkin(Project project, FileModule module, Resource resource) {
        this.module = module;
        this.resource = resource;
        this.project = project;
    }

    @Override
    protected void onLayoutLoaded() {
        fileViewer.addListener((obs, old, val) -> {
            content.setCenter(val.getNode());
        });

        TaskThread.IO().schedule(() -> {
            try (InputStream inputStream = resource.openInput()) {
                long size = resource.getSize();
                // 0 array-copy IO
                byte[] buffer = new byte[(int) resource.getSize()];
                if (buffer.length != size) throw new IOException("file too large");
                int length = inputStream.read(buffer);
                if (length != size) throw new IOException("invalid file buffer size"); // developer error?
                TaskThread.UI().schedule(() -> {
                    fileViewer.set(module.createViewer(project, resource, buffer));
                });
            } catch (Throwable e) {
                // TODO handle, show error UI
                e.printStackTrace();
            }
        });
    }
}
