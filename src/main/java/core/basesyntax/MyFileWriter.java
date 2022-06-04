package core.basesyntax;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class MyFileWriter {
    public void writeReport(List<String> info) {
        File report = new File("report");
        try (BufferedWriter q = new BufferedWriter(new FileWriter(report))) {
            report.createNewFile();
            for (String fruitAndAmount : info) {
                q.write(fruitAndAmount + System.lineSeparator());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
