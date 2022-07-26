package core.basesyntax;

import core.basesyntax.dao.FruitsDao;
import core.basesyntax.operations.OperationHandler;
import core.basesyntax.operations.impl.Balance;
import core.basesyntax.operations.impl.Purchase;
import core.basesyntax.operations.impl.Return;
import core.basesyntax.operations.impl.Supply;
import core.basesyntax.service.CsvFileReader;
import core.basesyntax.service.DataProcessing;
import core.basesyntax.service.ReportCreating;
import core.basesyntax.service.impl.CsvFileReaderImpl;
import core.basesyntax.service.impl.DataProcessingImpl;
import core.basesyntax.service.impl.FileReportCreating;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, OperationHandler> operations = new HashMap<>();
        operations.put("b", new Balance());
        operations.put("s", new Supply());
        operations.put("r", new Return());
        operations.put("p", new Purchase());
        List<String> readData = new CsvFileReaderImpl().readData("src/main/resources/file.csv");
        DataProcessing dataProcessing = new DataProcessingImpl(operations);
        FruitsDao fruitsDao = dataProcessing.processData(readData);
        ReportCreating reportCreating = new FileReportCreating();
        reportCreating.createReport(fruitsDao, dataProcessing.getColumnsNamesLine());
    }
}
