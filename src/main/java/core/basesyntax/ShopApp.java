package core.basesyntax;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.impl.FruitDaoImpl;
import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.utils.FileReader;
import core.basesyntax.utils.FileWriter;
import core.basesyntax.utils.ParserData;
import core.basesyntax.utils.impl.FileReaderImpl;
import core.basesyntax.utils.impl.FileWriterImpl;
import core.basesyntax.utils.impl.ParserDataImpl;

import java.util.List;
import java.util.Map;

public class ShopApp {
    private static final String FILE_NAME = "src/main/resources/inputFile.csv";
    private static final String REPORT_NAME = "src/main/resources/report.csv";

    public static void main(String[] args) {
        FileReader read = new FileReaderImpl();
        List<String> listWithFile = read.readWithFile(FILE_NAME);

        //parse
        FruitDao fruitDaoImp = new FruitDaoImpl();
        ParserData parseData = new ParserDataImpl();
        Map<String, Integer> stringIntegerMap = parseData.parsedWithFile(listWithFile);

        Storage.fruits.entrySet().stream().forEach(System.out::println);

        //add test
        Fruit fruit = new Fruit("banana", 150);
        Fruit fruit2 = new Fruit("kivi", 125);
        Fruit fruit1 = new Fruit("banana", 200);
        fruitDaoImp.create(fruit);
        fruitDaoImp.create(fruit2);

        fruitDaoImp.update(fruit1);


        //input storage
        Storage.fruits.entrySet().stream().forEach(System.out::println);
//        fruitDaoImp.delete(fruit2);
//        Storage.DB_MAP.entrySet().stream().forEach(System.out::println);

        // report formater

        //save
        FileWriter write = new FileWriterImpl();
        write.writeToFile(REPORT_NAME, listWithFile);
    }
}
