package core.basesyntax.infratructure.db;

import core.basesyntax.service.Operation;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class InsertListImpl implements InsertListDao {
    private static final String FILE_NAME = "src/main/java/operationslist.csv";

    @Override
    public void writeInfo(Operation operation, String fruitName, int amount) throws IOException {
        BufferedWriter br = new BufferedWriter(new FileWriter(FILE_NAME, true));
        br.write(operation.getCode() + "," + fruitName + "," + amount + System.lineSeparator());
        br.close();

    }
}
