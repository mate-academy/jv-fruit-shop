package core.basesyntax;

import core.basesyntax.db.Storage;
import core.basesyntax.model.StorageTransaction;
import core.basesyntax.service.CalculateService;
import core.basesyntax.service.DataParseService;
import core.basesyntax.service.FileReadService;
import core.basesyntax.service.ReportMakerService;
import core.basesyntax.service.WriteDataToFileService;
import core.basesyntax.service.impl.CalculateServiceImpl;
import core.basesyntax.service.impl.DataParseServiceImpl;
import core.basesyntax.service.impl.FileReadServiceImpl;
import core.basesyntax.service.impl.ReportMakerServiceImpl;
import core.basesyntax.service.impl.WriteDataToFileServiceImpl;
import java.util.List;

public class Main {
    private static final String FROM_FILE_PATH =
            "src//main//java//core//basesyntax//resources//beforeReport.csv";
    private static final String TO_FILE_PATH =
            "src//main//java//core//basesyntax//resources//report.csv";

    public static void main(String[] args) {
        FileReadService fileReadService = new FileReadServiceImpl();
        DataParseService dataParseService = new DataParseServiceImpl();
        CalculateService calculateService = new CalculateServiceImpl();
        ReportMakerService reportMakerService = new ReportMakerServiceImpl();
        WriteDataToFileService writeDataToFileService = new WriteDataToFileServiceImpl();

        List<String> readData = fileReadService.readDataFromFile(FROM_FILE_PATH);
        List<StorageTransaction> parsedData = dataParseService.getParsedData(readData);
        calculateService.calculate(parsedData);
        String report = reportMakerService.makeReport(Storage.getStorage());
        writeDataToFileService.writeReport(report, TO_FILE_PATH);
    }
}
