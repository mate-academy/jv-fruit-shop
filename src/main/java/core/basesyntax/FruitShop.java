package core.basesyntax;

import java.util.List;

/**
 * Feel free to remove this class and create your own.
 */
public class FruitShop {
    private static CreateNewFile newFile = new CreateNewFile();
    private static ReadFromFile readingFromFileOperation = new ReadFromFile();
    private static OperationWithFruits operation = new OperationWithFruits();
    private static FruitTypes range = new FruitTypes();

    public static void main(String[] args) throws Exception {
        String file1 = "D:\\MateHW\\jv-fruit-shop\\txt7";
        List<String> fruitsFromFile = readingFromFileOperation.readFromFile(file1);
        System.out.println((operation.operationWithFruits(fruitsFromFile)));
    }
}
