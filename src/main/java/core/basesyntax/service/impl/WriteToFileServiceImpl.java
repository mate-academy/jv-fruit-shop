package core.basesyntax.service.impl;

import core.basesyntax.service.WriteToFileService;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteToFileServiceImpl implements WriteToFileService {
    @Override
    public void writeToFile(String text, String toFileName) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(toFileName));) {
            bufferedWriter.write(text);
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file " + toFileName, e);
        }
    }
}
