package core.basesyntax;

import core.basesyntax.service.DataReader;
import core.basesyntax.service.DataWriter;
import core.basesyntax.service.LineParser;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.impl.DataReaderImpl;
import core.basesyntax.service.impl.DataWriterImpl;
import core.basesyntax.service.impl.LineParserImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.strategy.FruitTransactionStrategy;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        DataReader<String> dataReader = new DataReaderImpl();
        String fromFile = "src/main/resources/inputData.csv";
        List<String> inputData = dataReader.dataFromFile(fromFile);
        LineParser lineParser = new LineParserImpl();
        List<FruitTransaction> fruitTransactions = lineParser.createListOfTransactions(inputData);
        FruitTransactionStrategy transactionStrategy = new FruitTransactionStrategy();
        transactionStrategy.executeTransaction(fruitTransactions);
        ReportService reportService = new ReportServiceImpl();
        String data = reportService.makeReport();
        DataWriter dataWriter = new DataWriterImpl();
        String toFile = "src/main/resources/report.csv";
        dataWriter.writeData(data, toFile);
    }
}
