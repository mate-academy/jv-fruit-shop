package core.basesyntax.utility;

import core.basesyntax.exceptions.FileNotExistsException;
import core.basesyntax.utility.service.FileService;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileServiceImpl implements FileService {
    @Override
    public List<String> readFromFile(String fileName) {
        List<String> result = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                result.add(line);
            }
            return result;
        } catch (IOException e) {
            throw new FileNotExistsException("File: " + fileName + " Not Found!");
        }
    }

    @Override
    public void writeToFile(String fileName, List<Pair<String, Integer>> data) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName))) {
            StringBuilder dataToWrite = new StringBuilder("fruit,quantity");
            for (var element : data) {
                dataToWrite.append("\n").append(element.getKey()).append(",")
                          .append(element.getValue());
            }
            bufferedWriter.write(dataToWrite.toString());
        } catch (IOException e) {
            throw new FileNotExistsException("File: " + fileName + " Not Found!");
        }
    }
}
