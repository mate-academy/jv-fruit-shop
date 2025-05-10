package core.basesyntax.workwithfile;

import core.basesyntax.workwithfileinterface.FileDataReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileReaderImpl implements FileDataReader {
    @Override
    public List<String> read(String fileName) {
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new java.io.FileReader(fileName))) {
            reader.readLine(); // Пропускаем заголовок
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }
}
