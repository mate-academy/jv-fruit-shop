package core.basesyntax.converter;

import core.basesyntax.model.FruitTransaction;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class StringToFruitTransactionConverter implements Function<String, FruitTransaction> {

    @Override
    public FruitTransaction apply(String s) {
        String[] arr = s.split(",");
        if (arr.length != 3) {
            throw new RuntimeException("Cannot convert string [" + s + "] to FruitTransaction");
        }
        return new FruitTransaction(
                FruitTransaction.Operation.fromCode(arr[0]), arr[1], Integer.parseInt(arr[2]));
    }

    public List<FruitTransaction> applyList(List<String> list) {
        List<FruitTransaction> resultList = new ArrayList<>();
        for (String s : list) {
            if (!checkIsLineATitle(s)) {
                resultList.add(apply(s));
            }
        }
        return resultList;
    }

    boolean checkIsLineATitle(String s) {
        return s.contains("type")
                || s.contains("fruit")
                || s.contains("quantity");
    }
}
