package core.basesyntax.dao;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriterServiceImpl implements WriterService {
    @Override
    public void writeData(String filepath, String data) {
        File toFile = new File(filepath);
        try {
            toFile.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException("Can't create new file");
        }
        try {
            toFile.createNewFile();
        } catch (Exception e) {
            throw new RuntimeException("can't create file");
        }
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(toFile))) {
            bufferedWriter.write(data);
        } catch (IOException e) {
            throw new RuntimeException("can't write data");
        }
    }
}
