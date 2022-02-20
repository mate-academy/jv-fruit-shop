package dao.service;

import dao.FileOperations;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class FileService implements FileOperations {

    @Override
    public List<String> read(String path) {
        List<String> lines;
        try {
            lines = Files.readAllLines(Paths.get(path));
        } catch (IOException e) {
            throw new RuntimeException("Can't read from file");
        }
        return lines;
    }

    @Override
    public boolean write(String dataToWrite, String path) {
        File file = new File(path);
        try {
            file.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException("Can't create file to write report", e);
        }
        try {
            Files.write(Paths.get(path), dataToWrite.getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new RuntimeException("Can't write report data to file ", e);
        }
        return true;
    }
}
