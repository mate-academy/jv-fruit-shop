package core.basesyntax.service;

import core.basesyntax.service.model.FruitTransaction;

public class ParseServiceImpl implements ParseService {
    @Override
    public FruitTransaction parse(String line) {
        String[] tmp = line.split(",");
        switch (tmp[0]) {
            case "b":
                return new FruitTransaction(FruitTransaction.TypeOperation.BALANCE,
                            tmp[1], Integer.parseInt(tmp[2]));
            case "s":
                return
                    new FruitTransaction(FruitTransaction.TypeOperation.SUPPLY,
                            tmp[1], Integer.parseInt(tmp[2]));
            case "p":
                return
                    new FruitTransaction(FruitTransaction.TypeOperation.PURCHASE,
                            tmp[1], Integer.parseInt(tmp[2]));
            case "r":
                return
                    new FruitTransaction(FruitTransaction.TypeOperation.RETURN,
                            tmp[1], Integer.parseInt(tmp[2]));
            default:
                throw
                    new RuntimeException("Unknown operation");
        }
    }
}
