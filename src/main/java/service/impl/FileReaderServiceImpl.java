package service.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import service.FileReaderService;

public class FileReaderServiceImpl implements FileReaderService {
    private String filePath;

    public FileReaderServiceImpl(String filePath) {
        this.filePath = filePath;
    }

    public boolean filePathValidator(String filePath) {
        File file = new File(filePath);
        return file.exists() && file.isFile() && file.canRead();
    }

    @Override
    public List<String> readFromFile() throws IOException {
        List<String> list = new ArrayList<>();
        if (filePathValidator(filePath)) {
            try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
                String line;
                while ((line = br.readLine()) != null) {
                    list.add(line);
                }
            } catch (IOException e) {
                throw new IOException("Error reading the file: " + filePath, e);
            }
        } else {
            throw new IllegalArgumentException("Invalid file path: " + filePath);
        }
        return list;
    }
}
