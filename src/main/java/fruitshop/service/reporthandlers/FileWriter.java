package fruitshop.service.reporthandlers;

import java.io.File;

public interface FileWriter {
    File writeToFile(String fruitShopReport, String reportFileName);
}
