package core.basesyntax.model.dto.impl;

import core.basesyntax.model.dto.WriteToFile;

import java.io.FileWriter;
import java.io.IOException;

public class WriteToFileImpl implements WriteToFile {
    private static final String FILE_NAME = "Report.csv";

    @Override
    public void writeToFile(String report) {
        try (FileWriter fileWriter = new FileWriter("Report.csv", false)) {
            fileWriter.write(report);

        } catch (IOException e) {
            throw new RuntimeException("File not found" + FILE_NAME);
        }
    }
}
