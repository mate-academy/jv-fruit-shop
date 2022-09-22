package core.basesyntax.service.report;

import core.basesyntax.service.filesoperation.ReadDataFromFile;
import core.basesyntax.service.filesoperation.ReadDataFromFileImpl;
import core.basesyntax.service.filesoperation.WriteDataToFile;
import core.basesyntax.service.filesoperation.WriteDataToFileImpl;

public class ReportFruitsServiceImpl implements ReportFruitsService {
    @Override
    public void report(String fileData, String fileReport) {
        ReadDataFromFile readDataFromFile = new ReadDataFromFileImpl();
        readDataFromFile.readData(fileData);
        WriteDataToFile writeDataToFile = new WriteDataToFileImpl();
        writeDataToFile.writeData(fileReport);
    }
}
