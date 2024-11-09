package core.basesyntax.service;

import static core.basesyntax.Main.actionHandlerMap;

import core.basesyntax.model.Account;
import core.basesyntax.model.Apple;
import core.basesyntax.model.Banana;

public class ShopServiceImpl implements ShopService {
    private Banana banana = new Banana();
    private Apple apple = new Apple();
    private ActionStrategy strategy = new ActionStrategyImpl(actionHandlerMap);

    @Override
    public void generate(String[] infoFromDatabase) {
        for (int i = 0; i < infoFromDatabase.length; i++) {
            generateByRow(infoFromDatabase[i]);
        }
    }

    void generateByRow(String row) {
        String[] category = row.split(",");
        if (category[0].equalsIgnoreCase(Account.Operation.BALANCE.getCode())) {
            if (category[1].equalsIgnoreCase(banana.getName())) {
                strategy.get(Account.Operation.BALANCE).countBanana(Integer.parseInt(category[2]));
            } else if (category[1].equalsIgnoreCase(apple.getName())) {
                strategy.get(Account.Operation.BALANCE).countApple(Integer.parseInt(category[2]));
            }
        } else if (category[0].equalsIgnoreCase(Account.Operation.PURCHASE.getCode())) {
            if (category[1].equalsIgnoreCase(banana.getName())) {
                strategy.get(Account.Operation.PURCHASE).countBanana(Integer.parseInt(category[2]));
            } else if (category[1].equalsIgnoreCase(apple.getName())) {
                strategy.get(Account.Operation.PURCHASE).countApple(Integer.parseInt(category[2]));
            }
        } else if (category[0].equalsIgnoreCase(Account.Operation.RETURN.getCode())) {
            if (category[1].equalsIgnoreCase(banana.getName())) {
                strategy.get(Account.Operation.RETURN).countBanana(Integer.parseInt(category[2]));
            } else if (category[1].equalsIgnoreCase(apple.getName())) {
                strategy.get(Account.Operation.RETURN).countApple(Integer.parseInt(category[2]));
            }
        } else if (category[0].equalsIgnoreCase(Account.Operation.SUPPLY.getCode())) {
            if (category[1].equalsIgnoreCase(banana.getName())) {
                strategy.get(Account.Operation.SUPPLY).countBanana(Integer.parseInt(category[2]));
            } else if (category[1].equalsIgnoreCase(apple.getName())) {
                strategy.get(Account.Operation.SUPPLY).countApple(Integer.parseInt(category[2]));
            }
        }
    }
}
