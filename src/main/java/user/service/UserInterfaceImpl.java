package user.service;

import java.time.LocalDate;
import java.util.List;
import model.FruitRecord;
import parse.data.service.DataParse;
import reader.ReaderService;
import reader.ReaderServiceImpl;
import report.service.ReportCreator;
import report.service.ReportCreatorImpl;

public class UserInterfaceImpl implements UserInterface {
    private ReaderService readerService = new ReaderServiceImpl();
    private ReportCreator creator = new ReportCreatorImpl();
    private DataParse parse;

    public UserInterfaceImpl(DataParse parse) {
        this.parse = parse;
    }

    @Override
    public String getReport(String fromPath,String toPath, LocalDate date) {
        List<FruitRecord> records = readerService.read(fromPath);
        parse.parseAndAddToStorage(records);
        creator.createReport(toPath, date);
        return "Your report wait you in src/main/resources, name as: outputFile.csv";
    }
}
