package core.basesyntax.dao;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteBalanceImpl implements WriteBalance {
    @Override
    public boolean write(String balance) throws IOException {
            File csvFile = new File("src/main/resources/balance.csv");
            FileWriter fileWriter = new FileWriter(csvFile);
            fileWriter.write(balance);
            fileWriter.close();
        return true;
    }
}
