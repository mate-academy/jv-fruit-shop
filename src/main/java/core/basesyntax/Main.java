package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.CsvFileReaderService;
import core.basesyntax.service.CsvFileWriterService;
import core.basesyntax.service.FruitShopService;
import core.basesyntax.service.ReportMakerService;
import core.basesyntax.service.impl.CsvFileReaderServiceImpl;
import core.basesyntax.service.impl.CsvFileWriterServiceImpl;
import core.basesyntax.service.impl.FruitConverterImpl;
import core.basesyntax.service.impl.FruitShopServiceImpl;
import core.basesyntax.service.impl.ReportMakerServiceImpl;
import core.basesyntax.service.strategy.OperationStrategy;
import core.basesyntax.service.strategy.OperationStrategyImpl;

public class Main {
    public static void main(String[] args) {
        CsvFileReaderService csvFileReaderService = new CsvFileReaderServiceImpl();
        FruitConverterImpl transactionListService =
                new FruitConverterImpl();
        CsvFileWriterService csvFileWriterService = new CsvFileWriterServiceImpl();
        OperationStrategy operationStrategy = new OperationStrategyImpl();
        FruitShopService<FruitTransaction> fruitShopService =
                new FruitShopServiceImpl(operationStrategy);
        ReportMakerService reportMakerService = new ReportMakerServiceImpl();
        String transactions = csvFileReaderService.read("src/main/resources/data.csv");
        fruitShopService.update(transactionListService.convert(transactions));
        csvFileWriterService.write(reportMakerService.createReport(),
                "src/main/resources/output1.csv");
    }
}
