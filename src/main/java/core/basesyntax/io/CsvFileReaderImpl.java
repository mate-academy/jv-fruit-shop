package core.basesyntax.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvFileReaderImpl implements CsvFileReader {

    @Override
    public List<String> read(String filePath) {
        List<String> result = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isHeader = true;

            while ((line = br.readLine()) != null) {

                if (isHeader) {
                    isHeader = false;
                    continue;
                }

                result.add(line.trim());
            }

        } catch (IOException e) {
            throw new RuntimeException("Cannot read file: " + filePath, e);
        }

        return result;
    }
}
