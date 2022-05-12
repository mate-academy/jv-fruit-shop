package core.basesyntax;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.StorageDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitShopService;
import core.basesyntax.service.Operation;
import core.basesyntax.service.Parser;
import core.basesyntax.service.Reader;
import core.basesyntax.service.ReportCreator;
import core.basesyntax.service.impl.FruitShopServiceImpl;
import core.basesyntax.service.impl.OperationImpl;
import core.basesyntax.service.impl.ParserImpl;
import core.basesyntax.service.impl.ReaderImpl;
import core.basesyntax.service.impl.ReportCreatorImpl;
import core.basesyntax.service.impl.WriterImpl;
import java.util.List;

public class Main {
    private static final String FROM_FILE = "src/main/resources/input.csv";
    private static final String TO_FILE = "src/main/resources/report.csv";

    public static void main(String[] args) {
        Reader readService = new ReaderImpl();
        List<String> readFile = readService.read(FROM_FILE);
        Parser parser = new ParserImpl();
        List<FruitTransaction> infoFromFile = parser.getInfo(readFile);
        StorageDao storageDao = new StorageDaoImpl();
        FruitShopService fruitShopService = new FruitShopServiceImpl();
        Operation operation = new OperationImpl(fruitShopService);
        operation.calculate(infoFromFile);
        ReportCreator reportCreator = new ReportCreatorImpl(storageDao);
        String reportedInformation = reportCreator.report();
        new WriterImpl().write(reportedInformation, TO_FILE);
    }
}
