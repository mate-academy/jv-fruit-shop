package core.basesyntax.strategy.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitShopDao;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.utility.ListService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReturnHandlerImpl implements OperationHandler {
    private static final List<FruitTransaction> RETURN_LIST = new ArrayList<>();
    private final ListService listService;
    private Map<String, Integer> returnFruitsMap;

    public ReturnHandlerImpl(ListService listService) {
        this.listService = listService;
        this.returnFruitsMap = new HashMap<>();
    }

    @Override
    public void handleOperation(FruitTransaction transaction, FruitShopDao fruitShopDao) {
        RETURN_LIST.add(transaction);
        returnFruitsMap = listService.getComputedMap(RETURN_LIST);
        fruitShopDao.setReturnMap(returnFruitsMap);
    }
}
