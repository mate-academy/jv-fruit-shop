package service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import service.inter.WriteService;

public class WriterServiceImpl implements WriteService {

    @Override
    public void writeToFile(String filePath, Map<String, Integer> fruitsQuantity) {
        File file = new File(filePath);
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true))) {
            bufferedWriter.write("fruit, quantity" + "\n");
            for (Map.Entry<String, Integer> fruit: fruitsQuantity.entrySet()) {
                bufferedWriter.write(fruit + "\n");
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to filePath " + filePath, e);
        }
    }
}
