package core.basesyntax.db;

public class StorageFactory {
    private static Storage instance;

    public static Storage getInstance() {
        if (instance == null) {
            instance = new Storage();
        }
        return instance;
    }
}
