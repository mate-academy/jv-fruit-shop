package core.basesyntax.impl;

import core.basesyntax.db.FruitShopDao;
import core.basesyntax.service.CantWorkWithThisFileException;
import core.basesyntax.service.WritingToNewFile;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WritingToNewFileImpl implements WritingToNewFile {
    private FruitShopDao fruitShopDao;

    public WritingToNewFileImpl(FruitShopDao fruitShopDao) {
        this.fruitShopDao = fruitShopDao;
    }

    @Override
    public void writing(String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write("fruit,quantity");
            writer.newLine();
            for (int i = 0; i < fruitShopDao.storageSize(); i++) {
                String line = fruitShopDao.getKeyAndValue().get(i);
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            throw new CantWorkWithThisFileException("We cant write to this file", e);
        }
    }
}
