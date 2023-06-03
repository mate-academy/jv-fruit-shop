package fruitshop.service.impl;

import fruitshop.service.ReadReport;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class ReadReportImpl implements ReadReport {
    private File file;
    private List<String> text;

    public ReadReportImpl(File file) {
        this.file = file;
    }

    @Override
    public List<String> readReport() {
        try {
            return Files.readAllLines(file.toPath());
        } catch (IOException e) {
            throw new RuntimeException("can't read data from file: " + file);
        }
    }
}
