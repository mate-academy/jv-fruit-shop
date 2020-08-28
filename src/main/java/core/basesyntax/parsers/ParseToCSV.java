package core.basesyntax.parsers;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ParseToCSV {

    public boolean writeToFile(Transaction transaction, String FilePath) {
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(FilePath,true));
            writer.write(transaction.toString());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }
}
