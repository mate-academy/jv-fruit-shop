import java.util.List;
import strategy.Strategy;
import util.FileUtil;

public class Main {
    private static final String inputUrl = "src/main/java/resources/Input.csv";

    private static final String resultUrl = "src/main/java/resources/Report.csv";

    public static void main(String[] args) {
        Strategy controller = new Strategy();
        FileUtil fileUtil = new FileUtil();
        List<String> input = fileUtil.getLineString(inputUrl);
        controller.operation(input);
        String report = controller.getReport();
        fileUtil.writeFile(resultUrl, report);
    }
}
