package core.basesyntax.service.impl;

import core.basesyntax.service.WriteService;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class WriteServiceImpl implements WriteService {
    @Override
    public boolean writeIntoFile(List<String> listData) {
        File file = new File("src/main/resources/database.csv");
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {
            for (String data : listData) {
                bufferedWriter.write(data);
                bufferedWriter.newLine();
            }
            return true;
        } catch (IOException e) {
            throw new RuntimeException("Can't find file by path: " + file, e);
        }
    }
}
