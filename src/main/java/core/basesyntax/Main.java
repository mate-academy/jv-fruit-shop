package core.basesyntax;

import core.basesyntax.config.AppConfig;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataConverter;
import core.basesyntax.service.FileReader;
import core.basesyntax.service.FileWriter;
import core.basesyntax.service.ReportGenerator;
import core.basesyntax.service.ShopService;
import core.basesyntax.service.StorageService;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Please provide input and output file paths as arguments.");
            return;
        }

        String inputFilePath = args[0];
        String outputFilePath = args[1];

        AppConfig appConfig = new AppConfig();
        StorageService storageService = appConfig.storageService();

        FileReader fileReader = appConfig.fileReader();
        List<String> inputReport = fileReader.read(inputFilePath);

        DataConverter dataConverter = appConfig.dataConverter();
        final List<FruitTransaction> transactions = dataConverter.convertToTransaction(inputReport);

        ShopService shopService = appConfig.shopService();
        shopService.process(transactions);

        ReportGenerator reportGenerator = appConfig.reportGenerator();
        String report = reportGenerator.getReport();

        System.out.println(report);

        FileWriter fileWriter = appConfig.fileWriter();
        fileWriter.write(report, outputFilePath);
    }
}
