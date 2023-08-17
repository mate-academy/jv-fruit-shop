package core.basesyntax.dao;

import java.util.List;

public interface FileReadService {
    List<String> readDataFromReport(String file);
}
