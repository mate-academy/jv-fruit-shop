package core.basesyntax;

import core.basesyntax.handlers.BalanceHandler;
import core.basesyntax.handlers.OperationHandler;
import core.basesyntax.handlers.PurchaseHandler;
import core.basesyntax.handlers.ReturnHandler;
import core.basesyntax.handlers.SupplyHandler;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.FruitTransaction.Operation;
import core.basesyntax.readandwriteimpl.CsvReaderImpl;
import core.basesyntax.readandwriteimpl.CsvWriterImpl;
import core.basesyntax.service.FruitTransactionParser;
import core.basesyntax.serviseimpl.DataProcessorImpl;
import core.basesyntax.serviseimpl.ReportGeneratorImpl;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String OUTPUT_FILE_PATH = "src/main/resources/output_file.csv";

    public static void main(String[] args) {
        CsvReaderImpl csvReader = new CsvReaderImpl();
        List<String> lines = csvReader.readDataFromFile();

        FruitTransactionParser parser = new FruitTransactionParser();
        List<FruitTransaction> transactions = parser.parse(lines);

        Map<String, Integer> fruitStore = new HashMap<>();

        Map<Operation, OperationHandler> operationStrategies = Map.of(
                Operation.BALANCE, new BalanceHandler(),
                Operation.SUPPLY, new SupplyHandler(),
                Operation.RETURN, new ReturnHandler(),
                Operation.PURCHASE, new PurchaseHandler());

        DataProcessorImpl dataProcessor = new DataProcessorImpl(operationStrategies);
        fruitStore = dataProcessor.processTransactions(transactions);

        ReportGeneratorImpl reportGenerator = new ReportGeneratorImpl(fruitStore);

        String report = reportGenerator.generateReport();

        CsvWriterImpl csvWriter = new CsvWriterImpl();
        csvWriter.writeLinesToFile(Arrays.asList(report.split("\n")), OUTPUT_FILE_PATH);
    }
}
