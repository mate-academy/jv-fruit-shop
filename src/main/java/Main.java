import service.ReaderService;
import service.impl.ReaderServiceImpl;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ReaderService readerService = new ReaderServiceImpl();
        List<String> data = readerService.readFromFile("src/main/resources/fruits.csv");
    }
}
