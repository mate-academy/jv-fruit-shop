import java.util.List;
import service.FileWriterService;
import service.impl.DataProcessServiceImpl;
import service.impl.FileReaderServiceImpl;
import service.impl.FileWriterServiceImpl;
import service.impl.ValidatorServiceImpl;

public class Main {

    public static void main(String[] args) {
        final DataProcessServiceImpl dataProcess = new DataProcessServiceImpl();
        final FileReaderServiceImpl fileReader = new FileReaderServiceImpl();
        final FileWriterService fileWriter = new FileWriterServiceImpl();
        final ValidatorServiceImpl validatorService = new ValidatorServiceImpl();
        List<String> listInput = fileReader.read();
        validatorService.isValidate(listInput);
        dataProcess.updateStorageData(listInput);
        fileWriter.write();
    }
}
