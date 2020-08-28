package core.basesyntax.service.impl;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileServiceImpl implements core.basesyntax.service.FileService {
    @Override
    public List<String[]> fileReader(String filePath) {
        List<String[]> data = null;
        try (FileReader fileReader = new FileReader(filePath);
                CSVReader read = new CSVReader(fileReader)) {
            data = read.readAll();
        } catch (IOException | CsvException e) {
            throw new RuntimeException("Error occured");
        }
        return data;
    }

    @Override
    public void fileWriter(String filePath, List<String> output) {
        Path path = Paths.get(filePath);
        if (!Files.exists(path)) {
            try {
                Files.createFile(path);
            } catch (IOException e) {
                throw new RuntimeException("Check if the file path is correct");
            }
        }
        try (FileWriter fileWriter = new FileWriter(filePath)) {
            fileWriter.write("fruit,quantity\n");
            for (String line : output) {
                fileWriter.write(line);
                fileWriter.write("\n");
            }
        } catch (IOException e) {
            throw new RuntimeException("Check if the file path is correct");
        }
    }
}
