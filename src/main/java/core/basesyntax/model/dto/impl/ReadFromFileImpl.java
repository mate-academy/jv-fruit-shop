package core.basesyntax.model.dto.impl;

import core.basesyntax.model.dto.ReadFromFileDto;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadFromFileImpl implements ReadFromFileDto {

    @Override
    public List<String> readFile(String fileName) {
        List<String> linesList = new ArrayList<>();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
            String line = bufferedReader.readLine();
            while (line != null) {
                System.out.println(line);
                linesList.add(line);
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("File not found");
        }
        return linesList;
    }
}
