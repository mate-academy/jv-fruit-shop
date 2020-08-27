package core.basesyntax;

import java.util.List;

/**
 * Feel free to remove this class and create your own.
 */
public class FruitShop {
    private static FileWritter newFile = new FileWritter();
    private static ReadFromFile readingFromFileOperation = new ReadFromFile();
    private static OperationWithFruits operation = new OperationWithFruits();

    public static void main(String[] args) throws Exception {
        String file1 = "txt8";
        List<String> fruitsFromFile = readingFromFileOperation.readFromFile(file1);
        newFile.writeNewFile(operation.operationWithFruits(fruitsFromFile));
    }
}
