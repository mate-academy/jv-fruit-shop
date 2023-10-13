package core.basesyntax;

import core.basesyntax.fruittransact.FruitTransactionImpl;
import core.basesyntax.workwithfile.WorkWithFile;
import core.basesyntax.workwithfile.WorkWithFileImpl;
import java.io.File;

public class Main {
    private static final String[] FILE_NAMES =
            new String[]{"input1.csv", "input2.csv", "input3.csv"};

    public static void main(String[] args) {
        WorkWithFile workWithFile = new WorkWithFileImpl();
        FruitTransactionImpl fruitTransaction = new FruitTransactionImpl();
        for (String fileName : FILE_NAMES) {
            fruitTransaction.transactAll(workWithFile.readFromFile(new File(fileName)));
            System.out.println(workWithFile.generateReport() + System.lineSeparator());
        }
    }
}
