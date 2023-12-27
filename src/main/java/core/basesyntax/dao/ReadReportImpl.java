package core.basesyntax.dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadReportImpl implements ReadReport {
    private String record;
    @Override
    public String read() {
        String path = "src/main/resources/report.csv";
        StringBuilder stringBuilder = new StringBuilder();
        try {
            File report = new File(path);
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
        return stringBuilder.toString();
    }
}
