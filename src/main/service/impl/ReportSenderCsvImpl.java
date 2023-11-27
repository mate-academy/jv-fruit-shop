package main.service.impl;

import main.service.ReportSender;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ReportSenderCsvImpl implements ReportSender {
    private String filePath;

    public ReportSenderCsvImpl(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void send(String report) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(report);
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to file: " + filePath, e);
        }
    }
}
