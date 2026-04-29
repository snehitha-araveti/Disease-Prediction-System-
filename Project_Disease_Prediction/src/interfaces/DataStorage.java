package interfaces;

import java.io.IOException;
import java.util.List;

public interface DataStorage {
    void saveUserQuery(String symptoms, String diagnosis) throws IOException;
    List<String> getQueryHistory() throws IOException;
    void saveUserFeedback(String diseaseName, boolean wasCorrect) throws IOException;
}