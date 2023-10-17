package core.basesyntax.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileServiceImpl implements FileService {
    @Override
    public String readFile(String fileName) {
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader bufferedReader =
                     new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(System.lineSeparator()).append(line);
            }
            return stringBuilder.toString().trim();
        } catch (IOException e) {
            throw new RuntimeException("Can't read from file " + fileName + e);
        }
    }

    @Override
    public void writeToFile(String content, String fileName) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName))) {
            bufferedWriter.write(content);
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file " + fileName + e);
        }
    }
}
