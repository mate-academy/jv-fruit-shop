package core.basesyntax;

import core.basesyntax.services.FileReader;
import core.basesyntax.services.FileWriter;
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
import core.basesyntax.model.FruitTransaction;

public class Main {
    private static final FileReader fileCsvReader = new CsvReaderImpl();
    private static final ProcessData processDataService = new ProcessDataImpl();
    private static final ReportCreator reportCreator = new ReportCreatorImpl();
    private static final FileWriter fileCsvWriter = new CsvWriterImpl();
    private static final OperationStrategy operationStrategy = new OperationStrategyImpl();
    private static final FruitShopUpdateService<FruitTransaction> fruitShopUpdateService =
            new FruitShopUpdateServiceImpl(operationStrategy);
    private static final String fromFilePath = "src/main/resources/CsvInput.csv";
    private static final String toFilePath = "src/main/resources/CsvOutput.csv";
    public static void main(String[] args) {
        String transactions = fileCsvReader.read(fromFilePath);
        fruitShopUpdateService.update(processDataService.process(transactions));
        fileCsvWriter.write(toFilePath, reportCreator.createReport());

    }
}
