package core.basesyntax.fileservice;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class WriteToFile {
    public void writeToFile(Map<String,Integer> fruitDao, String filePath) {
        try (BufferedWriter printer = new BufferedWriter(new FileWriter(filePath))) {
            int countForHeader = 0;
            for (Map.Entry<String, Integer> item : fruitDao.entrySet()) {
                if (countForHeader == 0) {
                    countForHeader++;
                    printer.write("fruit,quantity\n");
                }
                printer.write(item.getKey() + "," + item.getValue().toString() + '\n');
            }
        } catch (IOException e) {
            throw new RuntimeException("Something went wrong with writing to file");
        }
    }
}
