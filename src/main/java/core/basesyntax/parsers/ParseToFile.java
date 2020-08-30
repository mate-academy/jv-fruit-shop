package core.basesyntax.parsers;

import core.basesyntax.transactions.Transaction;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ParseToFile {

    public void writeToFile(Transaction transaction, String filePath) {
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(filePath,true));
            writer.write(transaction.toString());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
