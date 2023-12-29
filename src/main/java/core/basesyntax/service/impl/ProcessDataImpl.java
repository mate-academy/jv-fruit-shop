package core.basesyntax.service.impl;

import core.basesyntax.db.DataBase;
import core.basesyntax.db.DataBaseImpl;
import core.basesyntax.functional.Function;
import core.basesyntax.functional.FunctionImpl;
import core.basesyntax.service.ProcessData;
import core.basesyntax.strategy.PurchaseStrategy;
import core.basesyntax.strategy.RetrunStrategy;
import core.basesyntax.strategy.StrategyHandler;
import core.basesyntax.strategy.SupplyStrategy;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProcessDataImpl implements ProcessData {
    private static final String INDICATOR_FOR_SUPPLY_OPERATION = "s";
    private static final String INDICATOR_FOR_PURCHASE_OPERATION = "p";
    private static final String INDICATOR_FOR_RETURN_OPERATION = "r";
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private final DataBase dataBase = DataBaseImpl.getDataBase();
    private final Function function = new FunctionImpl();
    private Map<String, StrategyHandler> strategyMapHandler = new HashMap<>();
    private Map<String, String> balanceMap = dataBase.getMapOfBalanceStorage();
    private String code;
    private int resultOfOperation;

    public ProcessDataImpl() {
        strategyMapHandler.put(INDICATOR_FOR_SUPPLY_OPERATION,
                new StrategyHandler(new SupplyStrategy()));
        strategyMapHandler.put(INDICATOR_FOR_PURCHASE_OPERATION,
                new StrategyHandler(new PurchaseStrategy()));
        strategyMapHandler.put(INDICATOR_FOR_RETURN_OPERATION,
                new StrategyHandler(new RetrunStrategy()));
    }

    @Override
    public void processData(List<String[]> list) {
        for (String[] data : list) {
            if (data[OPERATION_INDEX] != null) {
                code = data[OPERATION_INDEX];
                if (balanceMap.containsKey(data[FRUIT_INDEX])) {
                    StrategyHandler strategyHandler = strategyMapHandler.get(code);
                    if (strategyHandler != null) {
                        resultOfOperation = strategyHandler
                                .performCountBalance(data[FRUIT_INDEX],
                                        data[QUANTITY_INDEX], balanceMap);
                        dataBase.addBalanceOfFruit(data[FRUIT_INDEX],
                                Integer.toString(resultOfOperation));
                    } else {
                        System.out.println("there's no operation exist");
                    }
                }
            }
        }
    }
}
