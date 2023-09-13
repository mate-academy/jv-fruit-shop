package core.basesyntax;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.Operation;
import core.basesyntax.service.ParserService;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.WriterService;
import core.basesyntax.serviceimpl.ParserServiceImpl;
import core.basesyntax.serviceimpl.ReaderServiceImpl;
import core.basesyntax.serviceimpl.WriterServiceImpl;
import core.basesyntax.strategy.ActionPicker;
import java.nio.file.Path;
import java.util.List;

public class FruitShop {
    public static final String SEPARATOR = ",";

    public static void main(String[] args) {
        ReaderService readerService = new ReaderServiceImpl();
        ParserService parserService = new ParserServiceImpl(SEPARATOR);
        ActionPicker actionPicker = new ActionPicker();
        WriterService writerService = new WriterServiceImpl();
        List<String> lines = readerService.readOperations(
                Path.of("src/main/java/core/basesyntax/input.csv")
        );
        List<Operation> operations = parserService.parseOperations(lines);
        for (Operation operation : operations) {
            int result = actionPicker.pickAction(operation);
            Storage.storage.put(new Fruit(operation.getNameOfObject()), result);
        }
        writerService.writeAll(Path.of("src/main/java/core/basesyntax/output.csv"));
    }
}
