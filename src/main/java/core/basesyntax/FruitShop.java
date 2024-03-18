package core.basesyntax;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.FruitServiceImpl;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class FruitShop {
    public static void main(String[] args) throws IOException {
        FruitDao fruitDao = new FruitDaoImpl();
        FruitService fruitService = new FruitServiceImpl();

        File fileToRead = new File("read.csv");
        File fileToWrite = new File("write.csv");

        String data = fruitDao.readFromFile(fileToRead);

        List<String> dataToFile = fruitService.generateReport(data);

        fruitDao.writeToFile(fileToWrite, dataToFile);
    }
}
