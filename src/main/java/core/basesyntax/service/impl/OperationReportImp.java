package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.strategy.BalanceHandler;
import core.basesyntax.service.strategy.OperationHandler;
import core.basesyntax.service.strategy.PurchaseHandler;
import core.basesyntax.service.strategy.ReturnHandler;
import core.basesyntax.service.strategy.SupplyHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OperationReportImp implements OperationReport {
    private static final String SEPARATOR = ",";
    private static final int OPERATION = 0;
    private static final int FRUIT = 1;
    private static final int QUANTITY = 2;
    private final FruitDao fruitDao;
    private final Map<Fruit.Operation, OperationHandler> operationHandlers;

    public OperationReportImp(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
        this.operationHandlers = initializeHandlers();
    }

    @Override
    public void report() {
        List<String> csvData = fruitDao.getCsv();

        Map<String, Integer> resultMap = csvData.stream()
                .map(s -> s.split(SEPARATOR))
                .collect(Collectors.groupingBy(
                        stringRow -> stringRow[FRUIT],
                        Collectors.summingInt(stringRow -> {
                            int quantity = Integer.parseInt(stringRow[QUANTITY]);
                            return "p".equals(stringRow[OPERATION]) ? -quantity : quantity;
                        })
                ));

        List<String> newCsvData = resultMap.entrySet().stream()
                .map(entry -> entry.getKey() + SEPARATOR + entry.getValue())
                .collect(Collectors.toList());

        fruitDao.createReportCsv(newCsvData);
    }

    private Map<Fruit.Operation, OperationHandler> initializeHandlers() {
        Map<Fruit.Operation, OperationHandler> handlers = new HashMap<>();
        handlers.put(Fruit.Operation.BALANCE, new BalanceHandler());
        handlers.put(Fruit.Operation.SUPPLY, new SupplyHandler());
        handlers.put(Fruit.Operation.PURCHASE, new PurchaseHandler());
        handlers.put(Fruit.Operation.RETURN, new ReturnHandler());
        return handlers;
    }
}
