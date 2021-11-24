package core.basesyntax.service.impl;

import core.basesyntax.service.FruitShopWriter;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FruitShopWriterImpl implements FruitShopWriter {
    @Override
    public void write(String report, String fileName) {
        File file = new File(fileName);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            file.createNewFile();
            writer.write(report);
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to file", e);
        }
    }
}
