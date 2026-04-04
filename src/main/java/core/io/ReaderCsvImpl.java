package core.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReaderCsvImpl implements Reader {
    @Override
    public List<String> readData(String path) {
        List<String> result = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            while (reader.ready()) {
                result.add(reader.readLine());
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file " + path, e);
        }
        return result;
    }
}
