package core.basesyntax;

import java.io.File;
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
        int indexOfHeadElement = 0;
        File fileInput = new File("src/main/resources/input.csv");
        FileReaderService fileReaderService = new FileReaderServiceImpl();
        List<String> infoFromFile = fileReaderService.getInfoFromFile(fileInput);
        infoFromFile.remove(indexOfHeadElement);
        ParserService parserService = new ParserServiceImpl(fileReaderService);
        List<FruitTransaction> parsedInfo = parserService.getFruitsFromFile(infoFromFile);
        FruitShopService fruitShopService = new FruitShopServiceImpl(parserService);
        List<FruitTransaction> procesedFruit = fruitShopService.processingData(parsedInfo);
        ReportCreatorService reportCreatorService = new ReportCreatorService();
        List<String> readyToWriteInFile = reportCreatorService.prepearingDataToWrite(procesedFruit);
        FileWriterService fileWriterService = new FileWriterServiceImpl();
        fileWriterService.writeToFile(readyToWriteInFile);
    }
}
