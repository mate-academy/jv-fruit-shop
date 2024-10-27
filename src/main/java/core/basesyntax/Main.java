package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.service.DataConverter;
import core.basesyntax.service.FileReader;
import core.basesyntax.service.FileWriter;
import core.basesyntax.service.ReportGenerator;
import core.basesyntax.service.ShopService;
import core.basesyntax.service.impl.DataConverterImpl;
import core.basesyntax.service.impl.FileReaderImpl;
import core.basesyntax.service.impl.FileWriterImpl;
import core.basesyntax.service.impl.ReportGeneratorImpl;
import core.basesyntax.service.impl.ShopServiceImpl;
import core.basesyntax.stategy.BalanceHandler;
import core.basesyntax.stategy.FruitOperationHandler;
import core.basesyntax.stategy.OperationStrategy;
import core.basesyntax.stategy.OperationStrategyImpl;
import core.basesyntax.stategy.PurchaseOperation;
import core.basesyntax.stategy.ReturnOperation;
import core.basesyntax.stategy.SupplyOperation;
import core.basesyntax.validator.DataValidator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final DataValidator validator = new DataValidator();
    private static final Map<String, Integer> inventory = new HashMap<>();
    private static final FileReader FILE_READER = new FileReaderImpl();
    private static final DataConverter dataConverter = new DataConverterImpl(validator);
    private static final ReportGenerator reportGenerator = new ReportGeneratorImpl();
    private static final FileWriter fileWriter = new FileWriterImpl();
    private static final String INPUT_FILE_NAME = "reportToRead.csv";
    private static final String FINAL_REPORT_FILE_NAME = "finalReport.csv";

    public static void main(String[] arg) {
        List<String> inputReport = readDataFromFile(INPUT_FILE_NAME);
        List<FruitTransaction> transactions = convertToTransactions(inputReport);
        processTransactions(transactions);
        String resultingReport = generateReport();
        writeReportToFile(resultingReport, FINAL_REPORT_FILE_NAME);
    }

    private static List<String> readDataFromFile(String fileName) {
        return FILE_READER.read(fileName);
    }

    private static List<FruitTransaction> convertToTransactions(List<String> inputReport) {
        return dataConverter.convertToTransaction(inputReport);
    }

    private static void processTransactions(List<FruitTransaction> transactions) {
        Map<Operation, FruitOperationHandler> operationHandlers = new HashMap<>();
        operationHandlers.put(Operation.BALANCE, new BalanceHandler());
        operationHandlers.put(Operation.PURCHASE, new PurchaseOperation());
        operationHandlers.put(Operation.RETURN, new ReturnOperation());
        operationHandlers.put(Operation.SUPPLY, new SupplyOperation());

        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlers);
        ShopService shopService = new ShopServiceImpl(operationStrategy);
        shopService.processTransaction(transactions, inventory);
    }

    private static String generateReport() {
        return reportGenerator.generateReport(inventory);
    }

    private static void writeReportToFile(String report, String fileName) {
        fileWriter.write(report, fileName);
    }
}
