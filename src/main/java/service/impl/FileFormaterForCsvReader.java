package service.impl;

import dao.CustomFileReader;
import java.util.ArrayList;
import java.util.List;

public class FileFormaterForCsvReader {
    private final CustomFileReader fileReaderService;

    public FileFormaterForCsvReader(CustomFileReader fileReaderService) {
        this.fileReaderService = fileReaderService;
    }

    public List<String[]> parseCsv(String filePath) {
        String fileContent = fileReaderService.readFile(filePath);
        List<String[]> data = new ArrayList<>();
        String[] lines = fileContent.split("\n");
        for (String line : lines) {
            data.add(line.split(","));
        }
        return data;
    }
}
