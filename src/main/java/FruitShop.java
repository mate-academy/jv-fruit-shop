import dto.Storage;
import java.util.List;
import model.CurrentBalance;
import servise.ActivitiesHandler;
import servise.ParserImpl;
import servise.ReaderFromCsvFileImpl;

public class FruitShop {

    public static void main(String[] args) {
        ReaderFromCsvFileImpl file = new ReaderFromCsvFileImpl("src/main/resources/Input_file.csv");
        List<String> stringsFromFile = file.readFromFile();
        List<Storage> storagesList = new ParserImpl().parse(stringsFromFile);
        ActivitiesHandler activitiesHandler = new ActivitiesHandler();
        CurrentBalance currentBalance = new CurrentBalance();
        activitiesHandler.handle(storagesList, currentBalance);
        currentBalance.saveOutPut("src/main/resources/Output_file.csv");
    }
}
