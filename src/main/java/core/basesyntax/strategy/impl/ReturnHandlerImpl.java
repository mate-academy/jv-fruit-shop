package core.basesyntax.strategy.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitShopDao;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.utility.ListService;
import core.basesyntax.utility.impl.ListServiceImpl;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ReturnHandlerImpl implements OperationHandler {
    private static List<FruitTransaction> returnList = new ArrayList<>();
    private Map<String, Integer> returnFruitsMap;
    private ListService listService = new ListServiceImpl();

    @Override
    public void handleOperation(FruitTransaction transaction, FruitShopDao fruitShopDao) {
        returnList.add(transaction);
        returnFruitsMap = listService.getComputedMap(returnList);
        fruitShopDao.setReturnMap(returnFruitsMap);
    }
}
