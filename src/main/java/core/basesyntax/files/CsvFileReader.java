package core.basesyntax.files;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvFileReader implements FileReader {
    @Override
    public List<String> readFileLines(String fileName) {
        List<String> output = new ArrayList<>();
        File file = new File(fileName);

        try (BufferedReader reader = new BufferedReader(new java.io.FileReader(file))) {
            String value = reader.readLine();

            while (value != null) {
                output.add(value + System.lineSeparator());
                value = reader.readLine();
            }

        } catch (IOException e) {
            throw new RuntimeException("Can't find/read file by path: " + fileName, e);
        }

        output.remove(0);
        return output;
    }
}
