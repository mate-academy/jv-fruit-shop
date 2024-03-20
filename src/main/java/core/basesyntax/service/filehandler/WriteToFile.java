package core.basesyntax.service.filehandler;

import core.basesyntax.db.CurrentData;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteToFile {
    private final CurrentData currentData;

    public WriteToFile(CurrentData currentData) {
        this.currentData = currentData;
    }

    public void write(String filePath) {
        ReportGenerate reportGenerate = new ReportGenerate();
        StringBuilder reportBuilder = new StringBuilder(reportGenerate.createReport(currentData));

        File writeFile = new File(filePath);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(writeFile))) {
            writer.write(reportBuilder.toString());
        } catch (IOException e) {
            throw new RuntimeException("can't write to the file", e);
        }
    }
}
