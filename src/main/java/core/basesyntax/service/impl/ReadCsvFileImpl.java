package core.basesyntax.service.impl;

import core.basesyntax.service.ReadCsvFile;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ReadCsvFileImpl implements ReadCsvFile {
    @Override
    public List<String> readCsvFile(String fileName) {
        List<String> lines = new ArrayList<>();
        try (InputStream is = getClass().getClassLoader().getResourceAsStream(fileName);
                BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
            reader.readLine();
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line.replace(",", " "));
            }
        } catch (IOException e) {
            throw new RuntimeException("Cannot read file from resources: " + fileName, e);
        } catch (NullPointerException e) {
            throw new RuntimeException("File not found in resources: " + fileName, e);
        }
        return lines;
    }
}
