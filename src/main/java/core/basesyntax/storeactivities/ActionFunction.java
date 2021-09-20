package core.basesyntax.storeactivities;

import core.basesyntax.filevalidatorservice.Validator;
import java.util.HashMap;

public class ActionFunction implements Validator {
    private StoreFunction storeFunctions;

    public void executeAction(HashMap<String, Integer> hashMap, String[] line) {
        switch (line[OPERATION_INDEX]) {
            case "s":
                storeFunctions = new SupplyFunction();
                break;
            case "p":
                storeFunctions = new PurchaseFunction();
                break;
            case "r":
                storeFunctions = new ReturnFunction();
                break;
            default:
                storeFunctions = new BalanceFunction();
                break;
        }
        storeFunctions.action(hashMap, line[FRUIT_INDEX], Integer.parseInt(line[AMOUNT_INDEX]));
    }
}
