package core.basesyntax.service.fileservice;

import core.basesyntax.service.fileservice.FruitRecordsDto;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FruitRecordsDtoImpl implements FruitRecordsDto {
    @Override
    public List<String> readDataFromFile(String fileName) {
        List<String> fruitRecords;
        try {
            fruitRecords = Files.readAllLines(Path.of(fileName));
        } catch (IOException e) {
            throw new RuntimeException("Cannot read file " + fileName);
        }
        return fruitRecords;
    }

    @Override
    public void writeDataToFile(String filename, String data) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write(data);
        } catch (IOException e) {
            throw new RuntimeException("Cannot write data to " + filename, e);
        }
    }
}
