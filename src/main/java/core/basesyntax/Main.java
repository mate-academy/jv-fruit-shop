package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.impl.ConvertServiceImpl;
import core.basesyntax.service.impl.ReaderServiceImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.service.impl.StoreServiceImpl;
import core.basesyntax.service.impl.WriterServiceImpl;
import core.basesyntax.service.impl.service.ConvertService;
import core.basesyntax.service.impl.service.ReaderService;
import core.basesyntax.service.impl.service.ReportService;
import core.basesyntax.service.impl.service.WriterService;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        OperationStrategy operationStrategy = new OperationStrategyImpl();

        ReaderService fileReader = new ReaderServiceImpl();
        List<String> rows = fileReader.readData("src/main/resources/validValues_ok.csv");

        ConvertService converter = new ConvertServiceImpl(operationStrategy);
        List<FruitTransaction> fruitTransactionList = converter.convertData(rows);

        StoreServiceImpl storeService = new StoreServiceImpl(operationStrategy);
        storeService.putToMap(fruitTransactionList);

        ReportService reportService = new ReportServiceImpl();
        String report = reportService.getReport();

        WriterService fileWriter = new WriterServiceImpl();
        fileWriter.writeData(report, "src/main/resources/report.csv");
    }
}
