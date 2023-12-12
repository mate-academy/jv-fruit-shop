package core.basesyntax.service.impl;

import core.basesyntax.service.WriteFileService;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteFileServiceImpl implements WriteFileService {
    @Override
    public void writeFile(String report, String nameFile) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(nameFile, true))) {
            bufferedWriter.write(report);
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to file", e);
        }
    }
}
