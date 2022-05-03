package service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class ReadService {
    public List<String> readFile(String fileName) {
        try (BufferedReader read = new BufferedReader(new FileReader(fileName))) {
            List<String> collect = read.lines().collect(Collectors.toList());
            return collect;
        } catch (IOException e) {
            throw new RuntimeException("Can't read from file ", e);
        }
    }
}
