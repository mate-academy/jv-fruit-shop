import java.util.HashMap;
import java.util.List;
import service.FileWriterService;
import service.action.ActionStrategyHandler;
import service.action.type.MinusQuantityHandler;
import service.action.type.PlusQuantityHandler;
import service.impl.FileReaderServiceImpl;
import service.impl.FileWriterServiceImpl;
import service.impl.UpdateStorageServiceImpl;
import service.impl.ValidatorServiceImpl;

public class Main {
    private static final String INPUT_FILE_NAME = "src\\main\\resources\\input.csv";
    private static final String OUTPUT_FILE_NAME = "src\\main\\resources\\output.csv";

    public static void main(String[] args) {
        HashMap<String, ActionStrategyHandler> actionStrategyHashMap = new HashMap<>();
        actionStrategyHashMap.put("b", new PlusQuantityHandler());
        actionStrategyHashMap.put("s", new PlusQuantityHandler());
        actionStrategyHashMap.put("r", new PlusQuantityHandler());
        actionStrategyHashMap.put("p", new MinusQuantityHandler());

        final UpdateStorageServiceImpl dataProcess =
                new UpdateStorageServiceImpl(actionStrategyHashMap);
        final FileReaderServiceImpl fileReader = new FileReaderServiceImpl();
        final FileWriterService fileWriter = new FileWriterServiceImpl();
        final ValidatorServiceImpl validatorService = new ValidatorServiceImpl();

        List<String> listInput = fileReader.read(INPUT_FILE_NAME);
        validatorService.isValidData(listInput);
        dataProcess.updateStorageData(listInput);
        fileWriter.write(OUTPUT_FILE_NAME);
    }
}
