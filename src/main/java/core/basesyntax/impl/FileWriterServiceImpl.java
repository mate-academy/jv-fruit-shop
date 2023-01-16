package core.basesyntax.impl;

import core.basesyntax.service.FileWriterService;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class FileWriterServiceImpl implements FileWriterService {

    public void writeToFile(String report, String filePath) {
        File csvOutputFile = new File(filePath);
        try (PrintWriter pw = new PrintWriter(csvOutputFile)) {
            pw.write(report);
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Can't write data to file : " + filePath, e);
        }
    }
}
