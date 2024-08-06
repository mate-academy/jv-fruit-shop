package manager;

import converter.DataConverter;
import java.util.List;
import model.FruitTransaction;
import read.write.file.FileReader;
import read.write.file.FileWriter;
import report.ReportGenerator;
import service.ShopService;

public class FruitShopManager {
    private final FileReader fileReader;
    private final DataConverter dataConverter;
    private final ShopService shopService;
    private final ReportGenerator reportGenerator;
    private final FileWriter fileWriter;
    private final String inputFilePath;
    private final String outputFilePath;

    public FruitShopManager(FileReader fileReader, DataConverter dataConverter,
                            ShopService shopService, ReportGenerator reportGenerator,
                            FileWriter fileWriter,
                            String inputFilePath, String outputFilePath) {
        this.fileReader = fileReader;
        this.dataConverter = dataConverter;
        this.shopService = shopService;
        this.reportGenerator = reportGenerator;
        this.fileWriter = fileWriter;
        this.inputFilePath = inputFilePath;
        this.outputFilePath = outputFilePath;
    }

    public void manageShop() {
        List<String> inputReport = fileReader.read(inputFilePath);
        List<FruitTransaction> transactions = dataConverter.converterToTransaction(inputReport);
        shopService.process(transactions);
        String resultingReport = reportGenerator.getReport();
        fileWriter.write(resultingReport, outputFilePath);
    }
}
