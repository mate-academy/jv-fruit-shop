package service.impl;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import service.InputFileHandler;

public class InputHandler implements InputFileHandler {
    @Override
    public List<String> readFile(String fileName) {
        try (BufferedReader bufferedReader = new BufferedReader(
                new FileReader(fileName))) {
            StringBuilder fileDataCollector = new StringBuilder();
            String line = bufferedReader.readLine();

            while (line != null) {
                fileDataCollector.append(line).append(System.lineSeparator());
                line = bufferedReader.readLine();
            }

            return Arrays.asList(fileDataCollector.toString().split(System.lineSeparator()));

        } catch (FileNotFoundException e) {
            throw new RuntimeException("Can't find " + fileName + " file", e);
        } catch (IOException e) {
            throw new RuntimeException("Can't read " + fileName + " file", e);
        }
    }
}
