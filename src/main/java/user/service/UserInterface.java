package user.service;

import java.time.LocalDate;

public interface UserInterface {
    String getReport(String fromPath, String toPath, LocalDate date);
}
