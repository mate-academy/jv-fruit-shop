package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataConversionService;
import core.basesyntax.service.FileReaderService;
import core.basesyntax.service.FileWriterService;
import core.basesyntax.service.ReportGenerationService;
import core.basesyntax.service.ShopService;
import core.basesyntax.service.implementation.DataConversionServiceImpl;
import core.basesyntax.service.implementation.FileReaderServiceImpl;
import core.basesyntax.service.implementation.FileWriterServiceImpl;
import core.basesyntax.service.implementation.ReportGenerationServiceImpl;
import core.basesyntax.service.implementation.ShopServiceImpl;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String transactionsFile = "src/main/resources/test.csv";
        String reportFile = "src/main/resources/report.csv";
        FileReaderService fileReaderService = new FileReaderServiceImpl();
        String rawData = fileReaderService.read(transactionsFile);

        DataConversionService dataConversionService
                = new DataConversionServiceImpl();
        List<FruitTransaction> convertedData = dataConversionService.convert(rawData);

        ShopService shopService = new ShopServiceImpl();
        for (FruitTransaction transaction : convertedData) {
            shopService.process(transaction);
        }

        ReportGenerationService reportGenerationService = new ReportGenerationServiceImpl();
        String report = reportGenerationService.generate();

        FileWriterService fileWriterService = new FileWriterServiceImpl();
        fileWriterService.write(report, reportFile);
    }
}
