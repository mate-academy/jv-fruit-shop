import service.FileService;
import service.FileServiceImpl;

public class Main {
    public static void main(String[] args) {
        FileService fileService = new FileServiceImpl();
        fileService.getReport("input.csv", "output.csv");

    }
}
