package core.basesyntax.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileReaderImpl implements FileReader {
    @Override
    public List<String> read(String fileName) {
        List<String> info = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new java.io.FileReader(fileName))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                info.add(line);
            }

        } catch (IOException e) {
            throw new RuntimeException("Can`t read file", e);
        }
        return info;
    }
}

