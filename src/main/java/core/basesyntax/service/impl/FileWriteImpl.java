package core.basesyntax.service.impl;

import core.basesyntax.service.FileWrite;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriteImpl implements FileWrite {
    @Override
    public void write(String report, String fileName) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName))) {
            bufferedWriter.write(report);
        } catch (IOException ioException) {
            throw new RuntimeException("Can`t write data to file" + fileName, ioException);
        }
    }
}
