package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataProcess;
import core.basesyntax.service.impl.CsvReaderServiceImpl;
import core.basesyntax.service.impl.CsvWriterServiceImpl;
import core.basesyntax.service.impl.DataProcessImpl;
import core.basesyntax.service.impl.GenerateReportImpl;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> dataFromFile = new CsvReaderServiceImpl().readFile();

        DataProcess dataProcess = new DataProcessImpl();

        List<FruitTransaction> fruitTransactions = dataProcess.dataProcessing(dataFromFile);

        String report = new GenerateReportImpl().reportGenerater(fruitTransactions);

        new CsvWriterServiceImpl().writeToFile(report);


    }
}
