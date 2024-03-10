package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.IFruitDao;
import core.basesyntax.service.IFileWriter;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterCvs implements IFileWriter {
    private final IFruitDao fruitDao = new FruitDao();

    @Override
    public void write(String path) {
        try (BufferedWriter buf = new BufferedWriter(new FileWriter(path, false))) {
            buf.write("fruit,quantity\n");
            for (int i = 0; i < fruitDao.getSize(); i++) {
                var fruit = fruitDao.getByIndex(i);
                buf.write(fruit.getName() + "," + fruit.getQuantity() + "\n");
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't write data in file");
        }
    }
}
