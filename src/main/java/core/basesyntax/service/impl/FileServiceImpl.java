package core.basesyntax.service.impl;

import core.basesyntax.exceptions.CouldNotWriteToFile;
import core.basesyntax.service.FileService;
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
            throw new CouldNotWriteToFile("File: " + fileName + " Not Found!");
        }
    }

    @Override
    public void writeToFile(String fileName, String data) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName))) {
            bufferedWriter.write(data);
        } catch (IOException e) {
            throw new CouldNotWriteToFile("Could not write to file: " + fileName);
        }
    }
}
