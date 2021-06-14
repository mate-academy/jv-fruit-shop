package core.basesyntax.fileservice;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvReader implements Reader {
    @Override
    public List<String> readFromFile(String source) {
        List<String> dataFromFile = new ArrayList<>();

        try (FileReader fileReader = new FileReader(source)) {
            BufferedReader reader = new BufferedReader(fileReader);
            String line = reader.readLine();

            while (line != null) {
                dataFromFile.add(line.trim());
                line = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Some problem with file");
        }

        dataFromFile.remove(0);

        return dataFromFile;
    }
}
