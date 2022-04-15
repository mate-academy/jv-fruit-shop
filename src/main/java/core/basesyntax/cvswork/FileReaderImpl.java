package core.basesyntax.cvswork;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileReaderImpl implements FileReader {
    public List<String> read(String filePath) {
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new java.io.FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(" Can`t open file " + filePath, e);
        } catch (IOException e) {
            throw new RuntimeException(" Can`t read file" + filePath, e);
        }
        return lines;
    }
}
