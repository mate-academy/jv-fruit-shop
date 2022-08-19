package core.basesyntax.service.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadFromFileImpl implements ReadFromFile {
    @Override
    public List<String> readeFromFile(String pathToFile) {
        List<String> lists = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(pathToFile))) {
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
