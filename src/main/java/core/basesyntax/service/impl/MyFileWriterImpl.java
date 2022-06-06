package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.MyFileWriter;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class MyFileWriterImpl implements MyFileWriter {
    public File writeReport() {
        File report = new File("src/main/resources/report.csv");
        try (BufferedWriter q = new BufferedWriter(new FileWriter(report))) {
            for (Map.Entry<String, Integer> entry : Storage.storage.entrySet()) {
                q.write(entry.getKey() + "," + entry.getValue() + System.lineSeparator());
            }
        } catch (IOException e) {
            throw new RuntimeException("Could not assess the file", e);
        }
        return report;
    }
}
