package service.impl;

import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import service.FileService;

public class FileServiceImpl implements FileService {
    @Override
    public List<String> readFromFile(String fromFileName) {
        List<String> dataFromFile;
        try {
            dataFromFile = Files.readAllLines(Path.of(fromFileName));
        } catch (Exception e) {
            throw new RuntimeException("Can`t read from file " + fromFileName, e);
        }
        return dataFromFile;
    }

    @Override
    public void writeToFile(List<String> report, String toFileName) {
        try (FileWriter writer = new FileWriter(toFileName)) {
            for (String line : report) {
                writer.write(line);
                if (report.indexOf(line) < report.size() - 1) {
                    writer.write(System.lineSeparator());
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Can't write the file" + toFileName, e);
        }
    }
}

