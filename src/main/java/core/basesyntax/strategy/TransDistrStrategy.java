package core.basesyntax.strategy;

import core.basesyntax.model.dto.FruitDto;
import core.basesyntax.service.StorageService;

public interface TransDistrStrategy {
    StorageService choseStorageService(FruitDto transactionLog);
}
