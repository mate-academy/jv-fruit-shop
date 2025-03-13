package core.basesyntax.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileReaderImpl implements FileReader {

    public List<String> read(String fileName) {
        List<String> list = new ArrayList<>(); // Ініціалізація списку перед використанням
        try (BufferedReader br = new BufferedReader(new java.io.FileReader(fileName))) {
            int count = 0;
            String str;
            while ((str = br.readLine()) != null) {
                if (count != 0) {
                    list.add(str);
                }
                count++;
            }
        } catch (FileNotFoundException e) {
            System.out.println("File " + fileName + " does not exist.");
        } catch (IOException e) {
            throw new RuntimeException("Error reading file: " + fileName);
        }
        return list;
    }
}
