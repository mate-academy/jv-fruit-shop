package core.basesyntax;

import core.basesyntax.service.ActionReader;
import core.basesyntax.strategy.actions.ActionHandler;
import core.basesyntax.strategy.actions.BaseActionHandler;
import core.basesyntax.strategy.actions.PurchaseActionHandler;
import core.basesyntax.strategy.actions.SupplyActionHandler;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String from = "src/main/resources/test.csv";
    private static final String to = "src/main/resources/";

    public static void main(String[] args) {
        Map<String, Integer> shopStock;
        List<ActionHandler> possibleActions = allPossibleActions();
        ActionReader actionReader = new ActionReader();
        shopStock = actionReader.inputDataToMap(possibleActions, from);
        actionReader.outputMapToFile(shopStock, to);
    }

    private static List<ActionHandler> allPossibleActions() {
        List<ActionHandler> possibleActions = new ArrayList<>();
        possibleActions.add(new BaseActionHandler());
        possibleActions.add(new PurchaseActionHandler());
        possibleActions.add(new SupplyActionHandler());
        return possibleActions;
    }
}
