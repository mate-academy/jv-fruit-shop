package core.basesyntax.servise;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class WrireFile implements FileWriteService {
    @Override
    public void writeToFile(Map<String, Integer> fruitStorage) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src/resources/outputFile.csv"))) {
            bufferedWriter.write(("fruit, quantity" + "\n"));
            for (Map.Entry<String, Integer> entry: fruitStorage.entrySet()) {
                bufferedWriter.write(entry.getKey() + "," + entry.getValue() + "\n");
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't write to the file", e);
        }
    }
}
