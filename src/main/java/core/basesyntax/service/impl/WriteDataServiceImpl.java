package core.basesyntax.service.impl;

import core.basesyntax.service.WriteDataService;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteDataServiceImpl implements WriteDataService {
    @Override
    public void writeDataToFile(String data, String toFile) {
        File file = new File(toFile);
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {
            bufferedWriter.write(data);
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to file: " + toFile, e);
        }
    }
}
