package core.basesyntax.service.impl;

import core.basesyntax.service.CustomFileReader;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileReaderImpl implements CustomFileReader {
    private String inputFile;

    public FileReaderImpl(String inputFile) {
        this.inputFile = inputFile;
    }

    public List<String> read() {
        File myFile = new File(inputFile);

        if (!myFile.exists()) {
            System.out.println("Файл не знайдено " + myFile.getAbsolutePath());
            return new ArrayList<>();
        }

        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(myFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
            System.out.println("Відкрито та знайдено файл " + myFile.getName());
        } catch (IOException e) {
            throw new IllegalArgumentException("Помилка при відкритті файлу "
                    + myFile.getName() + e.getMessage());
        }
        return lines;
    }
}
