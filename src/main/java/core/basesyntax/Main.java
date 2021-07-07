package core.basesyntax;

import core.basesyntax.service.FruitService;
import core.basesyntax.service.FruitServiceImpl;
import core.basesyntax.service.Parser;
import core.basesyntax.service.ParserImpl;
import core.basesyntax.service.Reader;
import core.basesyntax.service.ReaderImpl;
import core.basesyntax.service.Writer;
import core.basesyntax.service.WriterImpl;
import core.basesyntax.strategy.AddOperationHandler;
import core.basesyntax.strategy.BalanceOperationHandler;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.PurchaseOperationHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, OperationHandler> operationStrategyMap = new HashMap<>();
        operationStrategyMap.put("p", new PurchaseOperationHandler());
        operationStrategyMap.put("s", new AddOperationHandler());
        operationStrategyMap.put("b", new BalanceOperationHandler());
        operationStrategyMap.put("r", new AddOperationHandler());

        Reader fileReader = new ReaderImpl();
        Parser parser = new ParserImpl();
        List<String> contentFromFile =
                fileReader.readFromFile("src/main/resources/input.csv");

        contentFromFile.remove(0);
        contentFromFile.stream()
                .map(parser::parseLine)
                .forEach(transaction ->
                        operationStrategyMap.get(transaction.getOperation()).apply(transaction));

        FruitService reportService = new FruitServiceImpl();
        String report = reportService.getReport();

        Writer fileWriter = new WriterImpl();
        fileWriter.writeToFile("src/main/resources/report.csv", report);
    }
}
