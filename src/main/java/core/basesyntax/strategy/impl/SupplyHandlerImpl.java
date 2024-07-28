package core.basesyntax.strategy.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitShopDao;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.utility.ListService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SupplyHandlerImpl implements OperationHandler {
    private static final List<FruitTransaction> SUPPLY_LIST = new ArrayList<>();
    private final ListService listService;
    private Map<String, Integer> supplyFruitsMap;

    public SupplyHandlerImpl(ListService listService) {
        this.listService = listService;
        this.supplyFruitsMap = new HashMap<>();
    }

    @Override
    public void handleOperation(FruitTransaction transaction, FruitShopDao fruitShopDao) {
        SUPPLY_LIST.add(transaction);
        supplyFruitsMap = listService.getComputedMap(SUPPLY_LIST);
        fruitShopDao.setSupplyMap(supplyFruitsMap);
    }
}
