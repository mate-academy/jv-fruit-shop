package core.basesyntax.service.impl;

import core.basesyntax.service.RecordingService;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class RecordingServiceImpl implements RecordingService {
    @Override
    public void writeIntoFile(List<String> listData, String path) {
        File file = new File(path);
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {
            for (String data : listData) {
                bufferedWriter.write(data);
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't find file by path: " + file, e);
        }
    }
}
