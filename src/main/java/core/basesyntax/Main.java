package core.basesyntax;

import core.basesyntax.dao.FruitDataReader;
import core.basesyntax.dao.FruitDataWriter;
import core.basesyntax.dao.FruitFileReader;
import core.basesyntax.dao.FruitFileWriter;
import core.basesyntax.db.FruitStorage;

public class Main {
    private static final String READ_FILE_NAME = "test.cvs";
    private static final String WRITE_FILE_NAME = "result.cvs";

    public static void main(String[] args) {
        FruitDataReader fruitReader = new FruitFileReader(READ_FILE_NAME);
        fruitReader.read();
        FruitDataWriter fruitWriter = new FruitFileWriter(FruitStorage.fruits, WRITE_FILE_NAME);
        fruitWriter.write();
        System.out.println("Here is one more successfull day in our fruit storage!");
    }
}
