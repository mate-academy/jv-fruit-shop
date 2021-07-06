package app;

import app.dto.Transaction;
import app.service.FileReader;
import app.service.FileWriter;
import app.service.FruitService;
import app.service.LineValidator;
import app.service.Parser;
import app.service.impl.FileReaderImpl;
import app.service.impl.FileWriterImpl;
import app.service.impl.FruitServiceImpl;
import app.service.impl.LineValidatorImpl;
import app.service.impl.MapCreatorImpl;
import app.service.impl.ParserImpl;
import app.strategy.OperationHandler;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String INPUT_FILE = "src\\main\\resources\\inputFile.cvs";
    private static final String OUTPUT_FILE = "src\\main\\resources\\outputFile.txt";

    public static void main(String[] args) {
        Map<String, OperationHandler> handlers = new MapCreatorImpl().createMap();

        FileReader fileReader = new FileReaderImpl();
        List<String> linesFromFile = fileReader.readFromFile(INPUT_FILE);

        LineValidator lineValidator = new LineValidatorImpl();
        Parser parser = new ParserImpl(lineValidator);

        linesFromFile.stream()
                .skip(1)
                .map(parser::parseLine)
                .forEach(t -> handlers.get(t.getOperation()).apply(t));

        FruitService fruitService = new FruitServiceImpl();
        String report = fruitService.getReport();

        FileWriter fileWriter = new FileWriterImpl();
        fileWriter.writeToFile(report, OUTPUT_FILE);
    }
}
