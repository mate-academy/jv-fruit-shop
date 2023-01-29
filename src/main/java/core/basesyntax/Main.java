package core.basesyntax;

import core.basesyntax.service.Calculate;
import core.basesyntax.service.Impl.CalculateImpl;
import core.basesyntax.service.Impl.ReaderServiceImpl;
import core.basesyntax.service.Impl.WriteServiceImpl;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ReaderServiceImpl readerService = new ReaderServiceImpl();
        WriteServiceImpl writeService = new WriteServiceImpl();
        Calculate calculate = new CalculateImpl();
        List<String> dateFromFile = readerService.readFromFile();
        calculate.calculateQuantity(dateFromFile);
        writeService.writeToFile();
    }
}
