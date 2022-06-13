package core.basesyntax.strategу;

import core.basesyntax.service.StorageService;
import core.basesyntax.service.impl.StorageServiceImpl;

public interface Strategy {
    void execute(String fruit, Integer amount);
}
