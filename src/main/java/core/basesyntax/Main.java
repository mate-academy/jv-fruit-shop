package core.basesyntax;

import core.basesyntax.converter.MapToStringListConverter;
import core.basesyntax.converter.StringListToFruitListConverter;
import core.basesyntax.converter.impl.MapToStringListConverterImpl;
import core.basesyntax.converter.impl.StringListToFruitListConverterImpl;
import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.db.FruitDatabase;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationStrategySupplier;
import core.basesyntax.service.impl.OperationStrategySupplierImpl;
import core.basesyntax.service.operation.OperationStrategy;
import core.basesyntax.service.operation.impl.BalanceOperationStrategy;
import core.basesyntax.service.operation.impl.PurchaseOperationStrategy;
import core.basesyntax.service.operation.impl.ReturnOperationStrategy;
import core.basesyntax.service.operation.impl.SupplyOperationStrategy;
import core.basesyntax.util.FileReader;
import core.basesyntax.util.FileWriter;
import core.basesyntax.util.impl.FileReaderImpl;
import core.basesyntax.util.impl.FileWriterImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        FruitDao fruitDao = new FruitDaoImpl();
        Map<FruitTransaction.Operation, OperationStrategy> strategies = new HashMap<>();
        strategies.put(FruitTransaction.Operation.BALANCE,
                new BalanceOperationStrategy(fruitDao));
        strategies.put(FruitTransaction.Operation.SUPPLY,
                new SupplyOperationStrategy(fruitDao));
        strategies.put(FruitTransaction.Operation.PURCHASE,
                new PurchaseOperationStrategy(fruitDao));
        strategies.put(FruitTransaction.Operation.RETURN,
                new ReturnOperationStrategy(fruitDao));

        String pathToInputFile = "src/main/java/core/basesyntax/csv/input.csv";
        String pathToReport = "src/main/java/core/basesyntax/csv/report.csv";
        FileReader fileReader = new FileReaderImpl(pathToInputFile);
        List<String> strings = fileReader.readLines();

        StringListToFruitListConverter toFruitListConverter =
                new StringListToFruitListConverterImpl();
        List<FruitTransaction> fruitTransactions = toFruitListConverter.parseList(strings);

        OperationStrategySupplier operationStrategySupplier =
                new OperationStrategySupplierImpl(strategies);
        for (FruitTransaction fruitTransaction : fruitTransactions) {
            OperationStrategy fruitOperation =
                    operationStrategySupplier.get(fruitTransaction.getOperation());
            fruitOperation.performOperation(fruitTransaction);
        }

        MapToStringListConverter toStringListConverter = new MapToStringListConverterImpl();
        List<String> reportStrings = toStringListConverter.parseMap(FruitDatabase.database);

        FileWriter fileWriter = new FileWriterImpl(pathToReport);
        fileWriter.writeToFile(reportStrings);
    }
}
