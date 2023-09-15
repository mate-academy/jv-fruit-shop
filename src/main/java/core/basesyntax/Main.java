package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.service.DataProcessor;
import core.basesyntax.service.ReportTextGenerator;
import core.basesyntax.service.WriteService;
import core.basesyntax.serviceimpl.DataParserImpl;
import core.basesyntax.serviceimpl.DataProcessorImpl;
import core.basesyntax.serviceimpl.FileReaderImpl;
import core.basesyntax.serviceimpl.ReportTextGeneratorImpl;
import core.basesyntax.serviceimpl.WriteServiceImpl;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.handler.BalanceOperationHandler;
import core.basesyntax.strategy.handler.PurchaseOperationHandler;
import core.basesyntax.strategy.handler.ReturnOperationHandler;
import core.basesyntax.strategy.handler.SupplyOperationHandler;
import java.util.HashMap;
import java.util.List;

public class Main {
    private static final String REPORT_PATH = "src/main/resources/reports/";

    public static void main(String[] args) {
        FileReaderImpl reportReader = new FileReaderImpl();
        DataParserImpl dataProcessor = new DataParserImpl();
        HashMap<Operation, OperationStrategy> operationStrategyHashMap
                = new HashMap<>();
        operationStrategyHashMap.put(Operation.BALANCE, new BalanceOperationHandler());
        operationStrategyHashMap.put(Operation.PURCHASE, new PurchaseOperationHandler());
        operationStrategyHashMap.put(Operation.RETURN, new ReturnOperationHandler());
        operationStrategyHashMap.put(Operation.SUPPLY, new SupplyOperationHandler());
        DataProcessor reportGenerator = new DataProcessorImpl(operationStrategyHashMap);
        WriteService writeService = new WriteServiceImpl();
        ReportTextGenerator reportTextGenerator = new ReportTextGeneratorImpl();

        List<String> text = reportReader
                .getInputData(REPORT_PATH + "inputReport.csv");
        List<FruitTransaction> fruitTransactions = dataProcessor.getTransactions(text);
        reportGenerator.processData(fruitTransactions);
        writeService.writeReport(REPORT_PATH + "outputReport.csv",
                reportTextGenerator.generateTextReport());
    }
}
