package core.basesyntax.report;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class FileWriterImpl implements FileWriter {
    @Override
    public void writeToFile(List<String> reportList, String toFileName) {
        File toFile = new File(toFileName);
        try {
            toFile.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException("Can't create file " + toFileName, e);
        }
        try (BufferedWriter bufferedWriter = new BufferedWriter(new java.io.FileWriter(toFile))) {
            for (String report : reportList) {
                bufferedWriter.write(report);
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to file " + toFileName, e);
        }
    }
}
