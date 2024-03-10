package core.basesyntax.service.impl;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.CsvReaderService;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvReaderServiceImpl implements CsvReaderService {
    private static final int CODE = 0;
    private static final int FRUIT = 1;
    private static final int QUANTITY = 2;

    @Override
    public List<FruitTransaction> readCsv(String pathFile) {
        try (CSVReader reader =
                     new CSVReaderBuilder(new FileReader(pathFile)).withSkipLines(1).build()) {
            List<FruitTransaction> fruitTransactionList = new ArrayList<>();
            String[] record;
            while ((record = reader.readNext()) != null) {
                if (record.length != 3) {
                    throw new RuntimeException("Incorrect data!");
                }
                FruitTransaction currentFruit = new FruitTransaction(
                        record[CODE].equals("s")
                                ? FruitTransaction.Operation.SUPPLY
                                : record[CODE].equals("r") ? FruitTransaction.Operation.RETURN
                                : record[CODE].equals("p") ? FruitTransaction.Operation.PURCHASE
                                : FruitTransaction.Operation.BALANCE,
                        record[FRUIT],
                        Integer.parseInt(record[QUANTITY]));
                fruitTransactionList.add(currentFruit);
            }
            return fruitTransactionList;
        } catch (IOException e) {
            throw new RuntimeException("Can`t find file by this " + pathFile + " " + e);
        }
    }
}
