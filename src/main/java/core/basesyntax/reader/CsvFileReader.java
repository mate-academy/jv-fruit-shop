package core.basesyntax.reader;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvValidationException;
import core.basesyntax.exceptions.FileWasNotReadException;
import core.basesyntax.handler.TransactionHandler;
import core.basesyntax.handler.impl.BalanceTransactionHandler;
import core.basesyntax.handler.impl.PurchaseTransactionHandler;
import core.basesyntax.handler.impl.ReturnTransactionHandler;
import core.basesyntax.handler.impl.SupplyTransactionHandler;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CsvFileReader {
    private final String filePath;
    private final Map<String, TransactionHandler> transactionHandlers = new HashMap<>();

    public CsvFileReader(String filePath) {
        this.filePath = filePath;
        transactionHandlers.put("b", new BalanceTransactionHandler());
        transactionHandlers.put("s", new SupplyTransactionHandler());
        transactionHandlers.put("p", new PurchaseTransactionHandler());
        transactionHandlers.put("r", new ReturnTransactionHandler());
    }

    public Map<String, Integer> readTransactions() {
        Map<String, Integer> mapFruitQuantity = new HashMap<>();
        CSVParser csvParser = new CSVParserBuilder()
                .withSeparator(',')
                .withIgnoreQuotations(true)
                .build();

        try (CSVReader csvReader = new CSVReaderBuilder(new FileReader(filePath))
                .withSkipLines(1)
                .withCSVParser(csvParser)
                .build()) {

            String[] nextLine;
            while ((nextLine = csvReader.readNext()) != null) {
                String type = nextLine[0];
                String key = nextLine[1];
                int value = Integer.parseInt(nextLine[2]);

                TransactionHandler handler = transactionHandlers.get(type);
                if (handler != null) {
                    handler.handleTransaction(mapFruitQuantity, key, value);
                }
            }
        } catch (IOException | CsvValidationException e) {
            throw new FileWasNotReadException(e.getMessage());
        }

        return mapFruitQuantity;
    }

}
