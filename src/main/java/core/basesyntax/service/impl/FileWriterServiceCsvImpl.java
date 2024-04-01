package core.basesyntax.service.impl;

import core.basesyntax.exception.WriteToFileCsvException;
import core.basesyntax.service.FileWriterService;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterServiceCsvImpl implements FileWriterService {
    @Override
    public void writeData(String filePath, String data) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath))) {
            bufferedWriter.write(data);
        } catch (IOException e) {
            throw new WriteToFileCsvException("Can't write to csv file " + filePath, e);
        }
    }
}
