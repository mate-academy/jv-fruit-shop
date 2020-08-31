package core.basesyntax.implementation;

import core.basesyntax.StoreOperationsExecutable;
import core.basesyntax.model.FruitDto;
import core.basesyntax.servise.StorageService;

public class SupplyOperation implements StoreOperationsExecutable {
    private StorageService storageService;

    public SupplyOperation(StorageService storageService) {
        this.storageService = storageService;
    }

    @Override
    public void executeOperation(FruitDto fruitDto) {
        storageService.addItemData(fruitDto);
    }
}
