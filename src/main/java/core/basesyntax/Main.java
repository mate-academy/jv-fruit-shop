package core.basesyntax;

import core.basesyntax.servises.AddToStorage;
import core.basesyntax.servises.impl.AddToStorageImpl;
import core.basesyntax.servises.impl.ReadFromFileImpl;
import core.basesyntax.servises.impl.WriteToFileImpl;
import core.basesyntax.storage.Storage;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        AddToStorage add = new AddToStorageImpl();
        ReadFromFileImpl read = new ReadFromFileImpl();
        WriteToFileImpl writeToFile = new WriteToFileImpl();
        List<String> strings = read.readFromFile(
                "src/main/java/core/basesyntax/resourses/input.csv");
        add.addToStorage(strings);
        writeToFile.addToFile(
                "src/main/java/core/basesyntax/resourses/output.csv", Storage.storage);
    }
}
