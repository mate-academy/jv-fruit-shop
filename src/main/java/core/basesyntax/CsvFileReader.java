package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class CsvFileReader implements FileReader {

    // Реализация чтения CSV-файла
    // Возвращаем список строк из файла
    @Override
    public List<String> readTransactions(String filePath) {
        try {
            // Используем метод readAllLines для чтения всех строк из файла
            return Files.readAllLines(Paths.get(filePath));
        } catch (IOException e) {
            // Ловим возможное исключение при чтении файла
            throw new RuntimeException("Error reading file: " + filePath, e);
        }


    }
}
