package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataConvertor;
import core.basesyntax.service.FileReaderService;
import core.basesyntax.service.FileWriterService;
import core.basesyntax.service.FruitDataCounter;
import core.basesyntax.service.impl.DataConvertorImpl;
import core.basesyntax.service.impl.FileReaderServiceImpl;
import core.basesyntax.service.impl.FileWriterServiceImpl;
import core.basesyntax.service.impl.FruitDataCounterImpl;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        final String inputFile = "input.csv";
        final String outputFile = "output.csv";

        FileReaderService fileReaderLines = new FileReaderServiceImpl();
        FruitDataCounter fruitDataCounter = new FruitDataCounterImpl();
        DataConvertor dataConvertor = new DataConvertorImpl();

        List<String> lines = fileReaderLines.lines(inputFile);
        List<FruitTransaction> fruitTransactions = dataConvertor.dataConvert(lines);
        List<String> fruits = fruitDataCounter.fruits(fruitTransactions);
        FileWriterService fileWriter = new FileWriterServiceImpl();
        fileWriter.fileWriterCsv(fruits, outputFile);
    }
}

