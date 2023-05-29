package core.basesyntax.service.impl;

import core.basesyntax.service.CSVFileWriter;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import java.util.List;

public class FileWriterImpl implements CSVFileWriter {
    @Override
    public void writeFile(List<String> lines, String fileName) {
        File file = new File(fileName);
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {
            for (String line : lines) {
                bufferedWriter.write(line + System.lineSeparator());
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file. " + e);
        }
    }
}
