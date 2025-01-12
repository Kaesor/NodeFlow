package thito.nodeflow.internal.settings.parser;

import thito.nodeflow.config.*;
import thito.nodeflow.internal.settings.*;

import java.util.*;

public class FloatParser implements SettingsParser<Float> {
    @Override
    public Optional<Float> fromConfig(Section source, String key) {
        return source.getFloat(key);
    }

    @Override
    public void toConfig(Section source, String key, Float value) {
        source.set(key, value);
    }
}
