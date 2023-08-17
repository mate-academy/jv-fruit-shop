package core.basesyntax.service;

import java.io.IOException;
import java.io.PrintWriter;

public class WriterServiceImpl implements WriterService {
    @Override
    public void writeToFile(String strReport, String fileName) {
        try (PrintWriter pw = new PrintWriter(fileName)) {
            pw.write(strReport);
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to file " + fileName);
        }
    }
}
