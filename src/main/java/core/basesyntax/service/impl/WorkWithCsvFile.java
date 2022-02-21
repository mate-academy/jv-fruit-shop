package core.basesyntax.service.impl;

import core.basesyntax.service.WorkWithFiles;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class WorkWithCsvFile implements WorkWithFiles {
    @Override
    public List<String> readFromFile(String filePass) {
        File file = new File(filePass);
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            List<String> inputFromFile = new ArrayList<>();
            String line = reader.readLine();
            while (line != null) {
                inputFromFile.add(line);
                line = reader.readLine();
            }
            return inputFromFile;
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Can't find file with file name " + filePass, e);
        } catch (IOException e) {
            throw new RuntimeException("Can't read from file " + filePass, e);
        }
    }

    @Override
    public void writeToFile(String filePass, String content) {
        try {
            Files.write(Paths.get(filePass), content.getBytes());
        } catch (IOException e) {
            throw new RuntimeException("Can't find file by path: " + filePass, e);
        }
    }
}
