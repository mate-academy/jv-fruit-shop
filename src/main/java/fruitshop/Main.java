package fruitshop;

import fruitshop.model.DataLine;
import fruitshop.service.FruitService;
import fruitshop.service.Parser;
import fruitshop.service.Reader;
import fruitshop.service.Report;
import fruitshop.service.Writer;
import fruitshop.service.serviceimpl.FileReaderImpl;
import fruitshop.service.serviceimpl.FileWriterImpl;
import fruitshop.service.serviceimpl.FruitServiceImpl;
import fruitshop.service.serviceimpl.ParserImpl;
import fruitshop.service.serviceimpl.ReportImpl;
import java.util.List;

public class Main {
    private static final String fromFile = "src/main/resources/fruitdata.csv";
    private static final String toFile = "src/main/resources/result.csv";

    public static void main(String[] args) {
        Reader reader = new FileReaderImpl();
        Parser parser = new ParserImpl();
        List<String> fromFileData = reader.readDataFromFile(fromFile);
        List<DataLine> fruitData = parser.parseStringToDataObject(fromFileData);
        FruitService fruitService = new FruitServiceImpl(fruitData);
        fruitService.processFruits();
        Report reportInterface = new ReportImpl();
        String report = reportInterface.createReport();
        Writer writer = new FileWriterImpl();
        writer.writeDataToTheFile(toFile, report);
    }
}
