package core.basesyntax.service.parser;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ParseDataImpl implements ParseData {
    private static final String SEPARATOR = ",";

    @Override
    public List<String[]> parse(String data) {
        List<String> dataToList = Arrays.asList(data.split(System.lineSeparator()));
        return dataToList.stream()
                .map(s -> s.split(SEPARATOR))
                .collect(Collectors.toList());
    }
}
