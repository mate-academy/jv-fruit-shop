package write.file;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class WriteToFileImpl implements WriteToFile {
    private static final String DEFAULT_FIRST_LINE = "fruit,quantity";

    @Override
    public void write(Map<String, Integer> updatedFruitsStock,String filePath) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath))) {
            bufferedWriter.write(DEFAULT_FIRST_LINE);
            bufferedWriter.newLine();
            for (Map.Entry<String,Integer> entry : updatedFruitsStock.entrySet()) {
                bufferedWriter.write(entry.getKey() + "," + entry.getValue());
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file" + filePath);
        }
    }
}
