package core.basesyntax.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileReaderImpl implements FileReader {
    @Override
    public List<String> read(File input) {
        List<String> result = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new java.io.FileReader(input))) {
            String line = br.readLine();
            while (line != null) {
                result.add(line);
                line = br.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("can't read file: " + input, e);
        }
        return result;
    }
}
