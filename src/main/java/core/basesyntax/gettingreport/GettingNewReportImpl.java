package core.basesyntax.gettingreport;

import core.basesyntax.createreport.CreateReport;
import core.basesyntax.stoage.Storage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class GettingNewReportImpl implements GettingNewReport {
    @Override
    public void getReport() {
        CreateReport report = new CreateReport();
        File file = new File("dailyReport.csv");
        try {
            file.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException("Wrong file " + e);
        }
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file,true))) {
            bufferedWriter.write((report.createReport(Storage.storage)));
            bufferedWriter.close();
        } catch (IOException e) {
            throw new RuntimeException("Wrong file" + e);
        }
    }
}
