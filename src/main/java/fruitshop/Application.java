package fruitshop;

import fruitshop.db.ReportStorage;
import fruitshop.db.TransactionStorage;
import fruitshop.model.Operation;
import fruitshop.service.file.WriteDataToStorageService;
import fruitshop.service.impl.*;
import fruitshop.strategy.AdditionHandler;
import fruitshop.strategy.BalanceHandler;
import fruitshop.strategy.StrategyService;
import fruitshop.strategy.SubtractionHandler;
import java.util.HashMap;
import java.util.Map;

public class Application {
    private static final WriteDataToStorageService writeServiceImpl = new WriteDataToStorageImpl();
    private static final FileReadServiceImpl fileReadService = new FileReadServiceImpl(writeServiceImpl);
    private static final FileWriteServiceImpl fileWriteService = new FileWriteServiceImpl();
    private static final ProcessDataImpl processData = new ProcessDataImpl();
    private static final GenerateReportDataImpl generateReportData = new GenerateReportDataImpl();
    private static final TransactionStorage transactionStorage = new TransactionStorage();
    private static final ReportStorage reportStorage = new ReportStorage();
    private final Map<Operation, StrategyService> operationsMap = new HashMap<>();

    public static void main(String[] args) {
        String fileInput = "input.csv";
        String fileOut = "out.csv";
        Application application = new Application();
        application.generateReportToFile(fileInput, fileOut);
    }

    private void generateReportToFile(String fileInput, String fileOut) {
        strategyInit();
        fileReadService.readDataFromFile(fileInput);
        processData.process(transactionStorage.getAll(),operationsMap);
        String report = generateReportData.report(reportStorage.getAll());
        fileWriteService.writeDataToFile(report, fileOut);
    }

    private void strategyInit() {
        operationsMap.put(Operation.BALANCE, new BalanceHandler());
        operationsMap.put(Operation.RETURN, new AdditionHandler());
        operationsMap.put(Operation.SUPPLY, new AdditionHandler());
        operationsMap.put(Operation.PURCHASE, new SubtractionHandler());
    }
}
