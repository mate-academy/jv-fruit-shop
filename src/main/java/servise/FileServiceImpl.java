package servise;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FileServiceImpl implements FileService {
    private File file;

    @Override
    public List<String> getDbFromFile(String fileName) {
        List<String> inputFromFile = new ArrayList<>();
        file = new File(fileName);
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String value = reader.readLine();
            while (value != null) {
                inputFromFile.add(value);
                value = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file" + fileName, e);
        }
        return inputFromFile;
    }

    @Override
    public void putDbToFile(Map<String, Integer> dayResult) {
        file = new File("REPORT.csv");
        String text = "fruit,quantity" + System.lineSeparator();
        try {
            Files.write(file.toPath(), text.getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new RuntimeException("Can't write BD to to file", e);
        }
        for (Map.Entry<String, Integer> entry:dayResult.entrySet()) {
            text = entry.getKey() + " " + entry.getValue() + System.lineSeparator();
            try {
                Files.write(file.toPath(), text.getBytes(), StandardOpenOption.APPEND);
            } catch (IOException e) {
                throw new RuntimeException("Can't write BD to to file", e);
            }
        }
    }
}
