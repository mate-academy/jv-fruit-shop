package core.basesyntax;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        FruitDao fruitDao = new FruitDao();
        System.out.println("Reading file *.csv: " + fruitDao.readCSV());
        System.out.println("Writing balance: " + fruitDao.fruitBalance.writeBalance());
    }
}
