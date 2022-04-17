package core.basesyntax.service.impl;

import core.basesyntax.service.WriteToFileService;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteToFileImpl implements WriteToFileService {
    @Override
    public void writeDataToFile(String toFileName, String dataReport) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(toFileName, true))) {
            bufferedWriter.write(dataReport);
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to file" + toFileName, e);
        }
    }
}

