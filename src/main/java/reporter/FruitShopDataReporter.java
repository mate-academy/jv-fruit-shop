package reporter;

import dao.Columns;
import dao.FruitsDao;
import dao.GenericDao;
import exceptions.InvalidDataException;
import java.io.File;
import java.nio.file.Path;
import java.util.List;
import reader.FileReaderImpl;
import service.ProcessFruitsMapToString;
import strategy.OperationTypes;
import validator.FruitShopDataValidator;
import validator.Validator;
import writer.WriterToFileImpl;

public class FruitShopDataReporter implements Reporter<Path> {
    private static final Integer TYPE_INDEX = 0;
    private static GenericDao fruitBalanceService;

    @Override
    public void makeReportFrom(Path path) {
        List<String> data = new FileReaderImpl().read(path);
        Validator<List<String>> dataValidator = new FruitShopDataValidator();
        fruitBalanceService = new FruitsDao();
        String[] splittedLine;
        if (dataValidator.validate(data)) {
            for (String line : data) {
                splittedLine = line.split(",");
                if (Columns.inColumns(splittedLine[0])) {
                    continue;
                }
                OperationTypes.getOperationHandler(splittedLine[0])
                        .changeBalance(splittedLine[1], Integer.parseInt(splittedLine[2]));
            }
            File file = new File("./src/main/resources/FruitShopReport.txt");
            new WriterToFileImpl().write(
                    file,
                    Columns.getAllColumns(TYPE_INDEX + 1)
                    + System.lineSeparator()
                            + new ProcessFruitsMapToString().process(fruitBalanceService.getAll()));
            return;
        }
        throw new InvalidDataException("Invalid data");
    }

    public GenericDao getCurrentBalanceService() {
        return fruitBalanceService;
    }
}
