package core.basesyntax.service.fileservice;

import java.io.BufferedWriter;
import java.io.IOException;

// Can't rename this this class to FileWriter. Conflict with io.FileWriter
public class ToFileWriter {
    public void writeToCsv(String report, String filename) {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new java.io.FileWriter(filename));
            bufferedWriter.write(report);
            bufferedWriter.close();
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file");
        }
    }
}
