package core.basesyntax;

import core.basesyntax.enums.Operation;
import core.basesyntax.handler.TransactionHandler;
import core.basesyntax.handler.impl.BalanceTransactionHandler;
import core.basesyntax.handler.impl.PurchaseTransactionHandler;
import core.basesyntax.handler.impl.ReturnTransactionHandler;
import core.basesyntax.handler.impl.SupplyTransactionHandler;
import core.basesyntax.processing.RawDataProcessor;
import core.basesyntax.reader.CsvFileReader;
import core.basesyntax.report.CsvFileWriter;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String READING_FILE_PATH = "testData1.csv";
    private static final String WRITING_FILE_PATH = "src/main/resources/db/report.csv";

    public static void main(String[] args) {
        CsvFileReader csvFileReader = new CsvFileReader(READING_FILE_PATH);
        List<List<String>> rawData = csvFileReader.readTransactions();

        Map<String, TransactionHandler> transactionHandlerMap = Map.of(
                Operation.BALANCE.getCode(), new BalanceTransactionHandler(),
                Operation.SUPPLY.getCode(), new SupplyTransactionHandler(),
                Operation.PURCHASE.getCode(), new PurchaseTransactionHandler(),
                Operation.RETURN.getCode(), new ReturnTransactionHandler());

        RawDataProcessor rawDataProcessor = new RawDataProcessor(transactionHandlerMap);
        Map<String, Integer> processedData = rawDataProcessor.process(rawData);

        CsvFileWriter csvFileWriter = new CsvFileWriter(WRITING_FILE_PATH);
        csvFileWriter.writeReport(processedData);
    }
}
