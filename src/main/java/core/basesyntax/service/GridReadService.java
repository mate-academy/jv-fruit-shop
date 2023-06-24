package core.basesyntax.service;

import core.basesyntax.model.Grid;

public interface GridReadService {
    Grid getGrid(String path);
}
