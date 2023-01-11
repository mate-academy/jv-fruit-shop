package core.basesyntax.impl;

import core.basesyntax.service.FileWriterService;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;

public class FileWriterServiceImpl implements FileWriterService {

    @Override
    public void parse(List<String[]> report, String filePath) {
        File csvOutputFile = new File(filePath);
        try (PrintWriter pw = new PrintWriter(csvOutputFile)) {
            report.stream()
                    .map(this::convertToCsv)
                    .forEach(pw::println);
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Can't find file by path: " + filePath, e);
        }
    }

    private String convertToCsv(String[] data) {
        return String.join(",", data);
    }

}
