package core.basesyntax;

import core.basesyntax.Dao.FruitDao;
import core.basesyntax.Dao.FruitDaoImp;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.Parser;
import core.basesyntax.service.Reader;
import core.basesyntax.service.Writer;
import core.basesyntax.service.impl.ParseStringToFruitTransaction;
import core.basesyntax.service.impl.ReadFromCSV;
import core.basesyntax.service.impl.WriteToCSV;

import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        Reader read = new ReadFromCSV();
        List<String> read1 = read.read("src/main/resources/csvFile.csv");
        List<FruitTransaction> fruits = new ArrayList<>();
        FruitDao dataBase = new FruitDaoImp();
        Parser parser = new ParseStringToFruitTransaction();
        for (String fruit : read1) {
           fruits.add(parser.parse(fruit));
        }
        dataBase.add(fruits);
        for (FruitTransaction fruit : fruits) {
            switch (fruit.getOperation()){
                case SUPPLY:
                    dataBase.getStorage().put(fruit.getFruit(), dataBase.get(fruit.getFruit()) + fruit.getQuantity());
                    break;
                case BALANCE:
                    dataBase.getStorage().put(fruit.getFruit(), fruit.getQuantity());
                    break;
                case PURCHASE:
                    dataBase.getStorage().put(fruit.getFruit(), dataBase.get(fruit.getFruit()) - fruit.getQuantity());
                    break;
                case RETURN:
                    dataBase.getStorage().put(fruit.getFruit(), dataBase.get(fruit.getFruit()) + fruit.getQuantity());
                    break;
            }
        }
        Writer wr = new WriteToCSV();
        wr.write(dataBase.getStorage());
    }

}
