package core.basesyntax.dao;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteBalanceImpl implements WriteBalance {
    @Override
    public void write(String balance) {
        File csvFile = new File("src/main/resources/balance.csv");
        try (FileWriter fileWriter = new FileWriter(csvFile)) {
            fileWriter.write(balance);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
