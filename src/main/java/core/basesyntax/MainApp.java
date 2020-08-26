package core.basesyntax;

import core.basesyntax.service.CsvUtilsImpl;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        CsvUtilsImpl csvUtils = new CsvUtilsImpl();
        System.out.println("Input path to file for reading in form: "
                + "src/main/resources/inputFile.csv");
        Scanner scanner = new Scanner(System.in);
        String csvInputFile = scanner.nextLine();
        csvUtils.processFile(csvInputFile);

        System.out.println("Input path to file for reading in form: "
                + "src/main/resources/outputFile.csv");
        scanner = new Scanner(System.in);
        String csvOutputFile = scanner.nextLine();
        csvUtils.createReport(csvOutputFile);
    }
}
