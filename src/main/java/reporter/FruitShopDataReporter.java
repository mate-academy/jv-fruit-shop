package reporter;

import dao.FruitsDao;
import dao.GenericDao;
import exceptions.InvalidDataException;
import java.io.File;
import java.nio.file.Path;
import java.util.List;
import reader.FileReaderImpl;
import service.DaoUpdater;
import service.ProcessFruitsMapToString;
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
        if (dataValidator.validate(data)) {
            DaoUpdater.updateData(data);
            File file = new File("./src/main/resources/FruitShopReport.txt");
            new WriterToFileImpl().write(
                    file,
                    new StringBuilder("fruit, quantity")
                            .append(System.lineSeparator())
                            .append(new ProcessFruitsMapToString()
                                    .process(fruitBalanceService.getAll()))
                            .toString());
            return;
        }
        throw new InvalidDataException("Invalid data");
    }

    public GenericDao getCurrentBalanceService() {
        return fruitBalanceService;
    }
}
