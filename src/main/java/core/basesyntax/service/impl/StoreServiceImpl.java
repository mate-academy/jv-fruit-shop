package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.impl.service.ActivityTypeStrategy;
import core.basesyntax.service.impl.service.StoreService;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StoreServiceImpl implements StoreService {
    private static final String EXCEPTION_INFO
            = "Quantity cannot be negative! Insert correct values to input file";
    private static final String INVALID_INPUT_PARAMETER
            = "Invalid input parameter";
    private static final String IN_GET_OPERATION_AMOUNT = " in getOperationsAmount()";
    private static final String IN_GET_FRUIT_LIST = " in getFruitList()";
    private ActivityTypeStrategy activityTypeStrategy;

    public StoreServiceImpl(ActivityTypeStrategy activityTypeStrategy) {
        this.activityTypeStrategy = activityTypeStrategy;
    }

    @Override
    public List<Integer> getOperationsAmount(List<FruitTransaction> fruitTransactionList) {
        checkInvalidParameterForGetOperationsAmount(fruitTransactionList);
        List<Integer> amount = new ArrayList<>();
        int sum = 0;
        List<String> fruitList = getFruitList(fruitTransactionList);
        for (String fruit : fruitList) {
            for (FruitTransaction element : fruitTransactionList) {
                if (fruit.equals(element.getFruit())) {
                    sum += countQuantity(element);
                }
            }
            amount.add(getSum(sum));
            sum = 0;
        }
        return amount;
    }

    @Override
    public List<String> getFruitList(List<FruitTransaction> fruitTransactionList) {
        checkInvalidParameterForGetFruitList(fruitTransactionList);
        return fruitTransactionList.stream()
                .map(fruitTransaction -> fruitTransaction.getFruit())
                .distinct()
                .collect(Collectors.toList());
    }

    private int countQuantity(FruitTransaction fruitTransaction) {
        String codeType = fruitTransaction.getOperation().getCode();
        int fruitQuantity = fruitTransaction.getQuantity();
        return activityTypeStrategy.get(codeType).getSumOfOperation(fruitQuantity);
    }

    private int getSum(int sum) {
        if (sum < 0) {
            throw new RuntimeException(EXCEPTION_INFO);
        }
        return sum;
    }

    private RuntimeException checkInvalidParameterForGetOperationsAmount(
            List<FruitTransaction> fruitTransactionList) {
        if (fruitTransactionList == null) {
            throw new RuntimeException(INVALID_INPUT_PARAMETER + IN_GET_OPERATION_AMOUNT);
        }
        return null;
    }

    private RuntimeException checkInvalidParameterForGetFruitList(
            List<FruitTransaction> fruitTransactionList) {
        if (fruitTransactionList == null) {
            throw new RuntimeException(INVALID_INPUT_PARAMETER + IN_GET_FRUIT_LIST);
        }
        return null;
    }
}
