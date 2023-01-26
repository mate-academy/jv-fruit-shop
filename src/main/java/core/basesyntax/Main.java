package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataProcessForStorageService;
import core.basesyntax.service.FileReaderService;
import core.basesyntax.service.FileWriterService;
import core.basesyntax.service.FruitTransactionsCalculatorService;
import core.basesyntax.service.ReportBuilderService;
import core.basesyntax.service.impl.DataProcessForStorageImpl;
import core.basesyntax.service.impl.FileReaderServiceImpl;
import core.basesyntax.service.impl.FileWriterServiceImpl;
import core.basesyntax.service.impl.FruitTransactionsCalculatorServiceImpl;
import core.basesyntax.service.impl.ReportBuilderServiceImpl;
import core.basesyntax.strategy.operation.BalanceOperationHandlerImpl;
import core.basesyntax.strategy.operation.OperationHandler;
import core.basesyntax.strategy.operation.PurchaseOperationHandlerImpl;
import core.basesyntax.strategy.operation.ReturnOperationHandlerImpl;
import core.basesyntax.strategy.operation.SupplyOperationHandlerImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String inputFilePath = "src/main/resources/database.csv";
    private static final String reportFilePath = "src/main/resources/report.csv";

    public static void main(String[] args) {
        Map<FruitTransaction.Operation, OperationHandler> strategies = new HashMap<>();
        strategies.put(FruitTransaction.Operation.BALANCE, new BalanceOperationHandlerImpl());
        strategies.put(FruitTransaction.Operation.SUPPLY, new SupplyOperationHandlerImpl());
        strategies.put(FruitTransaction.Operation.PURCHASE, new PurchaseOperationHandlerImpl());
        strategies.put(FruitTransaction.Operation.RETURN, new ReturnOperationHandlerImpl());

        FileReaderService fileReaderService = new FileReaderServiceImpl();
        List<String> readData = fileReaderService.read(inputFilePath);

        DataProcessForStorageService dataProcess = new DataProcessForStorageImpl();
        dataProcess.processReadData(readData);

        FruitTransactionsCalculatorService calculator =
                new FruitTransactionsCalculatorServiceImpl();
        Map<String, Integer> fruitsAmounts = calculator.calculateMap(strategies);

        ReportBuilderService reportBuilderService = new ReportBuilderServiceImpl();
        String report = reportBuilderService.createReport(fruitsAmounts);

        FileWriterService fileWriterService = new FileWriterServiceImpl();
        fileWriterService.writeDataToFile(report, reportFilePath);
    }
}
