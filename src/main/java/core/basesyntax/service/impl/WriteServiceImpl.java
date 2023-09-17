package core.basesyntax.service.impl;

import core.basesyntax.service.WriteService;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteServiceImpl implements WriteService {

    @Override
    public void writeToFile(String pathToFile, String report) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(pathToFile))) {
            writer.write(report);
            System.out.println("Data is successfully written to the file");
        } catch (IOException e) {
            throw new RuntimeException("Can`t write data to the file " + pathToFile, e);
        }
    }
}
