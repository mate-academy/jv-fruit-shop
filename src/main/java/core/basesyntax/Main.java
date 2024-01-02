package core.basesyntax;

import static core.basesyntax.services.work_with_files.impl.DbDataPutterImpl.balance;
import static core.basesyntax.services.work_with_files.impl.DbDataPutterImpl.handleOperations;
import static core.basesyntax.services.work_with_files.impl.DbDataPutterImpl.otherOperations;
import static core.basesyntax.services.work_with_files.impl.DbDataPutterImpl.putDataToDb;

import core.basesyntax.db.Storage;
import core.basesyntax.services.work_with_files.DbDataPutter;
import core.basesyntax.services.work_with_files.DataReaderFromFile;
import core.basesyntax.services.work_with_files.FileWriter;
import core.basesyntax.services.work_with_files.ReportGenerator;
import core.basesyntax.services.work_with_files.impl.DbDataPutterImpl;
import core.basesyntax.services.work_with_files.impl.DataReaderFromFileCSVImpl;
import core.basesyntax.services.work_with_files.impl.FileWriterImpl;
import core.basesyntax.services.work_with_files.impl.ReportGeneratorImpl;

public class Main {
  public static void main(String[] args) {
    DataReaderFromFile dataReaderFromFile = new DataReaderFromFileCSVImpl();
    DbDataPutter dbDataPutter = new DbDataPutterImpl();
    ReportGenerator reportGenerator = new ReportGeneratorImpl();
    FileWriter fileWriter = new FileWriterImpl();
    dbDataPutter.divideData(dataReaderFromFile.readFromFileAndHoldData("src/main/resources/SampleSourceCSV.csv"));
    putDataToDb(balance);
    handleOperations(otherOperations);
    fileWriter.writeToFile(reportGenerator.generateReport(Storage.fruitsTypeAndAmount));
  }
}
