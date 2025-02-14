package core.basesyntax;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        FileReaderMet fileReaderMet = new FileReaderImpl();
        DataProcessingMet dataProcessingMet = new DataProcessingImpl();
        ReportGenerationMet reportGenerationMet = new ReportGenerationImpl();
        FileWriterMet fileWriterMet = new FileWriterImpl();

        List<String> fruits = fileReaderMet.readFile("D:\\Project_Mate_Academy\\jv-fruit-shop"
                + "\\src\\main\\java\\core\\basesyntax\\fruits.csv");

        Map<String, Integer> updateFruits = dataProcessingMet.processData(fruits);

        String textToFile = reportGenerationMet.reportGeneration(updateFruits);

        fileWriterMet.writeToFile("D:\\Project_Mate_Academy\\jv-fruit-shop"
                + "\\src\\main\\java\\core\\basesyntax\\result.csv", textToFile);
    }
}
