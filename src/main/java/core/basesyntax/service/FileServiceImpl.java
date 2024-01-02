package core.basesyntax.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class FileServiceImpl implements FileService {
    String record = "";
    @Override
    public List<String> readFile(String INPUT_FILE) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            File report = new File(INPUT_FILE);
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
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        List<String> list = List.of(stringBuilder.toString().split("\\n"));
        return list;
    }

    @Override
    public void writeToFile(String REPORT_FILE, String report) {
        try (FileWriter fileWriter = new FileWriter(REPORT_FILE)) {
            fileWriter.write(report);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
