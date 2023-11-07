package core.basesyntax.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FileServiceImpl implements FileService {
    private static final String HEAD_OF_REPORT = "fruit,quantity";

    @Override
    public List<String> readFromFile(String fileName) {
        List<String> lineArray = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                lineArray.add(line);
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException("File not found" + fileName, e);
        } catch (IOException e) {
            throw new RuntimeException("Cant read file" + fileName, e);
        }

        return lineArray;
    }

    @Override
    public boolean createReport(Map<String, Integer> map, String fileName) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName))) {
            bufferedWriter.write(HEAD_OF_REPORT);
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                bufferedWriter.newLine();
                bufferedWriter.write(entry.getKey() + "," + entry.getValue());
            }
            return true;
        } catch (IOException e) {
            throw new RuntimeException("Cant write file");
        }
    }
}
