package fshop.service.workfile;

import fshop.model.Food;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Objects;

public class WriteCsvImpl implements WriteCsv {
    private String fileName;

    public WriteCsvImpl(String fileName) {
        Objects.requireNonNull(fileName);
        this.fileName = fileName;
    }

    @Override
    public Map<Food, Integer> write(Map<Food, Integer> mapFromDb) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName))) {
            bufferedWriter.write("fruit,quantity" + System.lineSeparator());
            for (Map.Entry<Food, Integer> entry : mapFromDb.entrySet()) {
                bufferedWriter.write(entry.getKey().getName() + ","
                        + entry.getValue() + System.lineSeparator());
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't write to the file");
        }
        return mapFromDb;
    }
}
