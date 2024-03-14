package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.service.WriterService;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FileWriterServiceImpl implements WriterService {


    @Override
    public void writeToFile(String pathToFile, String report) {
        StringBuilder builder = new StringBuilder();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(pathToFile))) {
            writer.write(report);
        } catch (IOException e) {
            throw new RuntimeException("Can`t write to file " + pathToFile, e);
        }
    }
}
