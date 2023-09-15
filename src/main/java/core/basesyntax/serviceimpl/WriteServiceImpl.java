package core.basesyntax.serviceimpl;

import core.basesyntax.service.WriteService;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteServiceImpl implements WriteService {

    @Override
    public void writeReport(String reportName, String reportText) {
        try (BufferedWriter bufferedWriter =
                     new BufferedWriter(new FileWriter(reportName))) {
            bufferedWriter.write(reportText);
        } catch (IOException e) {
            throw new RuntimeException("Can't write this file: " + reportName, e);
        }
    }
}
