package core.service.impl;

import core.service.Reader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class CsvReaderImpl implements Reader {
    @Override
    public List<String> readFile(String fileName) {
        List<String> lines = new ArrayList<>();
        try (InputStream inputStream = CsvReaderImpl.class.getClassLoader()
                .getResourceAsStream(fileName)) {
            if (inputStream == null) {
                throw new FileNotFoundException("File not found: " + fileName);
            }
            BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(inputStream, StandardCharsets.UTF_8));
            
            while (bufferedReader.ready()) {
                lines.add(bufferedReader.readLine());
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file: " + fileName, e);
            
        }
        return lines;
    }
}
