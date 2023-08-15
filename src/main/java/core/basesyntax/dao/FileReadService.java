package core.basesyntax.dao;

import java.util.List;

public interface FileReadService {
    List<String> getDataFromReport(String file);
}
