package core.basesyntax;

import core.basesyntax.service.CsvFileService;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {

        System.out.println("Input path to file for reading in form: "
                + "src/main/resources/inputFile.csv");
        Scanner scanner = new Scanner(System.in);
        String csvInputFile = scanner.nextLine();

        System.out.println("Input path to file for reading in form: "
                + "src/main/resources/outputFile.csv");
        scanner = new Scanner(System.in);
        String csvOutputFile = scanner.nextLine();
        new CsvFileService().runApplication(csvInputFile, csvOutputFile);
    }
}
