package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataReaderImpl implements DataReader {
    @Override
    public List<String> readFromFile(String path) {
        List<String> lines = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(path));) {
            String line = br.readLine();

            while ((line = br.readLine()) != null) {
                lines.add(line); // Додаємо рядок в список
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read data from file");
        }
        return lines;
    }
}
