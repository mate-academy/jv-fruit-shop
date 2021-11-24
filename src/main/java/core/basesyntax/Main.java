package core.basesyntax;

import core.basesyntax.db.Storage;
import core.basesyntax.model.TransactionDto;
import core.basesyntax.service.FruitShopFileReader;
import core.basesyntax.service.FruitShopFileWriter;
import core.basesyntax.service.Parser;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.Validator;
import core.basesyntax.service.impl.FruitShopFileReaderImpl;
import core.basesyntax.service.impl.FruitShopFileWriterImpl;
import core.basesyntax.service.impl.ParserImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.service.impl.ValidatorImpl;
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
        FruitShopFileReader reader = new FruitShopFileReaderImpl();
        List<String> lines = reader.read("./src/main/resources/fruits.csv");
        Parser<TransactionDto> parser = new ParserImpl();
        List<TransactionDto> transactions = new ArrayList<>();
        Validator validator = new ValidatorImpl();
        for (String line : lines) {
            if (parser.parseLine(line, validator) != null) {
                transactions.add(parser.parseLine(line, validator));
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
        String report = reportService.createReport(Storage.storage);
        FruitShopFileWriter fruitShopWriter = new FruitShopFileWriterImpl();
        fruitShopWriter.write(report, "./src/main/resources/fruitsReport.csv");
    }
}
