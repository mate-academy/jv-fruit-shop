package core.basesyntax.reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileReaderImpl implements FileReader {
    @Override
    public List<String> read(String filePath) {
        List<String> strings = new ArrayList<>();
        try (BufferedReader bufferedReader =
                     new BufferedReader(
                             new java.io.FileReader(
                                     new File(filePath)))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                strings.add(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return strings;
    }
}
