package core.basesyntax.serviceImpl;

import core.basesyntax.service.ReadFromFileService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class ReadFromFileServiceImpl implements ReadFromFileService {
    @Override
    public List<String> readFile(String filePath) {
        try {
            return Files.readAllLines(Path.of(filePath));
        } catch (IOException e) {
            throw new RuntimeException("can`t read file");
        }
    }
}
// читаємо данні з файлу та повертаємо ліст стрінгів