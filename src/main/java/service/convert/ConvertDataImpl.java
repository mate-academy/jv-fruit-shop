package service.convert;

import java.util.ArrayList;
import java.util.List;
import model.FruitTransaction;

public class ConvertDataImpl implements ConvertData {
    private List<FruitTransaction> fruitTransactions = new ArrayList<>();

    @Override
    public List<FruitTransaction> convert(List<String> data) {
        for (String stringData : data) {
            String[] temporaryArr = stringData.split(",");
            fruitTransactions.add(new FruitTransaction(temporaryArr[0],
                                                        temporaryArr[1],
                                                        Integer.parseInt(temporaryArr[2])));
        }
        return fruitTransactions;
    }
}
