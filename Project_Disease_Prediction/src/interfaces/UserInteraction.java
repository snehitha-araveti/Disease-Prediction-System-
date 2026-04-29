package interfaces;

import java.util.List;

import interfaces.DiseaseInfo;

public interface UserInteraction {
    void displayWelcomeMessage();
    void displayOptions();
    void displayResult(DiseaseInfo disease);
    void displayMessage(String message);
    String getUserInput();
    void displayPossibleDiseases(List<DiseaseInfo> possibleDiseases);
    void close();
}