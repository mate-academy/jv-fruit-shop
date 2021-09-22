package core.basesyntax.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class CsvFileReaderImpl implements CsvFileReader {
    static final String CSV_FIELDS_NAMES = "type,fruit,quantity";

    @Override
    public String readFromFile(String filePath) {
        File myFile = new File(filePath);
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(myFile))) {
            int value = reader.read();
            while (value != -1) {
                stringBuilder.append((char) value);
                value = reader.read();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can`t find file", e);
        }
        return stringBuilder.toString().replace(CSV_FIELDS_NAMES, "").replace("\r", "").trim();
    }
}
