package core.basesyntax.dao;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class CsvReportHandler implements ReportHandler {

    @Override
    public List<String> read(String source) {
        File fileToRead = new File(source);
        List<String> strings;
        try {
            strings = Files.readAllLines(fileToRead.toPath());
        } catch (IOException e) {
            throw new RuntimeException("Can't read file " + source, e);
        }
        return strings;
    }

    @Override
    public boolean write(String fileName, String data) {
        File report = new File(fileName);
        boolean fileCreated;
        try {
            fileCreated = report.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException("Can't create file " + fileName, e);
        }
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(report))) {
            bufferedWriter.write(data);
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to file " + fileName, e);
        }
        return fileCreated;
    }
}
