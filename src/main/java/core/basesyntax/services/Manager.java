package core.basesyntax.services;

import core.basesyntax.items.Storage;

public class Manager {
    private Storage storage;
    private TextReader reader;
    private DataAggregator aggregator;
    private TextPrinter printer;

    public Manager() {
        storage = new Storage();
        reader = new TextReader();
        aggregator = new DataAggregator();
        printer = new TextPrinter();
    }

    public void manage(String fileFrom, String fileTo) {
        printer.print(aggregator.aggregate(reader.read(fileFrom), storage).toString(), fileTo);
    }
}
