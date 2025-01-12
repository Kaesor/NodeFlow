package thito.nodeflow.internal.settings.parser;

import thito.nodeflow.config.*;
import thito.nodeflow.internal.settings.*;

import java.util.*;

public class LongParser implements SettingsParser<Long> {
    @Override
    public Optional<Long> fromConfig(Section source, String key) {
        return source.getLong(key);
    }

    @Override
    public void toConfig(Section source, String key, Long value) {
        source.set(key, value);
    }
}
