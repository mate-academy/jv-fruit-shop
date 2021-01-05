package core.basesyntax.dao.classes;

import core.basesyntax.dao.interfaces.MyFileReader;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MyFileReaderImpl implements MyFileReader {
    private final String path;

    public MyFileReaderImpl(String path) {
        this.path = path;
    }

    @Override
    public List<String> readData() {
        List<String> stringList = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            bufferedReader.readLine();
            String lineBuffer = bufferedReader.readLine();
            while (lineBuffer != null) {
                stringList.add(lineBuffer.trim());
                lineBuffer = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read from file " + path);
        }
        return stringList;
    }
}
