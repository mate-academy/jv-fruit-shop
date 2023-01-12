package core.basesyntax.service.impl;

import core.basesyntax.service.CsvFileWriterService;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class CsvFileWriterServiceImpl implements CsvFileWriterService {

    @Override
    public void writerToFile(String filePath, String dataToAdd) {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath));
            bufferedWriter.write(dataToAdd);
            bufferedWriter.close();
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to file " + filePath, e);
        }
    }
}
