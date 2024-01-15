package core.basesyntax.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

public class FileServiceImpl implements FileService {
    @Override
    public List<String> readFile(String filePath) {
        String record = "";
        StringBuilder stringBuilder = new StringBuilder();
        try {
            File report = new File(filePath);
            Scanner scanner = new Scanner(report);
            if (scanner.hasNextLine()) {
                scanner.nextLine();
            }
            while (scanner.hasNextLine()) {
                record = scanner.nextLine();
                stringBuilder.append(record + "\n");
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Can`t find file by path: " + filePath, e);
        }
            List<String> list = List.of(stringBuilder.toString().split("\\n"));
            return list;
    }

    @Override
    public void writeToFile(String fileName, String report) {
        try (FileWriter fileWriter = new FileWriter(fileName)) {
            fileWriter.write(report);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
