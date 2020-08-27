package core.basesyntax;

import core.basesyntax.service.ActionController;
import core.basesyntax.service.FileReadService;
import core.basesyntax.service.FileWriteService;
import core.basesyntax.service.impl.FileReadServiceImpl;
import core.basesyntax.service.impl.FileWriteServiceImpl;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        FileReadService fileReadService = new FileReadServiceImpl();
        List<Transaction> data = fileReadService.readFile(args[0]);

        ActionController actionController = new ActionController();
        for (Transaction item : data) {
            actionController.distributeActions(item);
        }

        FileWriteService fileWriteService = new FileWriteServiceImpl();
        fileWriteService.writeFile(Store.fruits, args[1]);
    }
}
