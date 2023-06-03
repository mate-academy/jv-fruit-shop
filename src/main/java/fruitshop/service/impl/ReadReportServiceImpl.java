package fruitshop.service.impl;

import fruitshop.service.ReadReportService;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class ReadReportServiceImpl implements ReadReportService {

    @Override
    public List<String> readReport(File file) {
        try {
            return Files.readAllLines(file.toPath());
        } catch (IOException e) {
            throw new RuntimeException("can't read data from file: " + file);
        }
    }
}
