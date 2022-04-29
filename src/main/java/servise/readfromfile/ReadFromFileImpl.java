package servise.readfromfile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ReadFromFileImpl implements ReadFromFile {
    @Override
    public List<String> readFromFile(Path path) {
        List<String> list = new ArrayList<>();
        File file = new File(String.valueOf(path));

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                list.add(line);
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read all line" + path, e);
        }
        return list;
    }
}
