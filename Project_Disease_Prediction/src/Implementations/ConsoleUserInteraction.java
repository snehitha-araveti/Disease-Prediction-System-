package Implementations;

import interfaces.UserInteraction;
import interfaces.DiseaseInfo;
import java.util.List;
import java.util.Scanner;

public class ConsoleUserInteraction implements UserInteraction {
    private Scanner scanner;

    public ConsoleUserInteraction() {
        scanner = new Scanner(System.in);
    }

    @Override
    public void displayWelcomeMessage() {
        System.out.println("====================================");
        System.out.println("   DISEASE PREDICTION SYSTEM   ");
        System.out.println("====================================");
        System.out.println("Enter your symptoms separated by commas");
        System.out.println("Example: fever,headache,cough");
    }

    @Override
    public void displayOptions() {
        System.out.println("\nOptions:");
        System.out.println("1. Predict disease from symptoms");
        System.out.println("2. Get detailed info about a disease");
        System.out.println("3. View query history");
        System.out.println("4. Provide feedback on previous diagnosis");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    @Override
    public void displayResult(DiseaseInfo disease) {
        System.out.println("\n=== DIAGNOSIS RESULT ===");
        System.out.println("Disease: " + disease.getDiseaseName());
        System.out.println("Description: " + disease.getDescription());
        System.out.println("Severity: " + disease.getSeverity());
        
        System.out.println("\nSymptoms:");
        disease.getSymptoms().forEach(s -> System.out.println("- " + s));
        
        System.out.println("\nPrimary Treatments:");
        disease.getPrimaryTreatments().forEach(t -> System.out.println("- " + t));
        
        System.out.println("\nWhen to see a doctor: " + disease.getWhenToSeeDoctor());
        System.out.println("Typical recovery time: " + disease.getRecoveryTime());
    }

    @Override
    public String getUserInput() {
        return scanner.nextLine().trim();
    }

    @Override
    public void displayMessage(String message) {
        System.out.println(message);
    }

    @Override
    public void displayPossibleDiseases(List<DiseaseInfo> possibleDiseases) {
        System.out.println("\nPossible diseases based on your symptoms:");
        for (int i = 0; i < possibleDiseases.size(); i++) {
            System.out.println((i + 1) + ". " + possibleDiseases.get(i).getDiseaseName());
        }
        System.out.print("Select a disease for more details (0 to skip): ");
    }

    @Override
    public void close() {
        scanner.close();
    }
}