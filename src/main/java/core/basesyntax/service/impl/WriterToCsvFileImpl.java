package core.basesyntax.service.impl;

import core.basesyntax.service.WriterToCsvFile;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriterToCsvFileImpl implements WriterToCsvFile {
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
