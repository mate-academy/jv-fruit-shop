package core.basesyntax.service.impl;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import core.basesyntax.service.WriterService;


public class WriterServiceCsvImpl implements WriterService {


    @Override
    public void writeToFile(List<String> list, String fileName) {

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
            for (String line : list) {
                bw.write(line);
                bw.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file: " + fileName, e);
        }
    }
}

