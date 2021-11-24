import java.util.HashMap;
import java.util.List;
import model.Operation;
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
        HashMap<Operation, ActionStrategyHandler> actionStrategyHashMap = new HashMap<>();
        actionStrategyHashMap.put(Operation.B, new PlusQuantityHandler());
        actionStrategyHashMap.put(Operation.S, new PlusQuantityHandler());
        actionStrategyHashMap.put(Operation.R, new PlusQuantityHandler());
        actionStrategyHashMap.put(Operation.P, new MinusQuantityHandler());

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
