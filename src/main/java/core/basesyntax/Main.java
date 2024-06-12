package core.basesyntax;

import core.basesyntax.db.FruitShopDao;
import core.basesyntax.db.FruitShopDaoImpl;
import core.basesyntax.service.impl.AmountOfFruitsFromFileImpl;
import core.basesyntax.service.impl.FileToTransactionConverterImpl;
import core.basesyntax.service.impl.FruitsFromFileImpl;
import core.basesyntax.service.impl.CsvFileReaderServiceImpl;
import core.basesyntax.service.impl.FruitStorageWriterImpl;
import core.basesyntax.service.AmountOfFruitsFromFile;
import core.basesyntax.service.FileToTransactionConverter;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitsFromFile;
import core.basesyntax.service.CsvFileReaderService;
import core.basesyntax.service.FruitStorageWriter;
import java.util.List;

public class Main {
    private static final String fromFileName = "xyz.csv";
    private static final String toFileName = "abc.csv";
    private static FruitShopDao fruitShopDao = new FruitShopDaoImpl();
    private static CsvFileReaderService readClass = new CsvFileReaderServiceImpl();
    private static FileToTransactionConverter convertClass = new FileToTransactionConverterImpl();
    private static FruitsFromFile fruitClass = new FruitsFromFileImpl();
    private static AmountOfFruitsFromFile amountClass = new AmountOfFruitsFromFileImpl();
    private static FruitStorageWriter writeClass = new FruitStorageWriterImpl(fruitShopDao);

    public static void main(String[] args) {

        List<String> reading = readClass.readFromFile(fromFileName);
        List<FruitTransaction> converted = convertClass.convert(reading);
        List<String> fruits = fruitClass.getFruitsFromFile(converted);
        List<Integer> amounts = amountClass.getAmountOfFruitsFromFile(fruits, converted);
        for (int i = 0; i < fruits.size(); i++) {
            fruitShopDao.addFruitAndQuantity(fruits.get(i), amounts.get(i));
        }
        writeClass.writeReportToFile(toFileName);
    }
}
