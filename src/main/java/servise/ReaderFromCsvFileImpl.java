package servise;

import exception.FruitShopException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReaderFromCsvFileImpl implements ReaderFromFile {
    private final String filePath;

    public ReaderFromCsvFileImpl(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public List<String> readFromFile() {
        File file = new File(filePath);
        List<String> linesFromFile = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String value = reader.readLine();
            while (value != null) {
                linesFromFile.add(value);
                value = reader.readLine();
            }
        } catch (IOException ignored) {
            throw new FruitShopException("File can't be read");
        }
        return linesFromFile;
    }
}
