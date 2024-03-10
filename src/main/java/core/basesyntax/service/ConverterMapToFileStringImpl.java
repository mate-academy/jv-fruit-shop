package core.basesyntax.service;

import java.util.Map;
import java.util.stream.Collectors;

public class ConverterMapToFileStringImpl implements ConverterMapToFileString {
    public static final String TITLE_LINE = "fruit;quantity\n";

    @Override
    public String dataToString(Map<String, Integer> map) {
        return TITLE_LINE + map.entrySet().stream()
                .map(e -> e.getKey() + ";" + e.getValue().toString())
                .collect(Collectors.joining("\n"));
    }
}
