package core.basesyntax;

import java.util.List;
import model.FruitTransaction;
import service.FileReaderService;
import service.FileWriterService;
import service.FruitShopService;
import service.ReportCreatorService;
import service.impl.FileReaderServiceImpl;
import service.impl.FileWriterServiceImpl;
import service.impl.FruitShopServiceImpl;
import storage.ParserService;
import storage.ParserServiceImpl;

public class Main {
    public static void main(String[] args) {
        String fileName = "src/main/resources/input.csv";
        String fileNameToWrite = "src/main/resources/output.csv";
        FileReaderService fileReaderService = new FileReaderServiceImpl();
        List<String> infoFromFile = fileReaderService.getInfoFromFile(fileName);
        ParserService parserService = new ParserServiceImpl(fileReaderService);
        List<FruitTransaction> parsedInfo = parserService.getFruitsFromFile(infoFromFile);
        FruitShopService fruitShopService = new FruitShopServiceImpl(parserService);
        List<FruitTransaction> procesedFruit = fruitShopService.processingData(parsedInfo);
        ReportCreatorService reportCreatorService = new ReportCreatorService();
        String readyToWriteInFile = reportCreatorService.prepearingDataToWrite(procesedFruit);
        FileWriterService fileWriterService = new FileWriterServiceImpl();
        fileWriterService.writeToFile(readyToWriteInFile, fileNameToWrite);
    }
}
