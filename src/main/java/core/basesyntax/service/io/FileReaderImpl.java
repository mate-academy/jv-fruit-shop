package core.basesyntax.service.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileReaderImpl implements FileReader {
    @Override
    public List<String> readeFromFile(String pathToFile) {
        List<String> lists = new ArrayList<>();
        try (BufferedReader bufferedReader =
                     new BufferedReader(new java.io.FileReader(pathToFile))) {
            String data = bufferedReader.readLine();
            while (data != null) {
                lists.add(data);
                data = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can not read from file: " + pathToFile, e);
        }
        return lists;
    }
}
