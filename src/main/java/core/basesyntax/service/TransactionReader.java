package core.basesyntax.service;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import core.basesyntax.model.Transaction;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class TransactionReader {

    public List<Transaction> getTransactionList(String filePath) {
        List<Transaction> items;

        try (Reader reader = Files.newBufferedReader((Paths.get(filePath)))) {
            CsvToBean csvToBean = new CsvToBeanBuilder(reader)
                    .withType(Transaction.class)
                    .build();
            items = csvToBean.parse();
        } catch (IOException e) {
            throw new RuntimeException("Such file not found!");
        }
        return items;
    }
}
