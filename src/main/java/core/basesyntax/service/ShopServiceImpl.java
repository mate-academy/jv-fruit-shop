package core.basesyntax.service;

import static core.basesyntax.Main.actionHandlerMap;

import core.basesyntax.Main;
import core.basesyntax.model.Account;

public class ShopServiceImpl implements ShopService {
    private ActionStrategy strategy = new ActionStrategyImpl(actionHandlerMap);

    @Override
    public void generate(String[] infoFromDatabase) {
        for (int i = 0; i < infoFromDatabase.length; i++) {
            generateByRow(infoFromDatabase[i]);
        }
    }

    void generateByRow(String row) {
        Main.getApple().setName("Apple");
        Main.getApple().setName("Banana");
        String[] category = row.split(",");
        if (category[0].equalsIgnoreCase(Account.Operation.BALANCE.getCode())) {
            if (category[1].equalsIgnoreCase(Main.getApple().getName())) {
                strategy.get(Account.Operation.BALANCE)
                        .count(Main.getApple(), Integer.parseInt(category[2]));
            } else if (category[1].equalsIgnoreCase(Main.getBanana().getName())) {
                strategy.get(Account.Operation.BALANCE)
                        .count(Main.getBanana(), Integer.parseInt(category[2]));
            }
        } else if (category[0].equalsIgnoreCase(Account.Operation.PURCHASE.getCode())) {
            if (category[1].equalsIgnoreCase(Main.getApple().getName())) {
                strategy.get(Account.Operation.PURCHASE)
                        .count(Main.getApple(), Integer.parseInt(category[2]));
            } else if (category[1].equalsIgnoreCase(Main.getBanana().getName())) {
                strategy.get(Account.Operation.PURCHASE)
                        .count(Main.getBanana(), Integer.parseInt(category[2]));
            }
        } else if (category[0].equalsIgnoreCase(Account.Operation.RETURN.getCode())) {
            if (category[1].equalsIgnoreCase(Main.getApple().getName())) {
                strategy.get(Account.Operation.RETURN)
                        .count(Main.getApple(), Integer.parseInt(category[2]));
            } else if (category[1].equalsIgnoreCase(Main.getBanana().getName())) {
                strategy.get(Account.Operation.RETURN)
                        .count(Main.getBanana(), Integer.parseInt(category[2]));
            }
        } else if (category[0].equalsIgnoreCase(Account.Operation.SUPPLY.getCode())) {
            if (category[1].equalsIgnoreCase(Main.getApple().getName())) {
                strategy.get(Account.Operation.SUPPLY)
                        .count(Main.getApple(), Integer.parseInt(category[2]));
            } else if (category[1].equalsIgnoreCase(Main.getBanana().getName())) {
                strategy.get(Account.Operation.SUPPLY)
                        .count(Main.getBanana(), Integer.parseInt(category[2]));
            }
        }
    }
}
