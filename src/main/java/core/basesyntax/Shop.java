package core.basesyntax;

import core.basesyntax.service.impl.CombineOutputImpl;
import core.basesyntax.service.impl.CreateStrategyImpl;
import core.basesyntax.service.impl.DataValidatorImpl;
import core.basesyntax.service.impl.DoOperationImpl;
import core.basesyntax.service.impl.ReadFromFileImpl;
import core.basesyntax.service.impl.WriteToFileImpl;
import core.basesyntax.service.interfaces.CombineOutput;
import core.basesyntax.service.interfaces.CreateStrategy;
import core.basesyntax.service.interfaces.DataValidator;
import core.basesyntax.service.interfaces.DoOperation;
import core.basesyntax.service.interfaces.ReadFromFile;
import core.basesyntax.service.interfaces.WriteToFile;
import core.basesyntax.service.operations.Operation;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Shop {

    private Map<String, Integer> shop = new HashMap<>();

    public Shop(String pathData, String pathResult) {
        shop.put("banana", 0);
        shop.put("apple", 0);

        ReadFromFile fileReader = new ReadFromFileImpl();
        CreateStrategy strategyCreator = new CreateStrategyImpl();
        DataValidator validator = new DataValidatorImpl();
        DoOperation operator = new DoOperationImpl();
        CombineOutput outputCombiner = new CombineOutputImpl();
        WriteToFile fileWriter = new WriteToFileImpl();

        List<String> dataFromFile = fileReader.readFromFile(pathData);
        Map<String, Operation> strategy = strategyCreator.createStrategy();

        for (String line : dataFromFile) {
            String[] record = line.split(",");
            validator.isNumberValid(record);
            validator.isOperationValid(strategy, record);
            operator.doOperation(shop, record, strategy);
        }

        String output = outputCombiner.combineOutput(shop);
        fileWriter.write(pathResult, output);
    }
}
