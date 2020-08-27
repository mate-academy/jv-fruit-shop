package core.basesyntax.orderprocessing;

import com.opencsv.CSVWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class ResultWriter {
    public boolean writeResult(String path, Map<String, Integer> total) {
        try (CSVWriter csvWriter = new CSVWriter(new FileWriter(path))) {
            csvWriter.writeNext(new String[]{"fruit", "quantity"});
            for (Map.Entry<String, Integer> fruitPack : total.entrySet()) {
                csvWriter.writeNext(new String[]{
                        fruitPack.getKey(),
                        String.valueOf(fruitPack.getValue())});
            }
        } catch (IOException e) {
            throw new IllegalArgumentException("Invalid file path!!", e);
        }
        return true;
    }
}
