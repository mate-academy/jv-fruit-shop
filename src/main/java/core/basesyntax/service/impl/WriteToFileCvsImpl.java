package core.basesyntax.service.impl;

import core.basesyntax.service.WriteToFileCvs;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteToFileCvsImpl implements WriteToFileCvs {

    @Override
    public void writeReport(String toFilePath, String report) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(toFilePath))) {
            bufferedWriter.write(report);
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to file!", e);
        }
    }
}
