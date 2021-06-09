package core.basesyntax;

import java.util.List;

/**
 * Feel free to remove this class and create your own.
 */
public class FruitStore {

    private final ReportBuilder reportBuilder = new ReportBuilderImpl();
    private final FileService fileService = new FileServiceImpl();
    private final Validator validator = new ValidatorImpl();
    private final String inputFileName =
            "C:\\Users\\mbelm\\IdeaProjects\\jv-fruit-shop\\src"
                    + "\\main\\java\\core\\basesyntax\\input.txt";
    private final String outputFileName = "output.txt";

    public static void main(String[] args) {
        FruitStore store = new FruitStore();
        List<String> records = store.fileService.readFile(store.inputFileName);
        store.validator.validate(records);
        String report = store.reportBuilder.buildReport(records);
        store.fileService.writeFile(store.outputFileName, report);

    }

}
