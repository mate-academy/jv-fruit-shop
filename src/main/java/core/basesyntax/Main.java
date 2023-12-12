package core.basesyntax;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.BalanceService;
import core.basesyntax.service.OperationsStrategy;
import core.basesyntax.service.ReadFileService;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.WriteFileService;
import core.basesyntax.service.impl.BalanceServiceImpl;
import core.basesyntax.service.impl.OperationsStrategyImpl;
import core.basesyntax.service.impl.ReadFileServiceImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.service.impl.WriteFileServiceImpl;
import core.basesyntax.strategy.BalanceOperationHandler;
import core.basesyntax.strategy.DataOperationHandler;
import core.basesyntax.strategy.PurchaseOperationHandler;
import core.basesyntax.strategy.ReturnOperationHandler;
import core.basesyntax.strategy.SupplyOperationHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String INPUT_FILE_PATH = "src/main/resources/textInput.csv";
    private static final String OUTPUT_FILE_PATH = "src/main/resources/report.csv";

    public static void main(String[] args) {
        ReadFileService fileService = new ReadFileServiceImpl();
        List<Fruit> fruitList = fileService.readFile(INPUT_FILE_PATH);

        FruitDao fruitDao = new FruitDaoImpl();
        Map<Fruit.Operation, DataOperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(Fruit.Operation.BALANCE, new BalanceOperationHandler(fruitDao));
        operationHandlerMap.put(Fruit.Operation.PURCHASE, new PurchaseOperationHandler(fruitDao));
        operationHandlerMap.put(Fruit.Operation.RETURN, new ReturnOperationHandler(fruitDao));
        operationHandlerMap.put(Fruit.Operation.SUPPLY, new SupplyOperationHandler(fruitDao));

        OperationsStrategy dataOperationsStrategy = new OperationsStrategyImpl(operationHandlerMap);

        BalanceService balanceService = new BalanceServiceImpl(dataOperationsStrategy);
        balanceService.calculation(fruitList);

        ReportService reportService = new ReportServiceImpl();
        String report = reportService.getReport(Storage.report);

        WriteFileService writeFileService = new WriteFileServiceImpl();
        writeFileService.writeFile(report, OUTPUT_FILE_PATH);

    }
}
