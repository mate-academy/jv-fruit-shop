package core.basesyntax.service.impl;

import core.basesyntax.service.WriterService;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriterServiceImpl implements WriterService {

    @Override
    public void write(String resultData, String nameOfFile) {
        File file = new File(nameOfFile);
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {
            bufferedWriter.write(resultData);
        } catch (IOException e) {
            throw new RuntimeException("Can`t write to file", e);
        }
    }

}

