package core.basesyntax;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        FileReaderMet fileReaderMet = new FileReaderImpl();
        OperationStrategy strategy = new OperationStrategy();
        DataProcessingMet dataProcessingMet = new DataProcessingImpl(strategy);
        ReportGenerationMet reportGenerationMet = new ReportGenerationImpl();
        FileWriterMet fileWriterMet = new FileWriterImpl();

        List<String> fruits = fileReaderMet.readFile("fruits.csv");

        Map<String, Integer> updateFruits = dataProcessingMet.processData(fruits);

        String textToFile = reportGenerationMet.reportGeneration(updateFruits);

        fileWriterMet.writeToFile("target/result.csv", textToFile);
    }
}
