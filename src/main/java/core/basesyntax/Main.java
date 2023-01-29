package core.basesyntax;

import core.basesyntax.service.CalculateService;
import core.basesyntax.service.impl.CalculateServiceImpl;
import core.basesyntax.service.impl.ReaderServiceImpl;
import core.basesyntax.service.impl.WriteServiceImpl;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ReaderServiceImpl readerService = new ReaderServiceImpl();
        WriteServiceImpl writeService = new WriteServiceImpl();
        CalculateService calculateService = new CalculateServiceImpl();
        List<String> dateFromFile = readerService.readFromFile();
        calculateService.calculateQuantity(dateFromFile);
        writeService.writeToFile();
    }
}
