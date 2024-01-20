package core.basesyntax.service.impl;

import core.basesyntax.service.FileService;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileServiceImpl implements FileService {
    @Override
    public List<String> readFile(String filePath) {
        List<String> list = new ArrayList<>();
        try {
            File report = new File(filePath);
            Scanner scanner = new Scanner(report);
            if (scanner.hasNextLine()) {
                scanner.nextLine();
            }
            while (scanner.hasNextLine()) {
                list.add(scanner.nextLine());
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Can`t find file by path: " + filePath, e);
        }
            return list;
    }

    @Override
    public void writeToFile(String fileName, String report) {
        try (FileWriter fileWriter = new FileWriter(fileName)) {
            fileWriter.write(report);
        } catch (IOException e) {
            throw new RuntimeException("Suggested path not found: " + fileName, e);
        }
    }
}
