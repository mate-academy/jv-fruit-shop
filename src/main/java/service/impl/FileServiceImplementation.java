package service.impl;

import au.com.bytecode.opencsv.CSVReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import service.FileService;

public class FileServiceImplementation implements FileService {

    public List<String[]> readFile(String filePath) {
        File file = new File(filePath);
        try (CSVReader reader = new CSVReader(new FileReader(file))) {
            return reader.readAll();
        } catch (IOException e) {
            throw new RuntimeException("Cannot read file: " + file.getName() + e);
        }
    }

    public void writeFile(String filePath, List<String[]> list) {
        File file = new File(filePath);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (String[] data : list) {
                writer.write(String.join(",", data));
                writer.write(System.lineSeparator());
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to file " + file.getName() + e);
        }
    }
}
