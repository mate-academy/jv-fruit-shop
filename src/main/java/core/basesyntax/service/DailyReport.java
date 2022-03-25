package core.basesyntax.service;

import core.basesyntax.dao.DataFromDbImpl;
import core.basesyntax.dao.DataToDb;
import core.basesyntax.dao.DataToDbImpl;
import core.basesyntax.model.Transaction;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class DailyReport {

    public static final int OPERATION = 0;
    public static final int QUANTITY = 2;
    public static final String PURCHASE = Transaction.PURCHASE.getTransaction();
    private List<String> result = new ArrayList<>();
    private int quantity;

    private DataFromDbImpl datafromDb = new DataFromDbImpl();
    private DataToDb dataToDb = new DataToDbImpl();
    private Map<String, List<String[]>> resultMap = datafromDb.readFileToMap();

    public List<String> createListFronMap() {
        for (Map.Entry entry : resultMap.entrySet()) {
            StringBuilder stringBuilder = new StringBuilder();
            int summ = 0;
            List<String[]> listArrayOperation = (List<String[]>) entry.getValue();
            for (String[] currentOperation: listArrayOperation) {
                try {
                    quantity = Integer.parseInt(currentOperation[QUANTITY]);
                } catch (NumberFormatException e) {
                    System.out.println("Error input string " + Arrays.toString(currentOperation));
                }
                if (PURCHASE.equals(currentOperation[OPERATION])) {
                    quantity = quantity * (-1);
                }
                summ += quantity;
            }
            String res = stringBuilder.append(entry.getKey()).append(", ").append(summ).toString();
            result.add(res);
        }
        dataToDb.generateListToWriteFile(result);
        return result;
    }
}
