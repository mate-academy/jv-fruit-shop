package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.impl.FruitInputServiceImpl;
import core.basesyntax.service.impl.FruitOutputServiceImpl;
import core.basesyntax.strategy.OperationHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Feel free to remove this class and create your own.
 */
public class Main {
public static void  main(String[] args) {

    /*Map<String, FruitService> operationStrategies = new HashMap<>();
    operationStrategies.put("Read", new FruitInputServiceImpl());
    operationStrategies.put("Write", new FruitOutputServiceImpl());
*/

    // FruitService fruitService = new FruitServiceImpl(operationStrategies);

    List<String> dataFromFile = fileReader.readFromFile(inputFilePath);
    List<FruitTransaction> fruitTransactionsList
            = parser.getFruitTransactionsList(dataFromFile);
    OperationStrategy operationStrategy = new OperationStrategyImpl(strategies);
    for (FruitTransaction fruitTransaction : fruitTransactionsList) {
        OperationHandler handler = operationStrategy
                .get(fruitTransaction.getOperation());
        handler.operate(fruitTransaction);
    }
    String report = reportService.createReport();
    writerService.writeToFile(report, reportFilePath);



}

}
