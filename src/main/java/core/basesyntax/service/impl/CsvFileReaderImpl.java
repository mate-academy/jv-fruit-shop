package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitTransactionDao;
import core.basesyntax.dao.impl.FruitTransactionDaoImpl;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.CsvFileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class CsvFileReaderImpl implements CsvFileReader {
    private static final int FIRST_SCV_VALUE_INDEX = 1;
    private static final String CSV_SPLITTER = ",";
    private static final int OPERATION_INDEX = 0;
    private static final int PRODUCT_NAME_INDEX = 1;
    private static final int AMOUNT_INDEX = 2;

    @Override
    public List<FruitTransaction> readFile(Path csvFile) {
        List<String> dataList;
        try {
            dataList = Files.readAllLines(csvFile);
        } catch (IOException e) {
            throw new RuntimeException("Can`t get data from file");
        }
        return saveData(dataList);
    }

    private List<FruitTransaction> saveData(List<String> fruitTransactionList) {
        FruitTransactionDao fruitTransactionDao = new FruitTransactionDaoImpl();
        for (int i = FIRST_SCV_VALUE_INDEX; i < fruitTransactionList.size(); i++) {
            String[] singleDataLine = fruitTransactionList.get(i).split(CSV_SPLITTER);
            fruitTransactionDao.add(
                    new FruitTransaction(
                            FruitTransaction.Operation
                                    .valueOfLabel(singleDataLine[OPERATION_INDEX]),
                            new Fruit(singleDataLine[PRODUCT_NAME_INDEX],
                                    Integer.parseInt(singleDataLine[AMOUNT_INDEX]))));
        }
        return fruitTransactionDao.getAll();
    }

}
