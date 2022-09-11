package core.basesyntax.service.impl;

import core.basesyntax.service.FileWriter;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;

public class FileWriteServiceImpl implements FileWriter {
    @Override
    public void writeData(String data, String fileName) {
        File file = new File(fileName);
        try (BufferedWriter bufferedWriter = new BufferedWriter(new java.io.FileWriter(file))) {
            file.createNewFile();
            bufferedWriter.write(data);
        } catch (IOException e) {
            throw new RuntimeException("Can't create file or write data to file!", e);
        }
    }
}
