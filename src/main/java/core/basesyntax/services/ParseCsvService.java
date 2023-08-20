package core.basesyntax.services;

import java.util.List;

public interface ParseCsvService {
    List<String[]> parse(String[] inputData);
}
