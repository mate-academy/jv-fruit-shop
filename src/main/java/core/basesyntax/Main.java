package core.basesyntax;

import core.basesyntax.db.DataBase;
import core.basesyntax.db.DataBaseImpl;
import core.basesyntax.functional.Function;
import core.basesyntax.functional.FunctionImpl;
import core.basesyntax.service.CsvFileReader;
import core.basesyntax.service.CsvFileWriter;
import core.basesyntax.service.ProcessData;
import core.basesyntax.service.impl.CsvFileReaderImpl;
import core.basesyntax.service.impl.CsvFileWriterImpl;
import core.basesyntax.service.impl.ProcessDataImpl;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        CsvFileReader csvFileReader = new CsvFileReaderImpl();
        String dataPath = "src/main/resources/data.csv";
        Path pathFrom = Path.of(dataPath);
        Function function = new FunctionImpl();
        DataBase dataBase = DataBaseImpl.getDataBase();
        ProcessData processData = new ProcessDataImpl();
        CsvFileWriter csvFileWriter = new CsvFileWriterImpl();
        String reportPath = "src/main/resources/report.csv";
        Path pathTo = Path.of(reportPath);
        List<String[]> listOfData = csvFileReader.readDataFromFile(pathFrom);
        function.extractBalance(listOfData);
        List<String[]> dataWithoutBalance = dataBase.getListOfFruitStorage();
        processData.processData(dataWithoutBalance);
        Map<String, String> processedBalance = dataBase.getMapOfBalanceStorage();
        String report = function.fomReport(processedBalance);
        csvFileWriter.writeDataToFile(pathTo, report);
    }
}
