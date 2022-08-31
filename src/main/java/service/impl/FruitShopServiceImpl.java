package service.impl;

import static service.OperationType.BALANCE;

import java.util.List;
import java.util.stream.Collectors;
import model.FruitTransaction;
import service.FruitShopService;
import service.OperationType;
import storage.ParserService;

public class FruitShopServiceImpl implements FruitShopService {
    private final ParserService parserServiceImpl;

    public FruitShopServiceImpl(ParserService parserServiceImpl) {
        this.parserServiceImpl = parserServiceImpl;
    }

    @Override
    public List<FruitTransaction> processingData(List<FruitTransaction> parsedInfo) {
        List<FruitTransaction> fruitsWithBalance = getFruitsWithBalanceType(parsedInfo);
        parsedInfo.removeAll(fruitsWithBalance);
        for (FruitTransaction fruitTransaction : parsedInfo) {
            OperationType operationType = fruitTransaction.getTypeOfOperation();
            int value = fruitTransaction.getValue();
            for (FruitTransaction fruit : fruitsWithBalance) {
                if (fruitTransaction.getFruitName().equals(fruit.getFruitName())) {
                    fruit.setValue(parseTypeOfOperation(
                            operationType, value, fruit.getValue()));
                }
            }
        }
        return fruitsWithBalance;
    }

    private List<FruitTransaction> getFruitsWithBalanceType(List<FruitTransaction> fruitsFromFile) {
        return fruitsFromFile.stream()
                .filter(i -> i.getTypeOfOperation().equals(BALANCE))
                .collect(Collectors.toList());
    }

    private int parseTypeOfOperation(OperationType operationType, int value, int balance) {
        switch (operationType) {
            case BALANCE:
                return balance;
            case PURCHASE:
                return balance - value;
            default:
                return balance + value;
        }
    }
}

