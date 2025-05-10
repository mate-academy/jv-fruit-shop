package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.report.ReportGenerator;
import core.basesyntax.service.DataConverter;
import core.basesyntax.service.FileReader;
import core.basesyntax.service.FileWriter;
import core.basesyntax.service.ShopService;
import java.util.List;

public class FruitShopApplication {

    private final FileReader fileReader;
    private final DataConverter dataConverter;
    private final ShopService shopService;
    private final ReportGenerator reportGenerator;
    private final FileWriter fileWriter;

    public FruitShopApplication(FileReader fileReader, DataConverter dataConverter,
                                ShopService shopService, ReportGenerator reportGenerator,
                                FileWriter fileWriter) {
        this.fileReader = fileReader;
        this.dataConverter = dataConverter;
        this.shopService = shopService;
        this.reportGenerator = reportGenerator;
        this.fileWriter = fileWriter;
    }

    public void generateFruitReport(String inputFilePath, String outputFilePath) {
        List<String> inputReport = fileReader.read(inputFilePath);

        List<FruitTransaction> transactions = dataConverter.convertToTransaction(inputReport);

        shopService.process(transactions);

        String resultingReport = reportGenerator.getReport(shopService.getStorageReport());

        fileWriter.write(resultingReport, outputFilePath);
    }
}
