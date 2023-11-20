package core.basesyntax.service;

import java.util.List;

public interface CsvReadService extends ReadService<List<String>> {
    @Override
    List<String> read(String filePath);
}
