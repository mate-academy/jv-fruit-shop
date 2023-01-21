package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.service.Reader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class ReaderImpl implements Reader {
    private static final int OPERATION = 0;
    private static final int FRUIT = 1;
    private static final int QUANTITY = 2;

    @Override
    public List<FruitTransaction> readFromFile(String filePath) {
        List<FruitTransaction> list = new ArrayList<>();
        try {
            File file = new File(filePath);
            List<String> activities = Files.readAllLines(file.toPath());
            for (int i = 1; i < activities.size(); i++) {
                String[] activityArray = activities.get(i).split(",");
                list.add(new FruitTransaction(Operation.getOperation(activityArray[OPERATION]),
                        activityArray[FRUIT],Integer.parseInt(activityArray[QUANTITY])));
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read from file", e);
        }
        return list;
    }
}
