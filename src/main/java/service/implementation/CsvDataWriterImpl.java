package service.implementation;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import model.Fruit;
import service.DataWriter;

public class CsvDataWriterImpl implements DataWriter {

    @Override
    public void writeToFile(Map<Fruit, Integer> fruitReport, String writeFileTo) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(writeFileTo))) {
            StringBuilder builder = new StringBuilder("fruit,quantity" + System.lineSeparator());
            for (Map.Entry<Fruit, Integer> entry : fruitReport.entrySet()) {
                builder.append(entry.getKey().getName())
                        .append(",")
                        .append(entry.getValue().toString())
                        .append(System.lineSeparator());
            }
            bufferedWriter.write(builder.toString());
        } catch (IOException e) {
            throw new RuntimeException("Can not write data to file: " + writeFileTo, e);
        }
    }
}
