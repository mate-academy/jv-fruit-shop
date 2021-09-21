package service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Collections;
import java.util.List;

public class WriterServiceImpl implements WriterService {
    private static final String FILE_HEADER = "fruit,amount";

    @Override
    public void writeReportToCsv(List<String> report, String filepath) {

        Path file = Paths.get(filepath);
        try {
            Files.write(file, Collections.singleton(FILE_HEADER));
            Files.write(file, report, StandardOpenOption.APPEND);
            System.out.println("New report created successfully!");
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file");
        }
    }
}
