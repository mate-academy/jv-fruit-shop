package core.basesyntax;

import model.dto.FruitRecordDto;
import service.ParserService;
import service.ReaderService;
import service.ReportService;
import service.impl.ParserServiceImpl;
import service.impl.ReaderServiceImpl;
import service.impl.ReportServiceImpl;

import java.util.List;

/**
 * Feel free to remove this class and create your own.
 */
public class HelloWorld {
    public static void main(String[] args) {
        String path = "src/main/resources/input.csv";

        ReaderService readerService = new ReaderServiceImpl();
        List<String> stringsFromFile = readerService.readFromFile(path);

        ParserService parserService = new ParserServiceImpl();
        List<FruitRecordDto> dtos = parserService.parseToDto(stringsFromFile);

        ReportService reportService = new ReportServiceImpl();
        reportService.makeStockReportToCSVFile(dtos);
    }
}
