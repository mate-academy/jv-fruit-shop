package core.service.impl;

import core.service.WriterService;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class WriterServiceImpl implements WriterService {
    @Override
    public void writeToFile(List<String> report, String reportFileName) {
        File file = new File(reportFileName);
        try {
            Files.write(file.toPath(), report);
        } catch (IOException e) {
            throw new RuntimeException("Can`t write file", e);
        }
    }
}
