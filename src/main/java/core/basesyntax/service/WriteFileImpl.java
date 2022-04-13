package core.basesyntax.service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class WriteFileImpl implements WriteFile {
    @Override
    public void writeFileReport(List<String> report, String filePath) {

        File file = new File(filePath);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (String line: report) {
                writer.write(line);
                writer.write(System.getProperty("line.separator"));
            }
        } catch (IOException e) {
            throw new RuntimeException(" Can`t create file" + filePath, e);
        }
    }
}
