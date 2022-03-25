package core.basesyntax.db;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class WriteFileImpl implements WriteFile {
    @Override
    public void writeFileReport(List<String> report, String filePath) {

        File outFile = new File(filePath);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outFile))) {
            for (String line: report) {
                writer.write(line);
                writer.write(System.getProperty("line.separator"));
            }
        } catch (IOException e) {
            throw new RuntimeException(" Can`t create file" + filePath, e);
        }
    }
}
