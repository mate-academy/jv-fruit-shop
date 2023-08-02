package core.basesyntax;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ConvertDataFromFileService;
import core.basesyntax.service.GenerateReportService;
import core.basesyntax.service.ReadFromFileService;
import core.basesyntax.service.ShopService;
import core.basesyntax.service.WriteToFileService;
import core.basesyntax.service.implementation.ConvertDataFromFileServiceImpl;
import core.basesyntax.service.implementation.GenerateReportServiceImpl;
import core.basesyntax.service.implementation.ReadFromFileServiceImpl;
import core.basesyntax.service.implementation.ShopServiceImpl;
import core.basesyntax.service.implementation.WriteToFileServiceImpl;
import java.io.File;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        File transactionsFile = new File("src/main/resources/test.csv");
        File reportFile = new File("src/main/resources/report.csv");
        ReadFromFileService readFromFileService = new ReadFromFileServiceImpl();
        String rawData = readFromFileService.getDataFromFile(transactionsFile);

        ConvertDataFromFileService convertDataFromFileService
                = new ConvertDataFromFileServiceImpl();
        List<FruitTransaction> convertedData = convertDataFromFileService.convert(rawData);

        Storage storage = new Storage();
        ShopService shopService = new ShopServiceImpl(storage);
        for (FruitTransaction transaction : convertedData) {
            shopService.process(transaction);
        }

        GenerateReportService generateReportService = new GenerateReportServiceImpl();
        String report = generateReportService.generate();

        WriteToFileService writeToFileService = new WriteToFileServiceImpl();
        writeToFileService.writeToFile(report, reportFile);
    }
}
