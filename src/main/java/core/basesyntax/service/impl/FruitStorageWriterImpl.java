package core.basesyntax.service.impl;

import core.basesyntax.db.FruitShopDao;
import core.basesyntax.service.CantWorkWithThisFileException;
import core.basesyntax.service.FruitStorageWriter;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FruitStorageWriterImpl implements FruitStorageWriter {
    private final FruitShopDao fruitShopDao;

    public FruitStorageWriterImpl(FruitShopDao fruitShopDao) {
        this.fruitShopDao = fruitShopDao;
    }

    @Override
    public void writeReportToFile(String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write("fruit,quantity");
            writer.newLine();
            for (int i = 0; i < fruitShopDao.getStorageSize(); i++) {
                String line = fruitShopDao.getAllFruitsWithQuantities().get(i);
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            throw new CantWorkWithThisFileException("We cant write to file: " + filePath, e);
        }
    }
}
