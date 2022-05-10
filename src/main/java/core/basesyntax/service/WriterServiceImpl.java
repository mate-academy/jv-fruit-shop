package core.basesyntax.service;

import com.opencsv.CSVWriter;
import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class WriterServiceImpl implements WriterService {

    @Override
    public File writeData(File file, Map<Fruit, Integer> fruitIntegerMap) {
        try {
            FileWriter outputfile = new FileWriter(file);
            CSVWriter writer = new CSVWriter(outputfile);
            String[] header = {"fruit", "quantity"};
            writer.writeNext(header);
            for (Map.Entry entry:Storage.getFruits().entrySet()) {
                Fruit fruit = (Fruit) entry.getKey();
                String[] temp = {fruit.getName(), String.valueOf(entry.getValue())};
                writer.writeNext(temp);
            }
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException("Can't write the data to the file" + file);
        }
        return file;
    }
}
