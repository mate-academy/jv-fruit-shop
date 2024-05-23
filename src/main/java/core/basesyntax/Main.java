package core.basesyntax;

import java.util.Arrays;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        final ReadFromFile readFromFile = new ReadFromFile();
        final DataProcess dataProcess = new DataProcess();
        final CreateReport createReport = new CreateReport();
        final WriteToFile writeToFile = new WriteToFile();

        System.out.println(Arrays.toString(readFromFile.read("file.csv")));
        System.out.println("--------------------");
        HashMap<String, Integer> print = dataProcess.process(readFromFile.read("file.csv"));
        print.forEach((key, value) -> System.out.println(key + "," + value));
        System.out.println("--------------------");
        System.out.println(createReport.create(dataProcess.process(readFromFile.read("file.csv"))));
        writeToFile.write(createReport.create(dataProcess.process(readFromFile.read("file.csv"))));
    }
}
