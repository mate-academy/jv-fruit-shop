package core.basesyntax.service.impl;

import core.basesyntax.service.MyFileWriter;
import java.io.FileWriter;
import java.io.IOException;

public class MyFileWriterImpl implements MyFileWriter {
    @Override
    public void writeToFile(String fileName, String data) {
        try (FileWriter fileWriter = new FileWriter(fileName)) {
            fileWriter.write(data);
        } catch (IOException e) {
            throw new RuntimeException("Can`t write to file : " + fileName, e);
        }
    }
}
