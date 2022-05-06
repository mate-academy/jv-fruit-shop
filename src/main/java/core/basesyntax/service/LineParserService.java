package core.basesyntax.service;

import java.util.List;

public interface LineParserService {
    List<String[]> parseDate(List<String> lines);
}
