package core.basesyntax.service;

import java.util.List;

public interface GridWriteService {
    void writeLines(List<String[]> lines, String[] titles);
}
