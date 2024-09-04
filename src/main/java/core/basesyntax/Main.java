package core.basesyntax;

import core.basesyntax.enums.Operation;
import core.basesyntax.handler.TransactionHandler;
import core.basesyntax.handler.impl.BalanceTransactionHandler;
import core.basesyntax.handler.impl.PurchaseTransactionHandler;
import core.basesyntax.handler.impl.ReturnTransactionHandler;
import core.basesyntax.handler.impl.SupplyTransactionHandler;
import core.basesyntax.reader.CsvFileReader;
import core.basesyntax.report.CsvFileWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String READING_FILE_PATH = "testData1.csv";
    private static final String WRITING_FILE_PATH = "src/main/resources/db/report.csv";
    private static final int ZERO_POSITION = 0;
    private static final int FIRST_POSITION = 1;
    private static final int SECOND_POSITION = 2;

    public static void main(String[] args) {
        CsvFileReader csvFileReader = new CsvFileReader(READING_FILE_PATH);
        List<List<String>> rawData = csvFileReader.readTransactions();

        Map<String, TransactionHandler> transactionHandlerMap = Map.of(
                Operation.BALANCE.getCode(), new BalanceTransactionHandler(),
                Operation.SUPPLY.getCode(), new SupplyTransactionHandler(),
                Operation.PURCHASE.getCode(), new PurchaseTransactionHandler(),
                Operation.RETURN.getCode(), new ReturnTransactionHandler());

        Map<String, Integer> processedData = rawDataParsing(rawData, transactionHandlerMap);
        CsvFileWriter csvFileWriter = new CsvFileWriter(WRITING_FILE_PATH);
        csvFileWriter.writeReport(processedData);

    }

    private static Map<String, Integer> rawDataParsing(List<List<String>> rawData, Map<String,
            TransactionHandler> transactionHandlerMap) {
        Map<String, Integer> mapFruitQuantity = new HashMap<>();

        rawData.forEach(it -> {
            String type = it.get(ZERO_POSITION);
            String key = it.get(FIRST_POSITION);
            int value = Integer.parseInt(it.get(SECOND_POSITION));

            TransactionHandler handler = transactionHandlerMap.get(type);

            if (handler != null) {
                handler.handleTransaction(mapFruitQuantity, key, value);
            }
        });

        return mapFruitQuantity;
    }
}
