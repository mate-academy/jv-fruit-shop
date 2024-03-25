package mate.fruitshop.dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import mate.fruitshop.model.FruitTransaction;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

public class FruitTransactionDaoCsv implements FruitTransactionDao {
    public static final String INPUT_FILE_NAME = "src/main/resources/input.csv";
    public static final String OUTPUT_FILE_NAME = "src/main/resources/output.csv";
    public static final String OPERATION_TYPE = "type";
    public static final String FRUIT = "fruit";
    public static final String QUANTITY = "quantity";

    @Override
    public List<FruitTransaction> getAll() {
        Reader in = getFileReader();

        List<FruitTransaction> transactionList = new ArrayList<>();
        CSVFormat csvFormat = CSVFormat.DEFAULT.builder()
                .setHeader(OPERATION_TYPE, FRUIT, QUANTITY)
                .setSkipHeaderRecord(true)
                .build();
        try {
            Iterable<CSVRecord> records = csvFormat.parse(in);
            records.forEach(record -> transactionList.add(parseTransaction(record)));
        } catch (IOException e) {
            throw new RuntimeException("Can't parse file " + INPUT_FILE_NAME, e);
        }
        return transactionList;
    }

    @Override
    public void saveReport(String reportString) {
        try {
            Files.write(new File(OUTPUT_FILE_NAME).toPath(), reportString.getBytes());
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file " + OUTPUT_FILE_NAME, e);
        }
    }

    private Reader getFileReader() {
        try {
            return new FileReader(INPUT_FILE_NAME);
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Can't open file " + INPUT_FILE_NAME, e);
        }
    }

    private FruitTransaction parseTransaction(CSVRecord record) {
        FruitTransaction transaction = new FruitTransaction();
        transaction.setOperation(
                FruitTransaction.Operation.pickOperation(record.get(OPERATION_TYPE)));
        transaction.setFruit(record.get(FRUIT));
        transaction.setQuantity(Integer.parseInt(record.get(QUANTITY)));
        return transaction;
    }
}
