package core.basesyntax;

import core.basesyntax.impl.CsvFileReaderImpl;
import core.basesyntax.impl.CsvFileWriterImpl;
import core.basesyntax.impl.DataParserImpl;
import core.basesyntax.impl.OperatorStrategyImpl;
import core.basesyntax.impl.ProductCalculatorImpl;
import core.basesyntax.impl.ReportCreatorImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.operators.BalanceOperator;
import core.basesyntax.operators.Operator;
import core.basesyntax.operators.PurchaseOperator;
import core.basesyntax.operators.ReturnOperator;
import core.basesyntax.operators.SupplyOperator;
import core.basesyntax.service.DataParser;
import core.basesyntax.service.FileReader;
import core.basesyntax.service.FileWriter;
import core.basesyntax.service.ProductCalculator;
import core.basesyntax.service.ReportCreator;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String inputFileName = "src/inputFile.scv";
    private static final String outputFileName = "src/reportFile.csv";
    private static final Map<FruitTransaction.Operation, Operator> map = Map.of(
            FruitTransaction.Operation.BALANCE, new BalanceOperator(),
            FruitTransaction.Operation.PURCHASE, new PurchaseOperator(),
            FruitTransaction.Operation.SUPPLY, new SupplyOperator(),
            FruitTransaction.Operation.RETURN, new ReturnOperator());

    public static void main(String[] args) {
        FileReader fileReader = new CsvFileReaderImpl();
        List<String> lines = fileReader.readFromFile(inputFileName);
        DataParser dataParser = new DataParserImpl();
        List<FruitTransaction> fruitTransactions = dataParser.parseDate(lines);
        ProductCalculator productCalculator
                = new ProductCalculatorImpl(new OperatorStrategyImpl(map));
        productCalculator.calculateProducts(fruitTransactions);
        ReportCreator reportCreator = new ReportCreatorImpl();
        List<String> report = reportCreator.createReport();
        FileWriter fileWriter = new CsvFileWriterImpl();
        fileWriter.writeInCsvFile(report, outputFileName);
    }
}
