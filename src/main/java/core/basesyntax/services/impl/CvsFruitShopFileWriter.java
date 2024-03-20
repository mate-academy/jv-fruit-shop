package core.basesyntax.services.impl;

import core.basesyntax.services.FruitShopFileWriter;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class CvsFruitShopFileWriter implements FruitShopFileWriter {
    @Override
    public void write(String data, String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(data);
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file " + e);
        }
    }
}
