package core.basesyntax.service;

import core.basesyntax.exception.WriteFileException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class CsvFileWriter implements FilesWriter {
    @Override
    public void write(String data, String fileName) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName))) {
            bufferedWriter.write(data);
        } catch (IOException e) {
            throw new WriteFileException("Can't write data at file " + fileName);
        }
    }
}
