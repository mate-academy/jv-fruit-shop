package reporter;

import dao.Columns;
import exceptions.InvalidDataException;
import java.io.File;
import java.nio.file.Path;
import java.util.List;
import operation.OperationTypes;
import reader.ReadFromFile;
import service.BalanceService;
import service.FruitBalanceService;
import validator.FruitShopDataValidator;
import validator.Validator;
import writer.WriteToFile;

public class FruitShopDataReporter implements Reporter<Path> {
    private static final Integer TYPE_INDEX = 0;

    @Override
    public String makeReportFrom(Path path) throws InvalidDataException {
        List<String> data = new ReadFromFile().read(path);
        Validator<List<String>> dataValidator = new FruitShopDataValidator();
        BalanceService service = new FruitBalanceService();
        String[] splittedLine;
        if (dataValidator.validate(data)) {
            for (String line : data) {
                splittedLine = line.split(",");
                if (Columns.inColumns(splittedLine[0])) {
                    continue;
                }
                OperationTypes.getSuitableOperationHandlerFor(splittedLine[0])
                        .changeBalance(service, splittedLine[1], Integer.parseInt(splittedLine[2]));
            }
            File file = new File("./src/main/resources/FruitShopReport.txt");
            return new WriteToFile().write(TYPE_INDEX,
                    file,
                    System.lineSeparator() + service.getAll());
        }
        throw new InvalidDataException("Invalid data");
    }
}
