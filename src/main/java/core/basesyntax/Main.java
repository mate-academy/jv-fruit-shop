package core.basesyntax;

import core.basesyntax.dao.FruitsDao;
import core.basesyntax.dao.FruitsDaoImpl;
import core.basesyntax.model.Operations;
import core.basesyntax.service.FileService;
import core.basesyntax.service.FileServiceImpl;
import core.basesyntax.service.FruitsService;
import core.basesyntax.service.FruitsServiceImpl;
import core.basesyntax.service.operations.BalanceOperationsHandler;
import core.basesyntax.service.operations.OperationsHandler;
import core.basesyntax.service.operations.OperationsStrategy;
import core.basesyntax.service.operations.OperationsStrategyImpl;
import core.basesyntax.service.operations.PurchaseOperationsHandler;
import core.basesyntax.service.operations.ReturnOperationsHandler;
import core.basesyntax.service.operations.SupplyOperationsHandler;
import java.util.EnumMap;
import java.util.List;

public class Main {
    private static final String INPUT_FILE = "input.csv";
    private static final String REPORT_FILE = "report.csv";

    public static void main(String[] args) {
        EnumMap<Operations, OperationsHandler> operationsHandlerMap
                = new EnumMap<>(Operations.class);
        fillOperationMap(operationsHandlerMap);

        FruitsDao fruitDao = new FruitsDaoImpl();
        OperationsStrategy strategy = new OperationsStrategyImpl(operationsHandlerMap);
        FruitsService fruitService = new FruitsServiceImpl(fruitDao, strategy);
        FileService fileService = new FileServiceImpl();

        List<String> fileRows = fileService.readFile(INPUT_FILE);
        fruitService.createFruitsFromList(fileRows);
        fileService.writeToFile(REPORT_FILE);
    }

    private static void fillOperationMap(EnumMap<Operations, OperationsHandler> map) {
        map.put(Operations.BALANCE, new BalanceOperationsHandler());
        map.put(Operations.SUPPLY, new SupplyOperationsHandler());
        map.put(Operations.PURCHASE, new PurchaseOperationsHandler());
        map.put(Operations.RETURN, new ReturnOperationsHandler());
    }
}
