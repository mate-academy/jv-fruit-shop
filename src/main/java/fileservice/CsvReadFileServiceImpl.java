package fileservice;

import errors.InvalidFileExtensionException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvReadFileServiceImpl implements ReadFileService {
    @Override
    public List<String> read(String file) {
        if (!file.endsWith(".csv")) {
            throw new InvalidFileExtensionException("Wrong file extension.");
        }

        List<String> dataFromCsvFile = new ArrayList();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                dataFromCsvFile.add(line);
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }

        return dataFromCsvFile;
    }
}
