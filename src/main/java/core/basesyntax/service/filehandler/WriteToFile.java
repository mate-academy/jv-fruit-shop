package core.basesyntax.service.filehandler;

import core.basesyntax.db.ChangedData;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteToFile {
    private ChangedData changedData;

    public WriteToFile(ChangedData changedData) {
        this.changedData = changedData;
    }

    public void write(String filePath) {
        Report report = new Report();
        StringBuilder reportBuilder = new StringBuilder(report.createReport(changedData));

        File writeFile = new File(filePath);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(writeFile))) {
            writer.write(reportBuilder.toString());
        } catch (IOException e) {
            throw new RuntimeException("can't write to the file", e);
        }
    }
}
