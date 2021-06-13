package core.basesyntax.service;

import core.basesyntax.exeptions.ValidationException;
import core.basesyntax.model.FruitDto;
import java.util.List;

public class Main {
    public static final String FILE_NAME = "database.csv";
    private static final String REPORT_CSV = "report.csv";

    public static void main(String[] args) throws ValidationException {

        FileReader fileReader = new FileReader();
        List<String> strings = fileReader.readDataFromFile(FILE_NAME);

        FruitParser fruitParser = new FruitParser();
        List<FruitDto> fruitDtoList = fruitParser.parserFruit(strings);

        TypeStrategy typeStrategy = new TypeStrategyImpl();
        fruitDtoList.forEach(f -> typeStrategy.getTypeHandler(f).handle(f));
        ReportFile reportFile = new ReportFile();
        reportFile.madeReportFile(REPORT_CSV);
    }
}
