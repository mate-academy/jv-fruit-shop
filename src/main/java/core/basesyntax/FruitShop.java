package core.basesyntax;

import core.basesyntax.dto.Transaction;
import core.basesyntax.handler.AddOperationHandler;
import core.basesyntax.handler.BalanceOperationHandler;
import core.basesyntax.handler.OperationHandler;
import core.basesyntax.handler.RemoveOperationHandler;
import core.basesyntax.service.FruitFIleWriterImpl;
import core.basesyntax.service.FruitFileReader;
import core.basesyntax.service.FruitFileReaderImpl;
import core.basesyntax.service.FruitFileWriter;
import core.basesyntax.service.FruitShopService;
import core.basesyntax.service.FruitShopServiceImpl;
import core.basesyntax.service.Parser;
import core.basesyntax.service.ParserImpl;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FruitShop {
    public static void main(String[] args) {
        Map<String, OperationHandler> handlers = new HashMap<>();
        handlers.put("b", new BalanceOperationHandler());
        handlers.put("s", new AddOperationHandler());
        handlers.put("r", new AddOperationHandler());
        handlers.put("p", new RemoveOperationHandler());

        FruitFileReader fileReader = new FruitFileReaderImpl();
        List<String> lines = fileReader.read("src/main/java/core/basesyntax/resources/input.csv");

        Parser parser = new ParserImpl();
        List<Transaction> transactionList = new ArrayList<>();
        for (String line : lines) {
            transactionList.add(parser.parseLine(line));
        }

        OperationStrategy operationStrategy = new OperationStrategyImpl(handlers);

        for (Transaction transaction : transactionList) {
            OperationHandler handler = operationStrategy.get(transaction.getOperation());
            handler.apply(transaction);
        }

        FruitShopService fruitShopService = new FruitShopServiceImpl();
        String report = fruitShopService.createReport();

        FruitFileWriter fruitFileWriter = new FruitFIleWriterImpl();
        fruitFileWriter.writeToFile(report, "src/main/java/core/basesyntax/resources/output.csv");
    }
}
