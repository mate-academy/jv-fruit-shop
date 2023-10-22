package core.basesyntax.strategy.read;

import core.basesyntax.model.DataSourceType;
import core.basesyntax.service.InputReaderService;

public interface InputReaderStrategy {
    InputReaderService get(DataSourceType source);
}
