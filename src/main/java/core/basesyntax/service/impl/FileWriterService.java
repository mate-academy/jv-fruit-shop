package core.basesyntax.service.impl;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterService implements core.basesyntax.service.FileWriterService {
    @Override
    public void writeToFile(String toFileName, String report) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(toFileName))) {
            bufferedWriter.write(String.valueOf(report));
        } catch (IOException e) {
            throw new RuntimeException("Can`t write data to file" + toFileName, e);
        }
    }
}
