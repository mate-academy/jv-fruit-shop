package core.basesyntax.impl;

import core.basesyntax.model.FruitBox;
import core.basesyntax.service.Operator;
import core.basesyntax.service.StorageService;

public class SellOperation implements Operator<FruitBox> {
    @Override
    public void execute(FruitBox fruit) {
        StorageService storageService = new StorageService();
        storageService.sellProduct(fruit);
    }
}
