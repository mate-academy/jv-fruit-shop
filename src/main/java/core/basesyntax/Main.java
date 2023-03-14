package core.basesyntax;

import java.util.List;
import model.FruitTransaction;
import service.FileParserService;
import service.FileReaderService;
import service.FileWriterService;
import service.FruitShopService;
import service.ReportGenerator;
import service.impl.FileParserServiceImpl;
import service.impl.FileReaderServiceImpl;
import service.impl.FileWriterServiceImpl;
import service.impl.FruitShopServiceImpl;
import service.impl.ReportGeneratorImpl;

public class Main {
    private static String inputFilePath = "src/main/resources/input.csv";
    private static String outputFilePath = "src/main/resources/output.csv";

    public static void main(String[] args) {
        FileReaderService fileReaderService = new FileReaderServiceImpl();
        List<String> lines = fileReaderService.readFromFile(inputFilePath);
        FileParserService fileParserService = new FileParserServiceImpl();
        List<FruitTransaction> transactions = fileParserService.parseFileInformation(lines);
        FruitShopService fruitShopService = new FruitShopServiceImpl();
        fruitShopService.startFruitsOperations(transactions);
        ReportGenerator reportGenerator = new ReportGeneratorImpl();
        String report = reportGenerator.createReport();
        FileWriterService fileWriterService = new FileWriterServiceImpl();
        fileWriterService.writeToFile(report, outputFilePath);
    }
}
