package core.basesyntax.service;

import core.basesyntax.dao.FruitStorageDao;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriterServiceImpl implements WriterService {
    private FruitStorageDao fruitStorageDao;

    public WriterServiceImpl(FruitStorageDao fruitStorageDao) {
        this.fruitStorageDao = fruitStorageDao;
    }

    @Override
    public boolean writeToFile(String fileName) {
        File file = new File(fileName);
        try {
            file.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException("Can't write a new file", e);
        }

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, false));) {
            fruitStorageDao.getFruitList()
                    .forEach(fruit -> {
                        try {
                            bufferedWriter.write(fruit.getName() + "," + fruit.getQuantity());
                            bufferedWriter.newLine();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to file", e);
        }

        return true;
    }
}
