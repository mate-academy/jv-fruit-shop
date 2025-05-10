package core.basesyntax.writereport;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;

public class WriteReportImpl implements FileWriter {

    @Override
    public void writeToFile(String content, String path) {
        File file = new File(path);
        try (BufferedWriter bufferedWriter
                     = new BufferedWriter(new java.io.FileWriter(file))) {
            bufferedWriter.append(content);
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file: " + file.getName(), e);
        }
    }
}
