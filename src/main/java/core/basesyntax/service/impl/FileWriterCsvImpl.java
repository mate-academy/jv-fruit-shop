package core.basesyntax.service.impl;

import core.basesyntax.service.FileWriterCsv;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FileWriterCsvImpl implements FileWriterCsv {

    @Override
    public void write(String fileName, List<String> report) {
        File targetFile = new File(fileName);
        targetFile.delete();
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName, true))) {
            for (String line :report) {
                bufferedWriter.append(line);
                bufferedWriter.append(System.lineSeparator());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

