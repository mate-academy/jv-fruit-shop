package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ReadDataFromFileImpl implements ReadDataFromFile {
    private FileReader fileReader;

    public ReadDataFromFileImpl(FileReader fileReader) {
        this.fileReader = fileReader;
    }

    @Override
    public List<String> readData(Path path) {
        List<String> list = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                list.add(line);
            }
        } catch (IOException e) {
            throw new RuntimeException("Can not read data from a file",e);
        }
        return list;
    }
}
