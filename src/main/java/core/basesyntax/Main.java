package core.basesyntax;

import core.basesyntax.db.FruitShopDao;
import core.basesyntax.db.FruitShopDaoImpl;
import core.basesyntax.impl.AmountFromFileImpl;
import core.basesyntax.impl.ConvertingFileToFruitTransactionImpl;
import core.basesyntax.impl.FruitsFromFileImpl;
import core.basesyntax.impl.ReadingCsvFileImpl;
import core.basesyntax.impl.WritingToNewFileImpl;
import core.basesyntax.service.AmountFromFile;
import core.basesyntax.service.ConvertingFileToFruitTransaction;
import core.basesyntax.service.FruitTransaction;
import core.basesyntax.service.FruitsFromFile;
import core.basesyntax.service.ReadingCsvFile;
import core.basesyntax.service.WritingToNewFile;
import java.util.List;

public class Main {
    // HINT: In the `public static void main(String[] args)`
    // it is better to create instances of your classes,
    // and call their methods,
    // but do not write any business logic in the `main` method!
    public static void main(String[] args) {
        FruitShopDao fruitShopDao = new FruitShopDaoImpl();
        ReadingCsvFile readClass = new ReadingCsvFileImpl();
        ConvertingFileToFruitTransaction convertClass = new ConvertingFileToFruitTransactionImpl();
        FruitsFromFile fruitClass = new FruitsFromFileImpl(fruitShopDao);
        AmountFromFile amountClass = new AmountFromFileImpl(fruitShopDao);
        WritingToNewFile writeClass = new WritingToNewFileImpl(fruitShopDao);
        //---------------------------------------------------------
        String fromFileName = "xyz.csv";
        String toFileName = "abc.csv";

        List<String> reading = readClass.reading(fromFileName);
        List<FruitTransaction> converted = convertClass.convert(reading);
        List<String> fruits = fruitClass.getFruits(converted);
        List<Integer> amounts = amountClass.getAmountInShop(fruits, converted);
        writeClass.writing(toFileName);
    }
}
