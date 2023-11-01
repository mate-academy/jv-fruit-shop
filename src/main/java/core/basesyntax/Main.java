package core.basesyntax;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.WriterService;
import core.basesyntax.service.impl.CsvReaderService;
import core.basesyntax.service.impl.CsvWriterService;
import core.basesyntax.service.impl.FruitMapperImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.strategy.BalanceOperationHandler;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.PurchaseOperationHandler;
import core.basesyntax.strategy.ReturnOperationHandler;
import core.basesyntax.strategy.SupplyOperationHandler;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        CsvReaderService csvReaderService = new CsvReaderService();
        List<String> lines = csvReaderService.readFromFile("src/main/resources/input.csv");
        FruitMapperImpl fruitMapper = new FruitMapperImpl();
        List<FruitTransaction> fruitTransactions = fruitMapper.mapData(lines);
        Map<Operation, OperationHandler> handlers = Map.of(
                Operation.BALANCE, new BalanceOperationHandler(),
                Operation.RETURN, new ReturnOperationHandler(),
                Operation.PURCHASE, new PurchaseOperationHandler(),
                Operation.SUPPLY, new SupplyOperationHandler()
        );
        OperationStrategy strategy = new OperationStrategy(handlers);
        for (FruitTransaction fruitTransaction : fruitTransactions) {
            strategy.applyOperation(fruitTransaction);
        }
        ReportService report = new ReportServiceImpl();
        String reportString = report.generateReport(Storage.storage);
        WriterService writer = new CsvWriterService();
        writer.write("src/main/resources/report.csv",reportString);
    }
}
