package core.basesyntax.service.impl;

import core.basesyntax.service.CustomFileReader;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileReaderImpl implements CustomFileReader {

    @Override
    public List<String> read(String filePathInputFile) {
        File file = new File(filePathInputFile);

        if (!file.exists()) {
            System.out.println("Файл не знайдено: " + file.getAbsolutePath());
            return new ArrayList<>();
        }

        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
            System.out.println("Файл успішно відкрито: " + file.getName());
        } catch (IOException e) {
            throw new RuntimeException("Помилка при відкритті файлу "
                    + file.getName() + ": " + e.getMessage(), e);
        }
        return lines;
    }
}
