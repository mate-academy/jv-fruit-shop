package core.basesyntax.strategy.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitShopDao;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.utility.ListService;
import core.basesyntax.utility.impl.ListServiceImpl;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PurchaseHandlerImpl implements OperationHandler {
    private static List<FruitTransaction> purchaseList = new ArrayList<>();
    private Map<String, Integer> purchaseFruitsMap;
    private ListService listService = new ListServiceImpl();

    @Override
    public void handleOperation(FruitTransaction transaction, FruitShopDao fruitShopDao) {
        purchaseList.add(transaction);
        purchaseFruitsMap = listService.getComputedMap(purchaseList);
        fruitShopDao.setPurchaseMap(purchaseFruitsMap);
    }
}
