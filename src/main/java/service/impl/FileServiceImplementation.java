package service.impl;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.CSVWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import service.FileService;

public class FileServiceImplementation implements FileService {

    public List<String[]> read(File file) {
        try (CSVReader reader = new CSVReader(new FileReader(file))) {
            return reader.readAll();
        } catch (IOException e) {
            throw new RuntimeException("Cannot read file: " + file.getName() + e);
        }
    }

    public void writeFile(File file, List<String[]> list) {
        try (CSVWriter writer = new CSVWriter(new FileWriter(file))) {
            writer.writeAll(list);
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to file " + file.getName() + e);
        }
    }
}
