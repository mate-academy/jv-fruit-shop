package dao;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileReaderDaoImpl implements FileReaderDao {
    private static final int REMOVE_LINE = 0;

    @Override
    public List<String> getFileData(String fileName) {
        List<String> fileData;
        try {
            fileData = Files.readAllLines(Path.of(fileName));
        } catch (IOException e) {
            throw new RuntimeException("Cant find data in file" + fileName);
        }
        fileData.remove(REMOVE_LINE);
        return fileData;
    }
}
