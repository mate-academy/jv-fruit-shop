package core.basesyntax.service.implementation;

import core.basesyntax.exeption.FruitShopExceptions;
import core.basesyntax.service.FileReaderService;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileReaderServiceImpl implements FileReaderService {
    @Override
    public List<String> readFromFile(String fileNameToRead) {
        List<String> listFromFile = new ArrayList<>();
        File file = new File(fileNameToRead);
        String line;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            bufferedReader.readLine();
            while (bufferedReader.ready()) {
                line = bufferedReader.readLine();
                if (line != null) {
                    listFromFile.add(line);
                }
            }
        } catch (IOException e) {
            throw new FruitShopExceptions("Can't find file");
        }
        return listFromFile;
    }
}
