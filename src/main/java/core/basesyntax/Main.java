package core.basesyntax;

import core.basesyntax.impl.CsvReaderImpl;
import core.basesyntax.impl.CsvWriterImpl;
import core.basesyntax.impl.OperationStrategyImpl;
import core.basesyntax.impl.ProcessDataImpl;
import core.basesyntax.impl.ReportCreator;
import core.basesyntax.impl.ShopUpdateImpl;
import core.basesyntax.service.CreateReport;
import core.basesyntax.service.CsvFileReader;
import core.basesyntax.service.CsvFileWriter;
import core.basesyntax.service.ProcessData;
import core.basesyntax.service.ShopUpdateService;
import core.basesyntax.strategy.Strategy;
import core.basesyntax.transactor.FruitTransaction;

public class Main {
    public static void main(String[] args) {
        CsvFileReader csvFileReader = new CsvReaderImpl();
        ProcessData processData = new ProcessDataImpl();
        Strategy operationStrategy = new OperationStrategyImpl();
        ShopUpdateService<FruitTransaction> fruitShopUpdateService
                = new ShopUpdateImpl(operationStrategy);
        CreateReport createReport = new ReportCreator();
        CsvFileWriter csvFileWriter = new CsvWriterImpl();
        String fileFromPath = "src/main/java/resources/InputCSV.csv";
        String fileToPath = "src/main/java/resources/OutputCSV.csv";

        String transaction = csvFileReader.readFile(fileFromPath);
        fruitShopUpdateService.update(processData.process(transaction));
        csvFileWriter.writeFile(fileToPath, createReport.createReport());
    }
}
