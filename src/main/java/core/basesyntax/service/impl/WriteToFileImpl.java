package core.basesyntax.service.impl;

import core.basesyntax.service.WriteToFile;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class WriteToFileImpl implements WriteToFile {
    @Override
    public void writeReportToFile(String report, String fileName) {
        File file = new File(fileName);
        try {
            Files.write(file.toPath(), report.getBytes());
        } catch (IOException e) {
            throw new RuntimeException("Can't write report to file" + fileName, e);
        }
    }
}
