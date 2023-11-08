package core.basesyntax;

import core.basesyntax.dao.OperationManager;
import core.basesyntax.dao.OperationManagerImpl;
import core.basesyntax.db.FruitDB;
import core.basesyntax.service.FileReader;
import core.basesyntax.service.FileReaderImpl;
import core.basesyntax.service.FileWriter;
import core.basesyntax.service.FileWriterImpl;

public class Main {
    private static final String READ_FILE_NAME = "file.csv";
    private static final String WRITE_FILE_NAME = "report_file.csv";

    public static void main(String[] args) {
        FruitDB fruitDB = new FruitDB();
        FileReader fileReader = new FileReaderImpl();
        OperationManager operationManager = new OperationManagerImpl();

        FileWriter fileWriter = new FileWriterImpl();

        operationManager
                .addInfoToDB(
                        fileReader.readFromFile(READ_FILE_NAME), fruitDB);
        fileWriter
                .writeToFile(fruitDB.getAllFruits(), WRITE_FILE_NAME);
    }
}
