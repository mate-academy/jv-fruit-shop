package core.basesyntax.service.impl;

import core.basesyntax.service.service.WriteService;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteServiceImpl implements WriteService {
    @Override
    public void writeToFile(String result, String nameFileTo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nameFileTo))) {
            writer.write(result);
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to file " + nameFileTo, e);
        }
    }
}
