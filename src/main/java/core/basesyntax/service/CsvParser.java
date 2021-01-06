package core.basesyntax.service;

import java.util.List;

public interface CsvParser {
    List<String[]> parse(List<String> input);
}
