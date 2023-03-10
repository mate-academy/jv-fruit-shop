package core.basesyntax;

import core.basesyntax.fruitstoreoperation.BuyFruitOperation;
import core.basesyntax.fruitstoreoperation.FruitStoreOperation;
import core.basesyntax.fruitstoreoperation.ReturnFruitOperation;
import core.basesyntax.fruitstoreoperation.SupplyFruitOperation;
import core.basesyntax.model.InputDataModel;
import core.basesyntax.model.TransactionModel;
import core.basesyntax.parser.Parser;
import core.basesyntax.parser.ProductParser;
import core.basesyntax.parser.TransactionModelParser;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FruitStoreService {
    private static Map<String, FruitStoreOperation> fruitStoreOperationMap = new HashMap<>();

    static {
        fruitStoreOperationMap.put("s", new SupplyFruitOperation());
        fruitStoreOperationMap.put("b", new BuyFruitOperation());
        fruitStoreOperationMap.put("r", new ReturnFruitOperation());
    }

    public void processData(List<List<String>> data) {
        OperationStrategy strategy = new OperationStrategy(fruitStoreOperationMap);
        Parser<TransactionModel> transactionParser = new TransactionModelParser();
        Parser<InputDataModel> productParser = new ProductParser();
        TransactionModel transactionModel;
        InputDataModel inputDataModel;
        for (List<String> operation : data) {
            transactionModel = transactionParser.parse(operation);
            inputDataModel = productParser.parse(operation);
            FruitStoreOperation fruitStoreOperation
                    = strategy.choseOperation(transactionModel.getOperation());
            fruitStoreOperation.doOperation(inputDataModel, transactionModel.getAmount());
        }
    }

}
