package core.basesyntax.service.impl;

import core.basesyntax.service.WriterService;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class WriterServiceImpl implements WriterService {
    @Override
    public void writeFile(String filePath, String data) {
        File csvOutputFile = new File(filePath);
        try (PrintWriter pw = new PrintWriter(csvOutputFile)) {
            pw.print(data);
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Can't create file " + filePath);
        }
    }
}
