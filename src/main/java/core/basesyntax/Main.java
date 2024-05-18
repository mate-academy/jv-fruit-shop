package core.basesyntax;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.model.Operation;
import core.basesyntax.service.FileService;
import core.basesyntax.service.FileServiceImpl;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.FruitServiceImpl;
import core.basesyntax.service.operation.BalanceOperationHandler;
import core.basesyntax.service.operation.OperationHandler;
import core.basesyntax.service.operation.OperationStrategy;
import core.basesyntax.service.operation.OperationStrategyImpl;
import core.basesyntax.service.operation.PurchaseOperationHandler;
import core.basesyntax.service.operation.ReturnOperationHandler;
import core.basesyntax.service.operation.SupplyOperationHandler;
import java.util.EnumMap;
import java.util.List;

public class Main {
    private static final String REPORT_FILE = "report.csv";
    private static final String INPUT_FILE = "input.csv";

    public static void main(String[] args) {
        EnumMap<Operation, OperationHandler> operationHandlerMap
                = new EnumMap<>(Operation.class);
        fillOperationMap(operationHandlerMap);

        FruitDao fruitDao = new FruitDaoImpl();
        OperationStrategy strategy = new OperationStrategyImpl(operationHandlerMap);
        FruitService fruitService = new FruitServiceImpl(fruitDao, strategy);
        FileService fileService = new FileServiceImpl();

        List<String> fileRows = fileService.readFile(INPUT_FILE);
        fruitService.createFruitsFromList(fileRows);
        fileService.writeToFile(REPORT_FILE);
    }

    private static void fillOperationMap(EnumMap<Operation, OperationHandler> map) {
        map.put(Operation.BALANCE, new BalanceOperationHandler());
        map.put(Operation.SUPPLY, new SupplyOperationHandler());
        map.put(Operation.PURCHASE, new PurchaseOperationHandler());
        map.put(Operation.RETURN, new ReturnOperationHandler());
    }
}
