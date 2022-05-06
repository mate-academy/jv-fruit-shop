package core.basesyntax.service.impl;

import core.basesyntax.service.LineParserService;
import java.util.List;
import java.util.stream.Collectors;

public class LineParserServiceImpl implements LineParserService {
    @Override
    public List<String[]> parseDate(List<String> lines) {
        return lines.stream()
                .skip(1)
                .map(String::trim)
                .map(s -> s.split(","))
                .collect(Collectors.toList());
    }
}
