package service.impl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import service.WriterService;

public class WriterServiceImpl implements WriterService {
    @Override
    public void writeToFile(String report, String toFileName) {
        File toFile = new File(toFileName);
        try (BufferedWriter writeTo = new BufferedWriter(new FileWriter(toFile))) {
            writeTo.write(report);
        } catch (Exception e) {
            throw new RuntimeException("Can't write file" + toFileName, e);
        }
    }
}
