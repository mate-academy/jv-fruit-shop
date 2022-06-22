package servise;

import java.util.List;

public interface ShopService {
    void process(List<String> records);

    String getReport();
}
