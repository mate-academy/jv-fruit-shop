package core.basesyntax.dataio;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileReaderImpl implements FileReader {
    private final String path;

    public FileReaderImpl(String path) {
        this.path = path;
    }

    @Override
    public List<String> read() {
        List<String> data = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new java.io.FileReader(path))) {
            bufferedReader.readLine();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                data.add(line.trim());
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file" + path);
        }
        return data;
    }
}
