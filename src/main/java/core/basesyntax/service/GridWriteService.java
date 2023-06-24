package core.basesyntax.service;

import core.basesyntax.model.Grid;

public interface GridWriteService {
    void write(String filePath, Grid grid);
}
