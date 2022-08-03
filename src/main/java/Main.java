import controller.Controller;
import java.util.List;
import util.FileUtil;

public class Main {
    public static void main(String[] args) {
        Controller controller = new Controller();
        FileUtil fileUtil = new FileUtil();
        List<String> input = fileUtil.getLineString("src/main/java/resources/Input.csv");
        controller.operation(input);
        String report = controller.getReport();
        fileUtil.writeFile("src/main/java/resources/Report.csv", report);
    }
}
