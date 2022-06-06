package core.basesyntax.service.impl;

import core.basesyntax.service.MyFileWriter;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class MyFileWriterImpl implements MyFileWriter {
    public File writeReport(List<String> info) {
        File report = new File("src/main/resources/report.csv");
        try (BufferedWriter q = new BufferedWriter(new FileWriter(report))) {
            for (String fruitAndAmount : info) {
                q.write(fruitAndAmount + System.lineSeparator());
            }
        } catch (IOException e) {
            throw new RuntimeException("Could not assess the file", e);
        }
        return report;
    }
}
