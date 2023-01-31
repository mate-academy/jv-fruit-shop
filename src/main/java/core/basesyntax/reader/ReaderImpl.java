package core.basesyntax.reader;

import core.basesyntax.model.Transaction;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedList;
import java.util.List;

public class ReaderImpl implements Reader {
    private static final String SPLITTER = ",";
    private static final String TYPE_COLUMN = "type";
    private static final String NAME_COLUMN = "fruit";
    private static final String QUANTITY_COLUMN = "quantity";
    private static final int TITLE_INDEX = 0;

    private int typeColumnIndex = -1;
    private int nameColumnIndex = -1;
    private int quantityColumnIndex = -1;

    @Override
    public List<Transaction> read(String filePath) {
        try {
            List<String> records = Files.readAllLines(Path.of(filePath));
            String[] titles = records.remove(TITLE_INDEX).split(SPLITTER);
            for (int i = 0; i < titles.length; ++i) {
                if (TYPE_COLUMN.equals(titles[i])) {
                    typeColumnIndex = i;
                }
                if (NAME_COLUMN.equals(titles[i])) {
                    nameColumnIndex = i;
                }
                if (QUANTITY_COLUMN.equals(titles[i])) {
                    quantityColumnIndex = i;
                }
            }
            if (~typeColumnIndex == 0 || ~nameColumnIndex == 0 || ~quantityColumnIndex == 0) {
                throw new RuntimeException("File " + filePath
                        + " does not contain mandatory columns.");
            }
            List<Transaction> transactionList = new LinkedList<>();
            for (String record : records) {
                String[] splitRecord = record.split(SPLITTER);
                transactionList.add(new Transaction(
                        splitRecord[typeColumnIndex],
                        splitRecord[nameColumnIndex],
                        Integer.valueOf(splitRecord[quantityColumnIndex])
                ));
            }

            return transactionList;
        } catch (IOException e) {
            throw new RuntimeException("Error reading from file: " + filePath);
        }
    }
}
