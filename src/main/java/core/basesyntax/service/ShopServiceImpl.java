package core.basesyntax.service;

import static core.basesyntax.Main.actionHandlerMap;

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
        String[] category = row.split(",");
        if (category[0].startsWith("b")) {
            if (category[1].equalsIgnoreCase("banana")) {
                strategy.get(Account.Operation.BALANCE).countBanana(Integer.parseInt(category[2]));
            } else if (category[1].equalsIgnoreCase("apple")) {
                strategy.get(Account.Operation.BALANCE).countApple(Integer.parseInt(category[2]));
            }
        } else if (category[0].startsWith("p")) {
            if (category[1].equalsIgnoreCase("banana")) {
                strategy.get(Account.Operation.PURCHASE).countBanana(Integer.parseInt(category[2]));
            } else if (category[1].equalsIgnoreCase("apple")) {
                strategy.get(Account.Operation.PURCHASE).countApple(Integer.parseInt(category[2]));
            }
        } else if (category[0].startsWith("r")) {
            if (category[1].equalsIgnoreCase("banana")) {
                strategy.get(Account.Operation.RETURN).countBanana(Integer.parseInt(category[2]));
            } else if (category[1].equalsIgnoreCase("apple")) {
                strategy.get(Account.Operation.RETURN).countApple(Integer.parseInt(category[2]));
            }
        } else if (category[0].startsWith("s")) {
            if (category[1].equalsIgnoreCase("banana")) {
                strategy.get(Account.Operation.SUPPLY).countBanana(Integer.parseInt(category[2]));
            } else if (category[1].equalsIgnoreCase("apple")) {
                strategy.get(Account.Operation.SUPPLY).countApple(Integer.parseInt(category[2]));
            }
        }
    }
}
