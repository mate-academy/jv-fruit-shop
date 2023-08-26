package service.dao;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class ReadFileImpl implements ReadFile {

    @Override
    public List<String> readFromFileToList(File fileFrom, List<String> report) {
        try {
            report = Files.readAllLines(fileFrom.toPath());
        } catch (IOException e) {
            throw new RuntimeException("Can't read file :" + fileFrom, e);
        }
        report.remove(0);
        return report;
    }
}

