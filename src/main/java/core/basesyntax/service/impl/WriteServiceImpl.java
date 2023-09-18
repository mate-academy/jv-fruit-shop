package core.basesyntax.service.impl;

import core.basesyntax.service.service.WriteService;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteServiceImpl implements WriteService {
    @Override
    public void writeToFile(String report, String toFileName) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(toFileName))) {
            bufferedWriter.write(report);
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file " + toFileName);
        }
    }
}

