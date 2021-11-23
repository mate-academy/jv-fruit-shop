package core.basesyntax;

import core.basesyntax.dao.FruitStorageDaoImpl;
import core.basesyntax.model.TransactionDto;
import core.basesyntax.service.Parser;
import core.basesyntax.service.ParserImpl;
import core.basesyntax.service.ValidatorImpl;
import core.basesyntax.service.file.input.Reader;
import core.basesyntax.service.file.input.ReaderImpl;
import core.basesyntax.service.file.output.WriterImpl;
import core.basesyntax.service.operation.OperationHandler;
import core.basesyntax.service.operation.OperationHandlerMap;
import core.basesyntax.service.report.ReportServiceImpl;
import core.basesyntax.strategy.OperationStrategyImpl;
import java.util.List;
import java.util.Map;

public class Main {
    public static final String PATH_INPUT = "src/main/resources/report_input.csv";
    public static final String PATH_OUTPUT = "src/main/resources/report_output.csv";

    public static void main(String[] args) {
        Reader reader = new ReaderImpl();
        List<String> lines = reader.read(PATH_INPUT);

        Parser<TransactionDto> parser = new ParserImpl(new ValidatorImpl());

        List<TransactionDto> transactions = parser.parseLine(lines);

        Map<String, OperationHandler> handlerMap =
                new OperationHandlerMap(new FruitStorageDaoImpl()).map();

        new OperationStrategyImpl(handlerMap).get(transactions);

        String report = new ReportServiceImpl().formReport();
        new WriterImpl().write(report, PATH_OUTPUT);
    }
}
