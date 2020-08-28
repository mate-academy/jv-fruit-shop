package core.basesyntax.readwritefile;

import core.basesyntax.maketransaction.Transaction;
import core.basesyntax.readwritefile.interfaces.IReadCsv;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public class ReadCsv implements IReadCsv {
    public static final CSVFormat CSV_FORMAT = CSVFormat.RFC4180.withHeader().withDelimiter(',');

    public ReadCsv() {
    }

    @Override
    public List<Transaction> readCsv(String pathName) {
        List<Transaction> transactions = new ArrayList<>();
        try (CSVParser csvReader = new CSVParser(new FileReader(pathName), CSV_FORMAT)) {
            for (CSVRecord csvRecord : csvReader) {
                Transaction transaction = new Transaction();
                transaction.setType(csvRecord.get("type"));
                transaction.setFruit(csvRecord.get("fruit"));
                transaction.setQuantity(Integer.parseInt(csvRecord.get("quantity")));
                transaction.setDate(csvRecord.get("date"));
                checkData(transaction);
                transactions.add(transaction);
            }
        } catch (FileNotFoundException exception) {
            System.out.println(("file " + pathName + " does not exist"));
        } catch (IOException exception) {
            System.out.println(("file " + pathName + " is not read"));
            exception.printStackTrace();
        }
        return transactions;
    }

    private void checkData(Transaction transaction) {
        if (!transaction.getType().equals("s")
                && !transaction.getType().equals("r")
                && !transaction.getType().equals("b")
                || transaction.getType().equals("")) {
            throw new IllegalArgumentException("Not correct type of operation"
                    + transaction.getType() + " in " + transaction.toString());
        }
        if (transaction.getFruit().equals("")) {
            throw new IllegalArgumentException("Not correct type of fruit"
                    + transaction.getType() + " in " + transaction.toString());
        }
        if (transaction.getDate().equals("")) {
            throw new IllegalArgumentException("Not correct date of fruit"
                    + transaction.getDate() + " in " + transaction.toString());
        }
        if (transaction.getQuantity() < 0) {
            throw new IllegalArgumentException("Not correct date of quantity of fruit"
                    + transaction.getQuantity() + " in "
                    + transaction.toString()
                    + " Should be more then 0");
        }
    }
}

