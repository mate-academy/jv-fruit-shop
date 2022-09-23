package core.basesyntax.service.report;

import core.basesyntax.service.filesoperation.FileReader;
import core.basesyntax.service.filesoperation.FileReaderImpl;
import core.basesyntax.service.filesoperation.FileWrite;
import core.basesyntax.service.filesoperation.FileWriteImpl;
import core.basesyntax.service.parsing.ParsingDataService;
import core.basesyntax.service.parsing.ParsingDataServiceImpl;
import java.util.List;

public class ReportFruitsServiceImpl implements ReportFruitsService {
    @Override
    public void report(String fileData, String fileReport) {
        FileReader fileReader = new FileReaderImpl();
        List<String> fruits = fileReader.read(fileData);
        ParsingDataService parsingDataService = new ParsingDataServiceImpl();
        parsingDataService.parsingFromList(fruits);
        FileWrite fileWrite = new FileWriteImpl();
        fileWrite.writer(fileReport);
    }
}
