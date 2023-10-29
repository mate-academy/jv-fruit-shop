package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.service.DataProcessorService;
import core.basesyntax.service.ReportTextGeneratorService;
import core.basesyntax.service.WriteService;
import core.basesyntax.serviceimpl.DataParserServiceImpl;
import core.basesyntax.serviceimpl.DataProcessorServiceImpl;
import core.basesyntax.serviceimpl.FileReaderServiceImpl;
import core.basesyntax.serviceimpl.ReportTextGeneratorServiceImpl;
import core.basesyntax.serviceimpl.WriteServiceImpl;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.handler.BalanceOperationHandler;
import core.basesyntax.strategy.handler.PurchaseOperationHandler;
import core.basesyntax.strategy.handler.ReturnOperationHandler;
import core.basesyntax.strategy.handler.SupplyOperationHandler;
import java.util.HashMap;
import java.util.List;

public class Main {
    private static final String INPUT_REPORT_PATH = "src/main/resources/reports/inputReport.csv";
    private static final String OUTPUT_REPORT_PATH = "src/main/resources/reports/outputReport.csv";

    public static void main(String[] args) {
        FileReaderServiceImpl reportReader = new FileReaderServiceImpl();
        DataParserServiceImpl dataProcessor = new DataParserServiceImpl();
        HashMap<Operation, OperationStrategy> operationStrategyHashMap
                = new HashMap<>();
        operationStrategyHashMap.put(Operation.BALANCE, new BalanceOperationHandler());
        operationStrategyHashMap.put(Operation.PURCHASE, new PurchaseOperationHandler());
        operationStrategyHashMap.put(Operation.RETURN, new ReturnOperationHandler());
        operationStrategyHashMap.put(Operation.SUPPLY, new SupplyOperationHandler());
        DataProcessorService reportGenerator =
                new DataProcessorServiceImpl(operationStrategyHashMap);
        WriteService writeService = new WriteServiceImpl();
        ReportTextGeneratorService reportTextGeneratorService =
                new ReportTextGeneratorServiceImpl();

        List<String> text = reportReader
                .getInputData(INPUT_REPORT_PATH);
        List<FruitTransaction> fruitTransactions = dataProcessor.getTransactions(text);
        reportGenerator.processData(fruitTransactions);
        writeService.writeReport(OUTPUT_REPORT_PATH,
                reportTextGeneratorService.generateTextReport());
    }
}
