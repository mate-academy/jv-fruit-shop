package core.basesyntax;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterSvc {
    public static void write(String src, String report) {
        try (FileWriter fileWriter = new FileWriter(src);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {

            bufferedWriter.write(report);

        } catch (IOException e) {
            throw new RuntimeException("Error writing to file: " + src, e);
        }
    }
}
