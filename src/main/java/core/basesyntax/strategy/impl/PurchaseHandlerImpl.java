package core.basesyntax.strategy.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitShopDao;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.utility.ListService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PurchaseHandlerImpl implements OperationHandler {
    private static final List<FruitTransaction> PURCHASE_LIST = new ArrayList<>();
    private final ListService listService;
    private Map<String, Integer> purchaseFruitsMap;

    public PurchaseHandlerImpl(ListService listService) {
        this.listService = listService;
        this.purchaseFruitsMap = new HashMap<>();
    }

    @Override
    public void handleOperation(FruitTransaction transaction, FruitShopDao fruitShopDao) {
        PURCHASE_LIST.add(transaction);
        purchaseFruitsMap = listService.getComputedMap(PURCHASE_LIST);
        fruitShopDao.setPurchaseMap(purchaseFruitsMap);
    }
}
