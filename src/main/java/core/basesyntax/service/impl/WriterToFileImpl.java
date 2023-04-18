package core.basesyntax.service.impl;

import core.basesyntax.service.WriterToFile;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriterToFileImpl implements WriterToFile {
    @Override
    public void writeToFile(String toFileName, String report) {
        File reportFile = new File(toFileName);
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(reportFile))) {
            bufferedWriter.write(report);
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to file by path" + reportFile, e);
        }
    }
}
