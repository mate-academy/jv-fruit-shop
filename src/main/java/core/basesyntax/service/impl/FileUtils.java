package core.basesyntax.service.impl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {
    public static final String COMMA_SEPARATOR = ",";

    public static List<String> readFile(String filePath) {
        List<String> fileContent = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                fileContent.add(line);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Can't find file by path: " + filePath, e);
        } catch (IOException e) {
            throw new RuntimeException("Can't read file by path: " + filePath, e);
        }
        return fileContent;
    }

    public static void writeFile(List<String> content, String filePath) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            for (String line : content) {
                bw.write(line + System.lineSeparator());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Can't create file by path: " + filePath, e);
        } catch (IOException e) {
            throw new RuntimeException("Can't write file by path: " + filePath, e);
        }
    }
}
