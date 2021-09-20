package service.impl;

import db.Storage;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import service.FileWriterService;

public class FileWriterServiceImpl implements FileWriterService {
    private static final String REPORT_HEAD = "fruit,quantity";

    @Override
    public void writeToFile(String fileName) {
        StringBuilder stringBuilder = new StringBuilder(REPORT_HEAD);
        Storage.storage.forEach((key, value) -> stringBuilder.append(System.lineSeparator())
                .append(key.getName())
                .append(",")
                .append(value));
        String s = stringBuilder.toString();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(s);
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file " + fileName, e);
        }
    }

}
