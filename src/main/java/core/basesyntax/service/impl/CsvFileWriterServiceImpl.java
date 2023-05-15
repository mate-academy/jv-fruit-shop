package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitTransactionDao;
import core.basesyntax.dao.impl.FruitTransactionDaoImpl;
import core.basesyntax.service.CsvFileWriterService;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CsvFileWriterServiceImpl implements CsvFileWriterService {
    private static final String DATA_OUTPUT = "fruit,quantity";
    private final FruitTransactionDao fruitTransactionDao = new FruitTransactionDaoImpl();

    @Override
    public void writeToFile(String filePath) {
        try (BufferedWriter bufferedWriter =
                     new BufferedWriter(new FileWriter(new File(filePath)))) {
            bufferedWriter.write(DATA_OUTPUT
                    + System.lineSeparator()
                    + fruitTransactionDao.getAllData());
        } catch (IOException e) {
            throw new RuntimeException("Error... can't write file " + filePath);
        }
    }
}
