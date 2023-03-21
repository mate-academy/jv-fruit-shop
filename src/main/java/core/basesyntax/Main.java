package core.basesyntax;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.MyFileReader;
import core.basesyntax.service.MyFileReaderImpl;

public class Main {
    public static void main(String[] args) {
        MyFileReader myFileReader = new MyFileReaderImpl();
        myFileReader.readFromFile("src/main/resources/input.csv");

        for (FruitTransaction fruitTransaction : Storage.dataFromFile) {
            System.out.println(fruitTransaction);
        }
    }
}
