package core.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StorageDaoImpl implements StorageDao {
    @Override
    public List<String> readData(String fileName) {
        List<String> lines = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String line = bufferedReader.readLine();
            while (line != null) {
                lines.add(line);
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can`t read data from file " + fileName, e);
        }
        return lines;
    }

    @Override
    public void writeData(String fileName, String data) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName))) {
            bufferedWriter.write(data);
        } catch (IOException e) {
            throw new RuntimeException("Can`t write data to file " + fileName, e);
        }
    }
}
