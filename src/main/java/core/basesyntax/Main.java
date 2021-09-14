package core.basesyntax;

import core.basesyntax.db.Storage;
import core.basesyntax.service.FIleWriterService;
import core.basesyntax.service.FIleWriterServiceImpl;
import core.basesyntax.service.FileReaderService;
import core.basesyntax.service.FileReaderServiceImpl;
import core.basesyntax.service.FruitShopService;
import core.basesyntax.service.FruitShopServiceImpl;
import core.basesyntax.service.ReportMakerService;
import core.basesyntax.service.ReportMakerServiceImpl;
import java.util.List;

public class Main {
    private static final String INPUT_FILE_NAME = "src/main/resources/fruits.csv";
    private static final String OUTPUT_FILE_NAME = "src/main/resources/report.csv";

    public static void main(String[] args) {
        FileReaderService fileReaderService = new FileReaderServiceImpl();
        List<String> rowsList = fileReaderService.readRowsFromFile(INPUT_FILE_NAME);

        FruitShopService fruitShopService = new FruitShopServiceImpl();
        fruitShopService.addInfoToStorage(rowsList);

        ReportMakerService fruitReporter = new ReportMakerServiceImpl();
        String report = fruitReporter.getReport(Storage.getStorage());

        FIleWriterService fileWriter = new FIleWriterServiceImpl();
        fileWriter.writeToFile(report, OUTPUT_FILE_NAME);
    }
}
