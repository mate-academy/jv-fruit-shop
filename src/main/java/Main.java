import java.util.List;
import service.DataProcessingServiceImpl;
import service.FileCsvServiceImpl;
import service.ValidatorServiceImpl;

public class Main {
    public static void main(String[] args) {
        DataProcessingServiceImpl dataProcessingService = new DataProcessingServiceImpl();
        final FileCsvServiceImpl reportCsvDao = new FileCsvServiceImpl();
        final ValidatorServiceImpl validator = new ValidatorServiceImpl();

        List<String> listInput = reportCsvDao.getActionsOfDay();
        validator.isValidate(listInput);
        dataProcessingService.dataProcessing(listInput);
        reportCsvDao.setReport();
    }
}
