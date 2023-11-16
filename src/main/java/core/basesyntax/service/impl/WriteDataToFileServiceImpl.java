package core.basesyntax.service.impl;

import core.basesyntax.service.WriteDataToFileService;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteDataToFileServiceImpl implements WriteDataToFileService {

    @Override
    public void writeData(String path, String info) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
            writer.write(info);

        } catch (IOException e) {
            throw new RuntimeException("File to path" + path + " not found");
        }
    }
}
