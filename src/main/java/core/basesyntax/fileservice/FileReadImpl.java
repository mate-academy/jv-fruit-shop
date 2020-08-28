package core.basesyntax.fileservice;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileReadImpl implements FileRead {

    @Override
    public List<List<String>> readFile(String[] path) {
        if (path == null) {
            throw new IllegalArgumentException("Path is null");
        }
        List<List<String>> listOfLists = new ArrayList<>();
        Path filePath = Paths.get(path[0] + FileSystems.getDefault().getSeparator() + path[1]);
        try (CSVReader csvReader = new CSVReader(Files.newBufferedReader(filePath))) {
            String[] line;
            while ((line = csvReader.readNext()) != null) {
                List<String> tempList = new ArrayList<>(Arrays.asList(line));
                listOfLists.add(tempList);
            }
        } catch (IOException | CsvValidationException e) {
            throw new RuntimeException("No such file");
        }
        return listOfLists;
    }
}
