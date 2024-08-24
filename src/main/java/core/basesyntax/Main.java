package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.enums.Operation;
import core.basesyntax.service.CsvReader;
import core.basesyntax.service.Mapper;
import core.basesyntax.service.ShopService;
import core.basesyntax.service.impl.CsvReaderImpl;
import core.basesyntax.service.impl.FruitTransactionMapper;
import core.basesyntax.service.impl.ShopServiceImpl;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.impl.OperationStrategyImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        CsvReader reader = new CsvReaderImpl();
        List<String> strings = reader.readLines("fruits.csv");

        Mapper<FruitTransaction> mapper = new FruitTransactionMapper();
        List<FruitTransaction> transactions = strings.stream()
                .map(mapper::stringToObject)
                .toList();
        transactions.forEach(System.out::println);

        Map<Operation, OperationHandler> strategiesMap = new HashMap<>();

        // fill up strategies

        OperationStrategy strategy = new OperationStrategyImpl(strategiesMap);
        ShopService service = new ShopServiceImpl(strategy);
        Map<String, Integer> fruitQuantityMap = service.process(transactions);
        // Generate report based on data
        // Write report to new CSV file
    }
}
