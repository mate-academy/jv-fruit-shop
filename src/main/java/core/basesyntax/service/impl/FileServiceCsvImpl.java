package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.FileService;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FileServiceCsvImpl implements FileService {
    @Override
    public List<String> read(String filePath) {
        String line = "";
        List<String> dataFromFile = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            br.readLine();
            while ((line = br.readLine()) != null) {
                dataFromFile.add(line.trim());
            }

        } catch (IOException e) {
            throw new RuntimeException("File not found " + filePath);
        }
        return dataFromFile;
    }

    @Override
    public void write(String filePath) {
        String eol = System.lineSeparator();

        try (Writer writer = new FileWriter(filePath)) {
            writer.append("fruit,quantity" + eol);
            for (Map.Entry<String, Integer> entry : Storage.fruitStorage.entrySet()) {
                writer.append(entry.getKey())
                        .append(',')
                        .append(Integer.toString(entry.getValue()))
                        .append(eol);
            }
        } catch (IOException ex) {
            throw new RuntimeException("File not found " + filePath);
        }
    }
}
