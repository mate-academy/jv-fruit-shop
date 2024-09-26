package core.basesyntax.service.impl;

import core.basesyntax.service.ActionHandler;
import core.basesyntax.service.StorageService;
import core.basesyntax.service.StorageServiceImpl;

public class PurchaseAction implements ActionHandler {
    private final StorageService service = new StorageServiceImpl();

    @Override
    public void apply(String fruit, int quantity) {
        service.removeFruit(fruit, quantity);
    }
}
