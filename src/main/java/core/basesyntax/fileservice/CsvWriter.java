package core.basesyntax.fileservice;

import core.basesyntax.reportcreator.CsvReporter;
import core.basesyntax.reportcreator.ReportCreator;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CsvWriter implements Writer {
    @Override
    public void writeToFile(String fileName, List<String> data) {
        try (FileWriter writer = new FileWriter(fileName, false)) {
            ReportCreator csvReporter = new CsvReporter();
            writer.write(csvReporter.createReport(data));
            writer.flush();
        } catch (IOException ex) {
            throw new RuntimeException("Can`t write to file!");
        }
    }
}
