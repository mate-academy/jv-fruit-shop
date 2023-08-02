package core.basesyntax;

import core.basesyntax.services.FileCsvReader;
import core.basesyntax.services.FileCsvWriter;
import core.basesyntax.services.FruitShopUpdateService;
import core.basesyntax.services.ProcessData;
import core.basesyntax.services.ReportCreator;
import core.basesyntax.services.impl.CsvReaderImpl;
import core.basesyntax.services.impl.CsvWriterImpl;
import core.basesyntax.services.impl.FruitShopUpdateServiceImpl;
import core.basesyntax.services.impl.OperationStrategyImpl;
import core.basesyntax.services.impl.ProcessDataImpl;
import core.basesyntax.services.impl.ReportCreatorImpl;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.transactor.FruitTransaction;

public class Main {
    public static void main(String[] args) {
        FileCsvReader fileCsvReader = new CsvReaderImpl();
        ProcessData processDataService = new ProcessDataImpl();
        ReportCreator reportCreator = new ReportCreatorImpl();
        FileCsvWriter fileCsvWriter = new CsvWriterImpl();
        String fromFilePath = "src/main/resources/CsvInput.csv";
        String toFilePath = "src/main/resources/CsvOutput.csv";
        OperationStrategy operationStrategy = new OperationStrategyImpl();
        FruitShopUpdateService<FruitTransaction> fruitShopUpdateService =
                new FruitShopUpdateServiceImpl(operationStrategy);
        String transactions = fileCsvReader.read(fromFilePath);
        fruitShopUpdateService.update(processDataService.process(transactions));
        fileCsvWriter.write(toFilePath, reportCreator.createReport());

    }
}
