package core.basesyntax.service.impl;

import core.basesyntax.service.ParserDataService;
import java.util.List;
import java.util.stream.Collectors;

public class ParserDataServiceImpl implements ParserDataService {
    private static final int REMOVED_INDEX = 0;

    @Override
    public List<String[]> parseDate(List<String> lines) {
        lines.remove(REMOVED_INDEX);
        return lines.stream()
                .map(String::trim)
                .map(s -> s.split(","))
                .collect(Collectors.toList());
    }
}
