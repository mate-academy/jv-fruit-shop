package core.basesyntax.service.impl;

import core.basesyntax.service.ShopFileWriter;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ShopFileWriterCsvImpl implements ShopFileWriter {
    @Override
    public void writeToFile(String fileName, String lines) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName,true))) {
            bufferedWriter.write(lines);
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file " + fileName, e);
        }
    }
}
