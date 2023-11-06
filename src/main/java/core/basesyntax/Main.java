package core.basesyntax;

import core.basesyntax.dao.ListToMapImpl;
import core.basesyntax.file.MapWriteToFileImpl;
import core.basesyntax.file.ReadFromFileImpl;

public class Main {
    private static final String READ_FILE_NAME = "file.csv";
    private static final String WRITE_FILE_NAME = "report_file.csv";

    public static void main(String[] args) {
        ReadFromFileImpl fileReader = new ReadFromFileImpl();
        ListToMapImpl stringToDB = new ListToMapImpl();
        MapWriteToFileImpl writeToFile = new MapWriteToFileImpl();

        writeToFile.mapWriteToFile(stringToDB.listToMap(fileReader.readFromFile(READ_FILE_NAME)),
                WRITE_FILE_NAME);

    }
}
