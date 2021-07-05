package service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ShopFileReaderImpl implements ShopFileReader {
    @Override
    public List<String> readFromFile(String fileName) {
        List<String> readFile = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line = reader.readLine();
            line = reader.readLine();
            while (line != null) {
                readFile.add(line);
                line = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Can't file with this name", e);
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
        return readFile;
    }
}
