package service;

import java.util.List;

public interface ReadTransactions {

    List<String> convertFromFileToList(String path);
}
