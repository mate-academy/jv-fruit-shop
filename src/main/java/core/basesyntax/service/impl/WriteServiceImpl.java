package core.basesyntax.service.impl;

import core.basesyntax.service.WriteService;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteServiceImpl implements WriteService {

    @Override
    public void writeToFile(String fileName, String report) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName))) {
            bufferedWriter.write(report);
        } catch (IOException e) {
            throw new RuntimeException("Can't wright to file " + fileName, e);
        }
    }
}
