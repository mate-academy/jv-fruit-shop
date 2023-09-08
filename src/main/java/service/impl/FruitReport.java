package service.impl;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import service.Report;

public class FruitReport implements Report {

    private List<String> report;

    public FruitReport(List<String> report) {
        this.report = report;
    }

    @Override
    public void writeToCsvFile(File file) {
        try (FileWriter fileWriter = new FileWriter(file)) {
            for (String s : report) {
                fileWriter.write(s);
            }
            fileWriter.flush();
        } catch (IOException e) {
            throw new RuntimeException("Can't write to the file " + file.getAbsolutePath(), e);
        }
    }

    @Override
    public void printReport() {
        report.forEach(System.out::println);
    }
}
