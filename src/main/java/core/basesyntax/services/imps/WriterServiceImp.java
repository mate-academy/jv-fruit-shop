package core.basesyntax.services.imps;

import core.basesyntax.services.WriterService;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriterServiceImp implements WriterService {
    @Override
    public void writeToFile(String reportFile, String report) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(reportFile))) {
            bufferedWriter.write(report);
        } catch (IOException e) {
            throw new RuntimeException("Can not write to file " + reportFile, e);
        }
    }
}
