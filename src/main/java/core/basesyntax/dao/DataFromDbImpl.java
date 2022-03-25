package core.basesyntax.dao;

import core.basesyntax.db.ReadFile;
import core.basesyntax.db.ReadFileImpl;
import core.basesyntax.model.Transaction;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataFromDbImpl implements DataFromDb {
    public static final String FILE_CSV_PATH = "src/main/resources/fullreport.csv";
    public static final String STRING_TO_ARRAY_SEPARATOR = ",";
    private static final ReadFile readFile = new ReadFileImpl();
    private final List<String> listFromFile = readFile.readFileToList(FILE_CSV_PATH);
    private final Map<String, List<String[]>> fruitMap = new HashMap<>();

    @Override
    public Map<String, List<String[]>> readFileToMap() {
        if (listFromFile != null && listFromFile.size() != 0) {
            for (String s: listFromFile) {
                String[] fruitOperation = s.split(STRING_TO_ARRAY_SEPARATOR);
                if (isAnOperation(fruitOperation)) {
                    createdMap(fruitOperation);
                }
            }
            return fruitMap;
        }
        return null;
    }

    private boolean isAnOperation(String[] strings) {
        Transaction[] transaction = Transaction.values();
        if ((strings[OPERATION] != null
                && strings[FRUIT_NAME] != null
                && strings[QUANTITY] != null)) {
            for (Transaction t :transaction) {
                if (t.getTransaction().equals(strings[OPERATION])) {
                    return true;
                }
            }
        }
        return false;
    }

    private void createdMap(String[] newLine) {
        if (fruitMap.isEmpty() || !fruitMap.containsKey(newLine[FRUIT_NAME])) {
            fruitMap.put(newLine[FRUIT_NAME], new ArrayList<>(Collections.singleton(newLine)));
        } else {
            List<String[]> current;
            current = fruitMap.get(newLine[FRUIT_NAME]);
            current.add(newLine);
        }
    }
}
