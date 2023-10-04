package core.basesyntax.service.impl;

import core.basesyntax.exceptions.WriteDataToFileException;
import core.basesyntax.service.FileWriterService;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CsvFileWriterService implements FileWriterService {

    @Override
    public void writeDataToFile(String data, String fileName) {
        File fileTo = new File(fileName);
        if (!fileTo.exists() && fileTo.isDirectory()) {
            fileTo.mkdirs();
        }
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileTo))) {
            bufferedWriter.write(data);
        } catch (IOException e) {
            throw new WriteDataToFileException("Can't write db to file" + fileName, e);
        }
    }
}
