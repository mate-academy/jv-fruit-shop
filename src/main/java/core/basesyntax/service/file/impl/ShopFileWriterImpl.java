package core.basesyntax.service.file.impl;

import core.basesyntax.service.file.ShopFileWriter;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class ShopFileWriterImpl implements ShopFileWriter {
    @Override
    public void write(String data, String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(data);
        } catch (Exception e) {
            throw new RuntimeException("Can't write file by path: " + fileName, e);
        }
    }
}
