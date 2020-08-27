package core.basesyntax.filesworking;

import com.opencsv.CSVReader;
import core.basesyntax.daily.Mapper;
import core.basesyntax.daily.Transaction;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileReader {
    public static List<Transaction> fileReading(String csvFile) throws FileNotFoundException {
        CSVReader reader;
        List<Transaction> transactions = new ArrayList<>();
        try {
            reader = new CSVReader(new java.io.FileReader(csvFile));
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
            throw new FileNotFoundException();
        }
    }
}
