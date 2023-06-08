package core.basesyntax.db;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class DataBaseCsvImpl implements DataBase {
    private final String fullFilePath;

    public DataBaseCsvImpl(String fullFilePath) {
        this.fullFilePath = fullFilePath;
    }

    public String getFullFilePath() {
        return fullFilePath;
    }

    @Override
    public void writeDataToFile(List<String> listOfData) {
        clearFile();
        try (FileWriter writer = new FileWriter(fullFilePath)) {
            for (String l : listOfData) {
                writer.write(l + System.lineSeparator());
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't find file by path: " + fullFilePath, e);
        }
    }

    @Override
    public List<String> getDataFromFile() {
        List<String> dataFromFile;
        try {
            dataFromFile = Files.readAllLines(Path.of(fullFilePath));
        } catch (IOException e) {
            throw new RuntimeException("Can't find file by path: " + fullFilePath, e);
        }
        if (!dataFromFile.isEmpty()) {
            dataFromFile.remove(0);
        }
        return dataFromFile;
    }

    @Override
    public void clearFile() {
        try {
            Files.writeString(Path.of(fullFilePath), "");
        } catch (IOException e) {
            throw new RuntimeException("Can't find file by path: " + fullFilePath, e);
        }
    }
}
