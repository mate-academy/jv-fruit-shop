package core.basesyntax;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.db.Storage;
import core.basesyntax.handler.BalanceOperationHandler;
import core.basesyntax.handler.DataOperationHandler;
import core.basesyntax.handler.PurchaseOperationHandler;
import core.basesyntax.handler.ReturnOperationHandler;
import core.basesyntax.handler.SupplyOperationHandler;
import core.basesyntax.model.Fruit;
import core.basesyntax.reader.FileReaderService;
import core.basesyntax.reader.FileReaderServiceImpl;
import core.basesyntax.service.BalanceService;
import core.basesyntax.service.OperationsStrategy;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.impl.BalanceServiceImpl;
import core.basesyntax.service.impl.OperationsStrategyImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.writer.FileWriterService;
import core.basesyntax.writer.FileWriterServiceImp;
import java.util.HashMap;
import java.util.Map;

public class Main {
    private static final String INPUT_FILE_PATH = "src/main/resources/textInput.csv";
    private static final String OUTPUT_FILE_PATH = "src/main/resources/report.csv";
    private static Map<Fruit.Operation, DataOperationHandler>
            operationHandlerMap = new HashMap<>();

    public static void main(String[] args) {
        FruitDao fruitDao = new FruitDaoImpl();

        operationHandlerMap = Map.of(
                Fruit.Operation.BALANCE, new BalanceOperationHandler(fruitDao),
                Fruit.Operation.PURCHASE, new PurchaseOperationHandler(fruitDao),
                Fruit.Operation.RETURN, new ReturnOperationHandler(fruitDao),
                Fruit.Operation.SUPPLY, new SupplyOperationHandler(fruitDao)
        );

        OperationsStrategy dataOperationsStrategy = new OperationsStrategyImpl(operationHandlerMap);

        FileReaderService fileService = new FileReaderServiceImpl();
        BalanceService balanceService = new BalanceServiceImpl(dataOperationsStrategy);
        balanceService.calculation(fileService.readFile(INPUT_FILE_PATH));

        ReportService reportService = new ReportServiceImpl();
        Storage storage = new Storage();
        String report = reportService.getReport(storage.getReportMap());

        FileWriterService writeFileService = new FileWriterServiceImp();
        writeFileService.writeFile(report, OUTPUT_FILE_PATH);
    }
}
