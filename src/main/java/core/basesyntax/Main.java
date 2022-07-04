package core.basesyntax;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReadFromFile;
import core.basesyntax.service.ShiftReportService;
import core.basesyntax.service.TransactionProcessing;
import core.basesyntax.service.WriteToFile;
import core.basesyntax.service.impl.ReadFromFileImpl;
import core.basesyntax.service.impl.ShiftReportServiceImpl;
import core.basesyntax.service.impl.TransactionProcessingImpl;
import core.basesyntax.service.impl.WriteToFileImpl;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ReadFromFile readFromFile = new ReadFromFileImpl();
        List<String> listOfTransaction = readFromFile.readFromFile();
        TransactionProcessing transactionProcessing = new TransactionProcessingImpl();
        transactionProcessing.transactionProcessing(listOfTransaction);
        ShiftReportService shiftReportService = new ShiftReportServiceImpl();
        List<String> reportList = shiftReportService.reportMaker(Storage.getFruitStore());
        WriteToFile writeToFile = new WriteToFileImpl();
        writeToFile.writeToFile(reportList);
    }
}
