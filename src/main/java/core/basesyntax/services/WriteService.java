package core.basesyntax.services;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class WriteService {

    public void writeFile(String toPath, String report) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(toPath, true))) {
            bufferedWriter.write(report);
        } catch (Exception e) {
            throw new RuntimeException("Can't write data to file " + report, e);
        }
    }
}
