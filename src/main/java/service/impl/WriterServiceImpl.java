package service.impl;

import db.Warehouse;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Map;
import service.WriterService;

public class WriterServiceImpl implements WriterService {
    private static final String TOP_OF_REPORT = "fruit,quantity";
    private static final String COMMA = ",";

    @Override
    public void writeToFile(String toFileName) {
        File toFile = new File(toFileName);
        try (BufferedWriter writeTo = new BufferedWriter(new FileWriter(toFile))) {
            writeTo.write(TOP_OF_REPORT + System.lineSeparator());
            for (Map.Entry<String, Integer> line : Warehouse.STORAGE.entrySet()) {
                writeTo.write(line.getKey() + COMMA + line.getValue());
                writeTo.newLine();
            }
        } catch (Exception e) {
            throw new RuntimeException("Can't write file" + toFileName, e);
        }
    }
}
