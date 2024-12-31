package core.basesyntax.services.impl;

import core.basesyntax.services.FileDataReader;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FileDataReaderImpl implements FileDataReader {
    private FileReader fileReader;

    public FileDataReaderImpl(FileReader fileReader) {
        this.fileReader = fileReader;
    }

    @Override
    public List<String> readData(Path path) {
        List<String> list = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            bufferedReader.readLine();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                list.add(line);
            }
        } catch (IOException e) {
            throw new RuntimeException("Can not read data from a file" + path.toString(),e);
        }
        return list;
    }
}
