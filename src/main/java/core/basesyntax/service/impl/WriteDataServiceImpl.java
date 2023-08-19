package core.basesyntax.service.impl;

import core.basesyntax.service.WriteDataService;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteDataServiceImpl implements WriteDataService {
    @Override
    public boolean writeData(String textFromFile, String filePath) {
        boolean isWritten = false;
        File file = new File(filePath);
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {
            bufferedWriter.write(textFromFile);
            isWritten = true;
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to the file " + file.getName(), e);
        }
        return isWritten;
    }
}
