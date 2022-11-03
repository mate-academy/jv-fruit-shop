package myfirstproject.service.impl;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import myfirstproject.model.Fruit;
import myfirstproject.service.WriteFile;

public class WriteFileImpl implements WriteFile {
    private static final String TITLE = "fruit,quantity" + System.lineSeparator();
    private static final String COMMA = ",";

    @Override
    public void writeToFile(String path, Map<Fruit, Integer> mapToWrite) {
        StringBuilder data = new StringBuilder();
        prepareRecording(data, mapToWrite);
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path))) {
            bufferedWriter.write(data.toString());
        } catch (IOException e) {
            System.out.println("Can't write to file. " + e);
        }
    }

    private void prepareRecording(StringBuilder data, Map<Fruit, Integer> mapToWrite) {
        data.append(TITLE);
        for (Map.Entry<Fruit, Integer> map : mapToWrite.entrySet()) {
            data.append(map.getKey().getName())
                    .append(COMMA)
                    .append(map.getValue())
                    .append(System.lineSeparator());
        }
    }
}
