package service.impl;

import db.Warehouse;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Map;
import service.WriterService;

public class WriterServiceImpl implements WriterService {
    @Override
    public void writeToFile(String toFileName) {
        Map<Warehouse.TypeFruit, Integer> information = Warehouse.getStorage();
        File toFile = new File(toFileName);
        try (BufferedWriter writeTo = new BufferedWriter(new FileWriter(toFile))) {
            writeTo.write("fruit,quantity" + System.lineSeparator());
            for (Map.Entry<Warehouse.TypeFruit, Integer> line : information.entrySet()) {
                writeTo.write(line.getKey() + "," + line.getValue());
                writeTo.newLine();
            }
        } catch (Exception e) {
            throw new RuntimeException("Can't write file" + toFileName, e);
        }
    }
}
