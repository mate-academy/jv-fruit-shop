package core.basesyntax;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.files.FileReaderImpl;
import core.basesyntax.files.FileWriterImpl;
import core.basesyntax.service.FruitTransactionImpl;
import core.basesyntax.service.ReportServiceImpl;
import core.basesyntax.strategy.MapStrategy;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        String fromFileName = "load.csv";
        String toFileName = "output.csv";
        FruitDao fruitDao = new FruitDaoImpl();
        List<String> linesFromFile = new FileReaderImpl().readFromFile(fromFileName);
        MapStrategy mapStrategy = new MapStrategy();
        new FruitTransactionImpl()
                .processTransaction(linesFromFile, mapStrategy.mapStrategy(fruitDao));
        new FileWriterImpl().writeToFile(toFileName, new ReportServiceImpl(fruitDao).getReport());
    }
}
