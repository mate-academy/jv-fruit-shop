package core.basesyntax.impl;

import core.basesyntax.service.FileWriteService;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriteServiceImpl implements FileWriteService {

    @Override
    public void writeToFile(String report, String toFileName) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(toFileName))) {
            bufferedWriter.write(report);
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file " + toFileName);
        }
    }
}
