package core.basesyntax;

import core.basesyntax.handlers.BalanceOperationHandler;
import core.basesyntax.handlers.OperationHandler;
import core.basesyntax.handlers.PurchaseOperationHandler;
import core.basesyntax.handlers.ReturnOperationHandler;
import core.basesyntax.handlers.SupplyOperationHandler;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.service.DataFileProcessing;
import core.basesyntax.service.FileReader;
import core.basesyntax.service.FileWriter;
import core.basesyntax.service.Parser;
import core.basesyntax.service.ReportGenerator;
import core.basesyntax.service.impl.CsvFileReader;
import core.basesyntax.service.impl.CsvFileWriter;
import core.basesyntax.service.impl.CsvReportGenerator;
import core.basesyntax.service.impl.DataFileProcessingImpl;
import core.basesyntax.service.impl.ParserImpl;
import core.basesyntax.strategy.OperationStrategy;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String FILE_FROM = "src/main/resources/file.csv";
    private static final String FILE_TO = "src/main/resources/file2.csv";

    public static void main(String[] args) {
        Map<Operation, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(Operation.BALANCE, new BalanceOperationHandler());
        operationHandlerMap.put(Operation.PURCHASE, new PurchaseOperationHandler());
        operationHandlerMap.put(Operation.RETURN, new ReturnOperationHandler());
        operationHandlerMap.put(Operation.SUPPLY, new SupplyOperationHandler());

        String report = getString(operationHandlerMap);

        FileWriter fileWriter = new CsvFileWriter();
        fileWriter.writeToFile(report,FILE_TO);
    }

    private static String getString(Map<Operation, OperationHandler> operationHandlerMap) {
        FileReader fileReader = new CsvFileReader();
        List<String> fileData = fileReader.readFile(FILE_FROM);

        Parser parser = new ParserImpl();
        List<FruitTransaction> fruitTransactions = parser.parseListToTransactionList(fileData);

        OperationStrategy operationStrategy = new OperationStrategy(operationHandlerMap);

        DataFileProcessing dataFileProcessing = new DataFileProcessingImpl(operationStrategy);
        dataFileProcessing.processData(fruitTransactions);

        ReportGenerator reportGenerator = new CsvReportGenerator();
        return reportGenerator.generateReport();
    }
}
