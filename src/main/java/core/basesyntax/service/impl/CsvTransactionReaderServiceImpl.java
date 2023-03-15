package core.basesyntax.service.impl;

import core.basesyntax.model.Operation;
import core.basesyntax.model.Product;
import core.basesyntax.model.Transaction;
import core.basesyntax.service.TransactionReaderService;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

public class CsvTransactionReaderServiceImpl implements TransactionReaderService {
    private static final String OPERATION_CODE = "type";
    private static final String PRODUCT_NAME = "fruit";
    private static final String QUANTITY = "quantity";

    @Override
    public List<Transaction> readFromFile(String filePath) {
        List<Transaction> result = new ArrayList<>();
        try (Reader in = new FileReader(filePath)) {
            CSVFormat csvFormat = CSVFormat.DEFAULT.builder()
                    .setHeader(OPERATION_CODE, PRODUCT_NAME, QUANTITY)
                    .setSkipHeaderRecord(true)
                    .build();
            Iterable<CSVRecord> records = csvFormat.parse(in);
            for (CSVRecord record : records) {
                Transaction transaction = new Transaction();
                transaction.setOperation(Operation.getByCode(record.get(OPERATION_CODE)));
                transaction.setProduct(new Product(record.get(PRODUCT_NAME),
                        Integer.parseInt(record.get(QUANTITY))));
                result.add(transaction);
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read from file:" + filePath, e);
        }
        return result;
    }
}
