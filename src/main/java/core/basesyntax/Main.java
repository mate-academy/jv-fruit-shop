package core.basesyntax;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.model.Operations;
import core.basesyntax.service.FileService;
import core.basesyntax.service.FileServiceImpl;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.FruitServiceImpl;
import core.basesyntax.service.operations.BalanceOperationsHandler;
import core.basesyntax.service.operations.PurchaseOperationsHandler;
import core.basesyntax.service.operations.SupplyOperationsHandler;
import core.basesyntax.service.strategy.OperationHandler;
import core.basesyntax.service.strategy.OperationsStrategy;
import core.basesyntax.service.strategy.OperationsStrategyImpl;
import core.basesyntax.service.strategy.ReturnOperationHandler;
import java.util.EnumMap;
import java.util.List;

public class Main {
    private static final String INPUT_FILE = "input.csv";
    private static final String REPORT_FILE = "report.csv";

    public static void main(String[] args) {
        EnumMap<Operations, OperationHandler> operationsHandlerMap
                = new EnumMap<>(Operations.class);
        fillOperationMap(operationsHandlerMap);

        FruitDao fruitDao = new FruitDaoImpl();
        OperationsStrategy strategy = new OperationsStrategyImpl(operationsHandlerMap);
        FruitService fruitService = new FruitServiceImpl(fruitDao, strategy);
        FileService fileService = new FileServiceImpl();

        List<String> fileRows = fileService.readFile(INPUT_FILE);
        fruitService.addFruitFromList(fileRows);
        fileService.writeToFile(REPORT_FILE);
    }

    private static void fillOperationMap(EnumMap<Operations, OperationHandler> map) {
        map.put(Operations.BALANCE, new BalanceOperationsHandler());
        map.put(Operations.SUPPLY, new SupplyOperationsHandler());
        map.put(Operations.PURCHASE, new PurchaseOperationsHandler());
        map.put(Operations.RETURN, new ReturnOperationHandler());
    }
}
