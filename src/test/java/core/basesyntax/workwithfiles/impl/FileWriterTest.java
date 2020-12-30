package core.basesyntax.workwithfiles.impl;

import core.basesyntax.fruitoperation.Operation;
import core.basesyntax.fruitoperation.OperationBalance;
import core.basesyntax.fruitoperation.OperationPurchase;
import core.basesyntax.fruitoperation.OperationReturn;
import core.basesyntax.fruitoperation.OperationSupply;
import core.basesyntax.fruitoperation.Operations;
import core.basesyntax.fruitoperation.strategy.OperationStrategy;
import core.basesyntax.fruitoperation.strategy.OperationStrategyImpl;
import core.basesyntax.report.ReportFormatter;
import core.basesyntax.report.ReportFormatterImpl;
import core.basesyntax.workwithfiles.DataWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FileWriterTest {
    private static ReportFormatter reportFormatter;

    @Before
    public void setUp() throws Exception {
        Map<Operations, Operation> operationMap = new HashMap<>();
        operationMap.put(Operations.B, new OperationBalance());
        operationMap.put(Operations.P, new OperationPurchase());
        operationMap.put(Operations.R, new OperationReturn());
        operationMap.put(Operations.S, new OperationSupply());
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationMap);
        reportFormatter = new ReportFormatterImpl(operationStrategy);
    }

    @Test
    public void testReportFormattingInFile_Ok() {
        DataWriter dataWriter = new FileWriter();
        dataWriter.writeToFile(reportFormatter.createReport(
                new FileReader("src/main/resources/test2_correct.csv")),
                "src/main/resources/ApplesAndBananas");
        String actual;
        try {
            actual = Files.readString(Path.of("src/main/resources/ApplesAndBananas"));
        } catch (IOException e) {
            throw new RuntimeException("Can't correctly read data from file ApplesAndBananas", e);
        }
        String expected = "fruit,quantity" + System.lineSeparator()
                + "apple,90" + System.lineSeparator() + "banana,152";
        Assert.assertEquals(expected, actual);
    }
}
