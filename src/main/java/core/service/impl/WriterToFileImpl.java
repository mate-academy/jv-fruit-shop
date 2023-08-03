package core.service.impl;

import core.service.WriterToFile;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class WriterToFileImpl implements WriterToFile {
    @Override
    public void writeToFileData(List<String> report, String filePath) {
        File file = new File(filePath);
        for (String data: report) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
                writer.write(data);
            } catch (IOException e) {
                throw new RuntimeException("Can't write report to file!");
            }
        }
    }
}
