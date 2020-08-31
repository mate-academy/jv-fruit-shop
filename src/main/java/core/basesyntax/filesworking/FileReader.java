package core.basesyntax.filesworking;

import com.opencsv.CSVReader;
import core.basesyntax.daily.Mapper;
import core.basesyntax.daily.Transaction;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileReader {
    public static List<Transaction> fileReading(String csvFile) throws IOException {
        List<Transaction> transactions = new ArrayList<>();
        try (CSVReader reader = new CSVReader(new java.io.FileReader(csvFile))) {
            String[] line;
            if (reader.readNext() == null) {
                throw new RuntimeException("File has no data");
            }
            while ((line = reader.readNext()) != null) {
                Mapper transactionMapper = new Mapper();
                transactions.add(transactionMapper.convert(line));
            }
            return transactions;
        } catch (IOException e) {
            throw new RuntimeException("No such file", e);
        }
    }
}
