package thito.nodeflow.internal.project.module;

import thito.nodeflow.internal.project.*;
import thito.nodeflow.internal.language.*;
import thito.nodeflow.internal.resource.*;
import thito.nodeflow.internal.ui.*;
import thito.nodeflow.internal.ui.form.*;

public interface FileModule {
    I18n getDisplayName();
    String getIconURL(Theme theme);
    boolean acceptResource(Resource resource);
    FileViewer createViewer(Project project, Resource resource);
    Validator<Resource> getFileValidator();
    void createFile(Resource resource);
}
