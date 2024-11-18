package core.basesyntax.converter;

import core.basesyntax.model.FruitTransaction;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class StringToFruitTransactionConverter implements Function<String, FruitTransaction> {

    @Override
    public FruitTransaction apply(String s) {
        StringToFruitValidator validator = new StringToFruitValidator();
        String[] arr = s.split(",");
        if (!validator.validateInputData(arr)) {
            throw new IllegalArgumentException("Error while parsing string [" + s + "]");
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
