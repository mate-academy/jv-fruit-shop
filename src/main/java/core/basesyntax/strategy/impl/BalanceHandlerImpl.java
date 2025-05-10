package core.basesyntax.strategy.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitShopDao;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.utility.ListService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BalanceHandlerImpl implements OperationHandler {
    private static final List<FruitTransaction> BALANCE_LIST = new ArrayList<>();
    private final ListService listService;
    private Map<String, Integer> balanceFruitsMap;

    public BalanceHandlerImpl(ListService listService) {
        this.listService = listService;
        this.balanceFruitsMap = new HashMap<>();
    }

    @Override
    public void handleOperation(FruitTransaction transaction, FruitShopDao fruitShopDao) {
        BALANCE_LIST.add(transaction);
        balanceFruitsMap = listService.getComputedMap(BALANCE_LIST);
        fruitShopDao.setBalanceMap(balanceFruitsMap);
    }
}
