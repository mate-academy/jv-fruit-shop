package service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class FileReaderImpl implements FileReader {
    private static final int TITLE_INDEX = 0;

    @Override
    public List<String> read(String fileName) {
        File file = new File(fileName);
        List<String> listRecords;
        try {
            listRecords = Files.readAllLines(file.toPath());
            listRecords.remove(TITLE_INDEX);
        } catch (IOException e) {
            throw new RuntimeException("Can't read file" + file, e);
        }
        return listRecords;
    }
}
