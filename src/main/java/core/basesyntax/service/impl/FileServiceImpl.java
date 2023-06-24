package core.basesyntax.service.impl;

import core.basesyntax.service.FileService;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class FileServiceImpl implements FileService {
    @Override
    public List<String> readFromFile(String filePath) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            return bufferedReader.lines().collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException("Can't find file by path: " + filePath, e);
        }
    }  

    @Override
    public void writeToFile(List<String> lines, String filePath) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath))) {
            Iterator<String> iterator = lines.iterator();
            bufferedWriter.write(iterator.next());
            while (iterator.hasNext()) {
                bufferedWriter.newLine();
                bufferedWriter.write(iterator.next());
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't create file by path: " + filePath, e);
        }        
    }
}
