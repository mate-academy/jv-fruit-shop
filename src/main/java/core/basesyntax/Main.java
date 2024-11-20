package core.basesyntax;

import core.basesyntax.service.GenerateReport;
import core.basesyntax.service.ReadDataFile;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String inputFileName = "src/main/resources/InputFile.csv";
        String resultFileName = "src/main/resources/EndDayReport.csv";

        ReadDataFile readDataFile = new ReadDataFile(inputFileName);
        GenerateReport generateReport = new GenerateReport(resultFileName);

        Map<String, Integer> fruitQuantity = readDataFile.getInputDataFromFile();
        generateReport.generateReport(fruitQuantity);
    }
}
