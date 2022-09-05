package service.impl;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import service.ReaderService;

public class ReaderServiceImpl implements ReaderService {
    @Override
    public List<String> readFrom(String pathToFile) {
        List<String> infoList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(pathToFile))) {
            String tempLine;
            while ((tempLine = reader.readLine()) != null) {
                infoList.add(tempLine);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("The File not found.", e);
        } catch (IOException e) {
            throw new RuntimeException("Can't to read the file.", e);
        }
        return infoList;
    }
}
