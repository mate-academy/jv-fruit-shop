package core.basesyntax;

import core.basesyntax.db.Storage;
import core.basesyntax.model.TransactionDto;
import core.basesyntax.service.FruitShopReader;
import core.basesyntax.service.FruitShopWriter;
import core.basesyntax.service.Parser;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.impl.FruitShopReaderImpl;
import core.basesyntax.service.impl.FruitShopWriterImpl;
import core.basesyntax.service.impl.ParserImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.strategy.BalanceOperationHandler;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.PurchaseOperationHandler;
import core.basesyntax.strategy.SupplyAndReturnOperationHandler;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        FruitShopReader reader = new FruitShopReaderImpl();
        List<String> lines = reader.read("fruits.csv");
        Parser<TransactionDto> parser = new ParserImpl();
        List<TransactionDto> transactions = new ArrayList<>();
        for (String line : lines) {
            if (parser.parseLine(line) != null) {
                transactions.add(parser.parseLine(line));
            }
        }
        Map<String, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put("b", new BalanceOperationHandler());
        operationHandlerMap.put("p", new PurchaseOperationHandler());
        operationHandlerMap.put("s", new SupplyAndReturnOperationHandler());
        operationHandlerMap.put("r", new SupplyAndReturnOperationHandler());
        for (TransactionDto transaction : transactions) {
            String operation = transaction.getOperation();
            OperationHandler handler = operationHandlerMap.get(operation);
            handler.apply(transaction);
        }
        ReportService reportService = new ReportServiceImpl();
        String report = reportService.createReport(Storage.getStorage());
        FruitShopWriter fruitShopWriter = new FruitShopWriterImpl();
        fruitShopWriter.write(report, "fruitsReport.csv");
    }
}
