package thito.nodeflow.internal.settings;

import javafx.collections.*;

public class SettingsCategory {
    private SettingsDescription description;
    ObservableList<SettingsProperty<?>> settingsPropertyList = FXCollections.observableArrayList();
    ObservableList<SettingsCategory> subCategory = FXCollections.observableArrayList();

    public SettingsCategory(SettingsDescription description) {
        this.description = description;
    }

    public SettingsDescription getDescription() {
        return description;
    }

    public ObservableList<SettingsCategory> getSubCategory() {
        return subCategory;
    }

    public ObservableList<SettingsProperty<?>> getSettingsPropertyList() {
        return settingsPropertyList;
    }
}
