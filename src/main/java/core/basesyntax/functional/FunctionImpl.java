package core.basesyntax.functional;

import core.basesyntax.db.DataBase;
import core.basesyntax.db.DataBaseImpl;
import java.util.List;
import java.util.Map;

public class FunctionImpl implements Function {
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final int ZERO_BALANCE = 0;
    private static final String BALANCE_OPERATION_INDICATOR = "b";
    private static final String HEAD_OF_REPORT = "fruit,quantity\n";
    private DataBase db = DataBaseImpl.getDataBase();

    @Override
    public void extractBalance(List<String[]> list) {
        list.remove(OPERATION_INDEX);
        list.forEach(value -> {
            if (value[OPERATION_INDEX].equals("b")) {
                db.addBalanceOfFruit(value[FRUIT_INDEX], value[QUANTITY_INDEX]);
            } else {
                db.addFruitToStorage(value);
            }
        });
    }

    @Override
    public void checkPositiveValueOfBalance(int i) {
        if (i <= ZERO_BALANCE) {
            throw new RuntimeException("the balance must be positive!");
        }
    }

    @Override
    public String fomReport(Map<String, String> map) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(HEAD_OF_REPORT);
        for (Map.Entry<String, String> entry : map.entrySet()) {
            stringBuilder.append(entry.getKey()).append(",").append(entry.getValue()).append("\n");
        }
        return stringBuilder.toString();
    }
}
