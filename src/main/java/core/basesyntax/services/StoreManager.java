package core.basesyntax.services;

import core.basesyntax.items.Storage;

public class StoreManager {
    private Storage storage;
    private TextReader reader;
    private DataAggregator aggregator;
    private TextPrinter printer;

    public StoreManager() {
        storage = new Storage();
        reader = new TextReader();
        aggregator = new DataAggregator();
        printer = new TextPrinter();
    }

    public void calculateRemainedProduct(String fileFrom, String fileTo) {
        printer.print(aggregator.aggregate(reader.read(fileFrom), storage).toString(), fileTo);
    }
}
