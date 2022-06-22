package service.impl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import service.WriteReport;

public class WriteReportImpl implements WriteReport {
    @Override
    public void fruitsReport(List<String> report, String path) {
        File file = new File(path);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (String r: report) {
                writer.write(r);
                writer.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Invalid file name " + e);
        }

    }
}
