package core.basesyntax.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import core.basesyntax.converter.DataConverter;
import core.basesyntax.converter.DataConverterImpl;
import core.basesyntax.db.Operation;
import core.basesyntax.db.Storage;
import core.basesyntax.service.impl.CsvReader;
import core.basesyntax.service.impl.CsvReaderImpl;
import core.basesyntax.service.impl.FruitShopService;
import core.basesyntax.service.impl.FruitShopServiceImpl;
import core.basesyntax.service.impl.ReportService;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.service.impl.ReportWriter;
import core.basesyntax.service.impl.ReportWriterImpl;
import core.basesyntax.strategy.BalanceOperation;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import core.basesyntax.strategy.PurchaseOperation;
import core.basesyntax.strategy.ReturnOperation;
import core.basesyntax.strategy.SupplyOperation;

public class Main {
    public static void main(String[] arg) {
        String pathFile = "reportToRead.csv";
        CsvReader reader = new CsvReaderImpl();
        List<String> lines = reader.read(pathFile);

        DataConverter converter = new DataConverterImpl();
        final List<FruitTransaction> transaction = converter.convert(lines);

        Map<Operation, OperationHandler> handlers = new HashMap<>();
        handlers.put(Operation.BALANCE, new BalanceOperation());
        handlers.put(Operation.PURCHASE, new PurchaseOperation());
        handlers.put(Operation.RETURN, new ReturnOperation());
        handlers.put(Operation.SUPPLY, new SupplyOperation());
        OperationStrategy operationStrategy = new OperationStrategyImpl(handlers);

        FruitShopService fruitShopService = new FruitShopServiceImpl(operationStrategy);
        fruitShopService.process(transaction);

        ReportService reportService = new ReportServiceImpl();
        String report = reportService.generateReport(Storage.getStorage());

        ReportWriter reportWriter = new ReportWriterImpl();
        reportWriter.writeReport(report, "report.txt");
    }
}
