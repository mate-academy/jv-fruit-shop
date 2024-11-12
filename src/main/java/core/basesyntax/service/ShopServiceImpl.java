package core.basesyntax.service;

import core.basesyntax.model.Account;

import static core.basesyntax.Main.apple;
import static core.basesyntax.Main.banana;
import static core.basesyntax.Main.actionHandlerMap;


public class ShopServiceImpl implements ShopService {
    private ActionStrategy strategy = new ActionStrategyImpl(actionHandlerMap);

    @Override
    public void generate(String[] infoFromDatabase) {
        for (int i = 0; i < infoFromDatabase.length; i++) {
            generateByRow(infoFromDatabase[i]);
        }
    }

    void generateByRow(String row) {
        apple.setName("Apple");
        banana.setName("Banana");
        String[] category = row.split(",");
        if (category[0].equalsIgnoreCase(Account.Operation.BALANCE.getCode())) {
            if (category[1].equalsIgnoreCase(apple.getName())) {
                strategy.get(Account.Operation.BALANCE).count(apple, Integer.parseInt(category[2]));
            } else if (category[1].equalsIgnoreCase(banana.getName())) {
                strategy.get(Account.Operation.BALANCE).count(banana, Integer.parseInt(category[2]));
            }
        } else if (category[0].equalsIgnoreCase(Account.Operation.PURCHASE.getCode())) {
            if (category[1].equalsIgnoreCase(apple.getName())) {
                strategy.get(Account.Operation.PURCHASE).count(apple, Integer.parseInt(category[2]));
            } else if (category[1].equalsIgnoreCase(banana.getName())) {
                strategy.get(Account.Operation.PURCHASE).count(banana, Integer.parseInt(category[2]));
            }
        } else if (category[0].equalsIgnoreCase(Account.Operation.RETURN.getCode())) {
            if (category[1].equalsIgnoreCase(apple.getName())) {
                strategy.get(Account.Operation.RETURN).count(apple, Integer.parseInt(category[2]));
            } else if (category[1].equalsIgnoreCase(banana.getName())) {
                strategy.get(Account.Operation.RETURN).count(banana, Integer.parseInt(category[2]));
            }
        } else if (category[0].equalsIgnoreCase(Account.Operation.SUPPLY.getCode())) {
            if (category[1].equalsIgnoreCase(apple.getName())) {
                strategy.get(Account.Operation.SUPPLY).count(apple, Integer.parseInt(category[2]));
            } else if (category[1].equalsIgnoreCase(banana.getName())) {
                strategy.get(Account.Operation.SUPPLY).count(banana, Integer.parseInt(category[2]));
            }
        }
    }
}
