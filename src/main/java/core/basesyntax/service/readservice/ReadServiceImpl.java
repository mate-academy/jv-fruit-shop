package core.basesyntax.service.readservice;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadServiceImpl implements ReaderService {
    @Override
    public String readFrom(String path) {
        if (path == null) {
            throw new RuntimeException("Path is null");
        }
        File file = new File(path);
        StringBuilder result = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String value = bufferedReader.readLine();
            while (value != null) {
                result.append(value).append(System.lineSeparator());
                value = bufferedReader.readLine();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Can't find file " + path, e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return result.toString().trim();
    }
}
