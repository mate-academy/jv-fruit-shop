package core.basesyntax;

import core.basesyntax.db.Storage;
import core.basesyntax.service.CreateTheReport;
import core.basesyntax.service.ProcessDataFromOrder;
import core.basesyntax.service.ReadFromFile;
import core.basesyntax.service.WriteTheReportToDataBase;
import core.basesyntax.service.impl.CreateTheReportImpl;
import core.basesyntax.service.impl.ProcessDataFromOrderImpl;
import core.basesyntax.service.impl.ReadFromFileImpl;
import core.basesyntax.service.impl.WriteTheReportToDataBaseImpl;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ReadFromFile readFromFile = new ReadFromFileImpl();
        ProcessDataFromOrder processDataFromOrder = new ProcessDataFromOrderImpl();
        CreateTheReport createTheReport = new CreateTheReportImpl();
        WriteTheReportToDataBase writeTheReportToDB = new WriteTheReportToDataBaseImpl();

        final List<String> read = readFromFile.read();
        final List<String[]> split = processDataFromOrder.split(read);
        createTheReport.add(split);
        writeTheReportToDB.write(Storage.fruits);
    }
}
