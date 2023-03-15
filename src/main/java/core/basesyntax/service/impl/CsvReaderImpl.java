package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.service.CsvReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

public class CsvReaderImpl implements CsvReader {
    private static final String OPERATION_CODE = "type";
    private static final String FRUIT_NAME = "fruit";
    private static final String QUANTITY = "quantity";

    @Override
    public List<FruitTransaction> readFromFile(String filePath) {
        List<FruitTransaction> result = new ArrayList<>();
        try (Reader in = new FileReader(filePath)) {
            CSVFormat csvFormat = CSVFormat.DEFAULT.builder()
                    .setHeader(OPERATION_CODE, FRUIT_NAME, QUANTITY)
                    .setSkipHeaderRecord(true)
                    .build();
            Iterable<CSVRecord> records = csvFormat.parse(in);
            for (CSVRecord record : records) {
                FruitTransaction transaction = new FruitTransaction();
                transaction.setOperation(Operation.getByCode(record.get(OPERATION_CODE)));
                transaction.setFruit(record.get(FRUIT_NAME));
                transaction.setQuantity(Integer.parseInt(record.get(QUANTITY)));
                result.add(transaction);
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read from file:" + filePath, e);
        }
        return result;
    }
}
