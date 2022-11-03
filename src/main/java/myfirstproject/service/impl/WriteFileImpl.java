package myfirstproject.service.impl;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import myfirstproject.model.Fruit;
import myfirstproject.service.PreparingData;
import myfirstproject.service.WriteFile;

public class WriteFileImpl implements WriteFile {
    @Override
    public void writeToFile(String path, Map<Fruit, Integer> mapToWrite) {
        PreparingData preparingData = new PrepareDataImpl();
        StringBuilder data = new StringBuilder();
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path))) {
            bufferedWriter.write(preparingData.prepare(data, mapToWrite));
        } catch (IOException e) {
            System.out.println("Can't write to file. " + path + e);
        }
    }
}
