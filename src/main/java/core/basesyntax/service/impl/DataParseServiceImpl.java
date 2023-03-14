package core.basesyntax.service.impl;

import core.basesyntax.service.DataParseService;
import java.util.List;
import java.util.stream.Collectors;

public class DataParseServiceImpl implements DataParseService {
    private static final String COMMA_SEPARATOR = ",";
    private static final int HEADER_INDEX = 0;

    @Override
    public List<String[]> parseData(List<String> data) {
        data.remove(HEADER_INDEX);
        return data.stream()
                .map(s -> s.split(COMMA_SEPARATOR))
                .collect(Collectors.toList());
    }
}
