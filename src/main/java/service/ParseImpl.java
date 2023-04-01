package service;

import java.util.ArrayList;
import java.util.List;
import model.FruitTransaction;

public class ParseImpl implements ParseService {
    private static final String COMMA = ",";
    private static final int OPERATOR_TYPE_INDEX = 0;
    private static final int FRUIT_NAME_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    @Override
    public List<FruitTransaction> parse(List<String> dataFromFile) {
        if (dataFromFile != null || !dataFromFile.isEmpty()) {
            List<FruitTransaction> listFruit = new ArrayList<>();
            for (int i = 1; i < dataFromFile.size(); i++) {
                String[] fields = dataFromFile.get(i).split(COMMA);
                listFruit.add(new FruitTransaction(
                        FruitTransaction.OperationType.getByCode(fields[OPERATOR_TYPE_INDEX]),
                        fields[FRUIT_NAME_INDEX],
                        Integer.parseInt(fields[QUANTITY_INDEX]))
                );
            }
            return listFruit;
        } else {
            throw new RuntimeException("Your data is empty!");
        }
    }
}
