package Main;

/*import interfaces.*;
import abstract_classes.*;
import services.*;
import Implementations.*;
import java.util.*;
import java.util.stream.Collectors;
import java.io.IOException;

public class main {
    private DiseaseRepository diseaseRepository;
    private UserInteraction userInteraction;
    private DataStorage dataStorage;
    private DiseaseAnalyzer diseaseAnalyzer;

    public main() {
        diseaseRepository = new DiseaseRepository();
        userInteraction = (UserInteraction) new ConsoleUserInteraction();
        dataStorage = new FileDataStorage();
        diseaseAnalyzer = new DiseaseAnalyzer();
    }

    public void start() {
        userInteraction.displayWelcomeMessage();

        try {
            boolean running = true;
            while (running) {
                userInteraction.displayOptions();
                String choice = userInteraction.getUserInput();

                switch (choice) {
                    case "1":
                        predictDisease();
                        break;
                    case "2":
                        displayDiseaseInfo();
                        break;
                    case "3":
                        displayQueryHistory();
                        break;
                    case "4":
                        collectFeedback();
                        break;
                    case "5":
                        running = false;
                        break;
                    default:
                        userInteraction.displayMessage("Invalid choice. Please try again.");
                }
            }
        } catch (Exception e) {
            userInteraction.displayMessage("An error occurred: " + e.getMessage());
            e.printStackTrace();
        } finally {
            userInteraction.close();
            userInteraction.displayMessage("Thank you for using the Disease Prediction System.");
        }
    }

    private void predictDisease() throws IOException {
        userInteraction.displayMessage("\nEnter your symptoms separated by commas:");
        String input = userInteraction.getUserInput();
        List<String> symptoms = Arrays.stream(input.split(","))
                .map(String::trim)
                .collect(Collectors.toList());

        List<DiseaseInfo> possibleDiseases = diseaseRepository.findPossibleDiseases(symptoms);

        if (possibleDiseases.isEmpty()) {
            userInteraction.displayMessage("No diseases found matching your symptoms.");
            return;
        }

        // Analyze symptom matches
        Map<DiseaseInfo, Integer> matchScores = diseaseAnalyzer.analyzeSymptomMatches(possibleDiseases, symptoms);
        DiseaseInfo mostLikely = diseaseAnalyzer.getMostLikelyDisease(matchScores);

        userInteraction.displayMessage("\nMost likely diagnosis: " + mostLikely.getDiseaseName());
        userInteraction.displayResult(mostLikely);
        dataStorage.saveUserQuery(input, mostLikely.getDiseaseName());
    }

    private void displayDiseaseInfo() {
        userInteraction.displayMessage("\nEnter the name of the disease you want information about:");
        String diseaseName = userInteraction.getUserInput();
        DiseaseInfo disease = diseaseRepository.getDiseaseByName(diseaseName);

        if (disease != null) {
            userInteraction.displayResult(disease);
        } else {
            userInteraction.displayMessage("Disease not found in our database.");
        }
    }

    private void displayQueryHistory() {
        try {
            List<String> history = dataStorage.getQueryHistory();
            if (history.isEmpty()) {
                userInteraction.displayMessage("No query history found.");
            } else {
                userInteraction.displayMessage("\n=== QUERY HISTORY ===");
                history.forEach(userInteraction::displayMessage);
            }
        } catch (IOException e) {
            userInteraction.displayMessage("Error reading query history: " + e.getMessage());
        }
    }

    private void collectFeedback() throws IOException {
        userInteraction.displayMessage("\nEnter the disease name you were diagnosed with:");
        String diseaseName = userInteraction.getUserInput();
        
        userInteraction.displayMessage("Was this diagnosis correct? (yes/no)");
        String feedback = userInteraction.getUserInput();
        
        boolean wasCorrect = feedback.equalsIgnoreCase("yes");
        dataStorage.saveUserFeedback(diseaseName, wasCorrect);
        userInteraction.displayMessage("Thank you for your feedback!");
    }

    public static void main(String[] args) {
        new main().start();
    }
}*/

import interfaces.*;
import services.*;
import Implementations.*;
import abstract_classes.*;
import diseases.*;
import java.util.*;
import java.util.stream.Collectors;
import java.io.*;
import java.time.*;
import java.time.format.*;

public class main {
    private DiseaseRepository diseaseRepository;
    private UserInteraction userInteraction;
    private DataStorage dataStorage;
    private DiseaseAnalyzer diseaseAnalyzer;
    private static final DateTimeFormatter TIMESTAMP_FORMAT = 
        DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private static final String REPORT_DIRECTORY = "medical_reports";

    public main() {
        try {
            this.diseaseRepository = new DiseaseRepository();
            this.userInteraction = new ConsoleUserInteraction();
            this.dataStorage = new FileDataStorage();
            this.diseaseAnalyzer = new DiseaseAnalyzer();
            createReportDirectory();
        } catch (Exception e) {
            System.err.println("System initialization failed: " + e.getMessage());
            System.exit(1);
        }
    }

    private void createReportDirectory() {
        File dir = new File(REPORT_DIRECTORY);
        if (!dir.exists()) {
            dir.mkdir();
        }
    }

    public void start() {
        try {
            displaySystemHeader();
            mainMenuLoop();
        } catch (Exception e) {
            userInteraction.displayMessage("A critical error occurred: " + e.getMessage());
        } finally {
            userInteraction.close();
            userInteraction.displayMessage("\nThank you for using the Disease Prediction System.");
        }
    }

    private void displaySystemHeader() {
        System.out.println("\n╔══════════════════════════════════════════════════════╗");
        System.out.println("║    MEDICAL DIAGNOSIS AND TREATMENT RECOMMENDATION    ║");
        System.out.println("╠══════════════════════════════════════════════════════╣");
        System.out.printf("║ %-25s: %-25s ║\n", "Version", "3.1.0");
        System.out.printf("║ %-25s: %-25s ║\n", "Last Updated", 
            LocalDateTime.now().format(TIMESTAMP_FORMAT));
        System.out.println("╚══════════════════════════════════════════════════════╝\n");
    }

    private void mainMenuLoop() {
        int choice = 0;
        do {
            try {
                displayMainMenu();
                String input = userInteraction.getUserInput().trim();
                
                if (input.isEmpty()) {
                    throw new IllegalArgumentException("Please enter a valid number (1-6)");
                }
                
                choice = Integer.parseInt(input);
                
                switch (choice) {
                    case 1:
                        predictDiseaseWorkflow();
                        break;
                    case 2:
                        browseDiseasesWorkflow();
                        break;
                    case 3:
                        viewHistoryWorkflow();
                        break;
                    case 4:
                        provideFeedbackWorkflow();
                        break;
                    case 5:
                        emergencyCheckerWorkflow();
                        break;
                    case 6:
                        userInteraction.displayMessage("Exiting system...");
                        break;
                    default:
                        userInteraction.displayMessage("Invalid choice. Please enter 1-6.");
                }
            } catch (NumberFormatException e) {
                userInteraction.displayMessage("Error: Please enter a number between 1-6");
            } catch (IllegalArgumentException e) {
                userInteraction.displayMessage(e.getMessage());
            } catch (Exception e) {
                userInteraction.displayMessage("Operation failed: " + e.getMessage());
            }
        } while (choice != 6);
    }

    private void displayMainMenu() {
        userInteraction.displayMessage("\nMAIN MENU");
        userInteraction.displayMessage("1. Disease Prediction by Symptoms");
        userInteraction.displayMessage("2. Browse Disease Information");
        userInteraction.displayMessage("3. View Diagnosis History");
        userInteraction.displayMessage("4. Provide Feedback on Previous Diagnosis");
        userInteraction.displayMessage("5. Emergency Symptoms Checker");
        userInteraction.displayMessage("6. Exit System");
        userInteraction.displayMessage("Enter your choice (1-6): ");
    }

    private void predictDiseaseWorkflow() {
        try {
            userInteraction.displayMessage("\n╔════════════════════════════════════╗");
            userInteraction.displayMessage("║      SYMPTOM ANALYSIS SYSTEM      ║");
            userInteraction.displayMessage("╚════════════════════════════════════╝");
            
            List<String> symptoms = getValidatedSymptoms();
            List<DiseaseInfo> possibleDiseases =  diseaseRepository.findPossibleDiseases(symptoms);
            
            if (possibleDiseases.isEmpty()) {
                userInteraction.displayMessage("\nNo matching diseases found for your symptoms.");
                return;
            }
            
            DiseaseInfo mostLikely = diseaseAnalyzer.getMostLikelyDisease(possibleDiseases, symptoms);
            displayDiagnosisResult(mostLikely);
            generateDiagnosisReport(symptoms, mostLikely);
            
            dataStorage.saveUserQuery(String.join(",", symptoms), mostLikely.getDiseaseName());
            
            followUpQuestions(mostLikely);
            
        } catch (IOException e) {
            userInteraction.displayMessage("Error saving your diagnosis: " + e.getMessage());
        } catch (Exception e) {
            userInteraction.displayMessage("Diagnosis error: " + e.getMessage());
        }
    }

    private List<String> getValidatedSymptoms() {
        while (true) {
            try {
                userInteraction.displayMessage("\nEnter your symptoms (comma separated):");
                userInteraction.displayMessage("Example: fever,headache,cough");
                String input = userInteraction.getUserInput().trim();
                
                if (input.isEmpty()) {
                    throw new IllegalArgumentException("At least one symptom is required");
                }
                
                List<String> symptoms = Arrays.stream(input.split(","))
                        .map(String::trim)
                        .filter(s -> !s.isEmpty())
                        .collect(Collectors.toList());
                
                if (symptoms.size() < 1) {
                    throw new IllegalArgumentException("Please enter valid symptoms");
                }
                
                return symptoms;
                
            } catch (IllegalArgumentException e) {
                userInteraction.displayMessage("Invalid input: " + e.getMessage());
            }
        }
    }

    private void displayDiagnosisResult(DiseaseInfo disease) {
        ((AbstractDisease)disease).displayBasicInfo();
        
        userInteraction.displayMessage("\nDESCRIPTION:");
        userInteraction.displayMessage(disease.getDescription());
        
        userInteraction.displayMessage("\nTOP RECOMMENDATIONS:");
        ((Collection<String>) disease.getPrimaryTreatments()).stream()
            .limit(3)
            .forEach(t -> userInteraction.displayMessage(" • " + t));
        
        userInteraction.displayMessage("\nWHEN TO SEEK HELP:");
        userInteraction.displayMessage(" → " + disease.getWhenToSeeDoctor());
    }

    private void generateDiagnosisReport(List<String> symptoms, DiseaseInfo disease) throws IOException {
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
        String filename = REPORT_DIRECTORY + "/diagnosis_" + timestamp + ".txt";
        
        try (PrintWriter writer = new PrintWriter(filename)) {
            writer.println("MEDICAL DIAGNOSIS REPORT");
            writer.println("Generated: " + LocalDateTime.now().format(TIMESTAMP_FORMAT));
            writer.println("\n=== PATIENT REPORTED SYMPTOMS ===");
            symptoms.forEach(writer::println);
            
            writer.println("\n=== DIAGNOSIS ===");
            writer.println("Condition: " + disease.getDiseaseName());
            writer.println("ICD-10 Code: " + disease.getICDCode());
            
            writer.println("\n=== RECOMMENDED TREATMENT ===");
            disease.getPrimaryTreatments().forEach(t -> writer.println(" • " + t));
            
            writer.println("\n=== WHEN TO SEEK HELP ===");
            writer.println(disease.getWhenToSeeDoctor());
            
            userInteraction.displayMessage("\nReport generated: " + filename);
        }
    }

    private void followUpQuestions(DiseaseInfo disease) throws IOException {
        userInteraction.displayMessage("\nWould you like to:");
        userInteraction.displayMessage("1. Save this to your medical history");
        userInteraction.displayMessage("2. Get specialist information");
        userInteraction.displayMessage("3. Return to main menu");
        userInteraction.displayMessage("Enter choice (1-3): ");
        
        String choice = userInteraction.getUserInput();
        switch (choice) {
            case "1":
                dataStorage.saveUserQuery("Saved Diagnosis", disease.getDiseaseName());
                userInteraction.displayMessage("Diagnosis saved to history.");
                break;
            case "2":
                displaySpecialistInformation(disease);
                break;
        }
    }

   

	private void browseDiseasesWorkflow() {
        try {
            userInteraction.displayMessage("\n╔════════════════════════════════════╗");
            userInteraction.displayMessage("║      DISEASE INFORMATION PORTAL    ║");
            userInteraction.displayMessage("╚════════════════════════════════════╝");
            
            List<DiseaseInfo> allDiseases = diseaseRepository.getAllDiseases();
            displayDiseaseCategories((DiseaseInfo) allDiseases);
            
            userInteraction.displayMessage("\nEnter disease name or number (0 to return):");
            String input = userInteraction.getUserInput().trim();
            
            if (input.equals("0")) return;
            
            DiseaseInfo selectedDisease = getSelectedDisease(input, allDiseases);
            if (selectedDisease != null) {
                displayDiseaseCategories(selectedDisease);
            } else {
                userInteraction.displayMessage("Disease not found.");
            }
        } catch (Exception e) {
            userInteraction.displayMessage("Error accessing disease information: " + e.getMessage());
        }
    }

	private void displayDiseaseCategories(DiseaseInfo selectedDisease) {
	    // Group diseases by body system
	    Map<String, List<DiseaseInfo>> diseasesBySystem = ((Collection<DiseaseInfo>) selectedDisease).stream()
	        .collect(Collectors.groupingBy(d -> 
	            d.getBodySystemAffected() != null ? 
	            d.getBodySystemAffected() : "General"));
	    
	    // Display header
	    System.out.println("\n╔════════════════════════════════════╗");
	    System.out.println("║        DISEASE CATEGORIES         ║");
	    System.out.println("╠════════════════════════════════════╣");
	    
	    // Display each category with diseases
	    diseasesBySystem.forEach((system, diseases) -> {
	        System.out.printf("║ %-20s: %-15s ║\n", 
	            system.toUpperCase(), 
	            diseases.size() + " conditions");
	        
	        // List diseases in this category
	        diseases.forEach(d -> 
	            System.out.printf("║   • %-35s ║\n", d.getDiseaseName()));
	        
	        System.out.println("╠════════════════════════════════════╣");
	    });
	    
	    System.out.println("╚════════════════════════════════════╝");
	    
	    // Display selection prompt
	    System.out.println("\nEnter the name of a disease for more details,");
	    System.out.println("or enter a body system to see related conditions.");
	}

	private void displaySpecialistInformation(DiseaseInfo disease) {
	    System.out.println("\n╔════════════════════════════════════╗");
	    System.out.println("║      SPECIALIST RECOMMENDATIONS    ║");
	    System.out.println("╠════════════════════════════════════╣");
	    
	    // Determine primary specialist based on affected body system
	    String primarySpecialist = determinePrimarySpecialist(disease);
	    System.out.printf("║ %-20s: %-15s ║\n", "Primary Specialist", primarySpecialist);
	    
	    // Determine if additional specialists are needed
	    List<String> additionalSpecialists = determineAdditionalSpecialists(disease);
	    if (!additionalSpecialists.isEmpty()) {
	        System.out.printf("║ %-20s: %-15s ║\n", "Additional Consult", String.join(", ", additionalSpecialists));
	    }
	    
	    System.out.println("╚════════════════════════════════════╝");
	    
	    // Display follow-up advice
	    System.out.println("\nWhen to seek specialist care:");
	    System.out.println("• " + disease.getWhenToSeeDoctor());
	    System.out.println("• If symptoms worsen or don't improve with initial treatment");
	    System.out.println("• For ongoing management of chronic conditions");
	}

	private String determinePrimarySpecialist(DiseaseInfo disease) {
	    if (disease.getBodySystemAffected() == null) {
	        return "General Physician";
	    }
	    
	    switch (disease.getBodySystemAffected().toLowerCase()) {
	        case "respiratory":
	            return "Pulmonologist";
	        case "cardiovascular":
	            return "Cardiologist";
	        case "neurological":
	            return "Neurologist";
	        case "digestive":
	            return "Gastroenterologist";
	        case "endocrine":
	            return "Endocrinologist";
	        case "musculoskeletal":
	            return "Rheumatologist";
	        default:
	            return "General Physician";
	    }
	}

	private List<String> determineAdditionalSpecialists(DiseaseInfo disease) {
	    List<String> specialists = new ArrayList<>();
	    
	    // Add specialists based on disease characteristics
	    if (disease.getSeverity().equalsIgnoreCase("severe")) {
	        specialists.add("Critical Care Specialist");
	    }
	    
	    if (disease instanceof ChronicDisease) {
	        specialists.add("Internal Medicine");
	    }
	    
	    // System-specific specialists
	    if (disease.getBodySystemAffected().equalsIgnoreCase("respiratory") && 
	        disease.getSeverity().equalsIgnoreCase("severe")) {
	        specialists.add("Thoracic Surgeon");
	    }
	    
	    if (disease.getBodySystemAffected().equalsIgnoreCase("neurological")) {
	        specialists.add("Neurosurgeon (if surgical intervention needed)");
	    }
	    
	    return specialists;
	}

	private DiseaseInfo getSelectedDisease(String input, List<DiseaseInfo> diseases) {
        try {
            int choice = Integer.parseInt(input);
            if (choice > 0 && choice <= diseases.size()) {
                return diseases.get(choice - 1);
            }
        } catch (NumberFormatException e) {
            return diseaseRepository.getDiseaseByName(input);
        }
        return null;
    }

    private void viewHistoryWorkflow() {
        try {
            userInteraction.displayMessage("\n╔════════════════════════════════════╗");
            userInteraction.displayMessage("║        QUERY HISTORY VIEWER       ║");
            userInteraction.displayMessage("╚════════════════════════════════════╝");
            
            List<String> history = dataStorage.getQueryHistory();
            if (history.isEmpty()) {
                userInteraction.displayMessage("No history records found.");
                return;
            }
            
            userInteraction.displayMessage("\nLast 5 queries:");
            history.stream()
                .limit(5)
                .forEach(userInteraction::displayMessage);
            
            userInteraction.displayMessage("\nEnter 'all' to view complete history or any key to return:");
            if (userInteraction.getUserInput().equalsIgnoreCase("all")) {
                history.forEach(userInteraction::displayMessage);
            }
        } catch (IOException e) {
            userInteraction.displayMessage("Error accessing history: " + e.getMessage());
        }
    }

    private void provideFeedbackWorkflow() {
        try {
            userInteraction.displayMessage("\n╔════════════════════════════════════╗");
            userInteraction.displayMessage("║        DIAGNOSIS FEEDBACK        ║");
            userInteraction.displayMessage("╚════════════════════════════════════╝");
            
            userInteraction.displayMessage("Enter the disease name you were diagnosed with:");
            String diseaseName = userInteraction.getUserInput().trim();
            
            if (diseaseName.isEmpty()) {
                throw new IllegalArgumentException("Disease name cannot be empty");
            }
            
            userInteraction.displayMessage("Was this diagnosis accurate? (yes/no/partially)");
            String accuracy = userInteraction.getUserInput().toLowerCase();
            
            processFeedback(diseaseName, accuracy);
            
        } catch (IllegalArgumentException e) {
            userInteraction.displayMessage("Invalid input: " + e.getMessage());
        } catch (IOException e) {
            userInteraction.displayMessage("Error saving feedback: " + e.getMessage());
        } catch (Exception e) {
            userInteraction.displayMessage("Feedback processing error: " + e.getMessage());
        }
    }

    private void processFeedback(String diseaseName, String accuracy) throws IOException {
        switch (accuracy) {
            case "yes":
                dataStorage.saveUserFeedback(diseaseName, true);
                userInteraction.displayMessage("Thank you for your positive feedback!");
                break;
            case "no":
            case "partially":
                dataStorage.saveUserFeedback(diseaseName, false);
                userInteraction.displayMessage("Please describe the issue:");
                String notes = userInteraction.getUserInput();
                dataStorage.saveUserQuery("Feedback Notes", notes);
                userInteraction.displayMessage("Thank you for helping us improve!");
                break;
            default:
                throw new IllegalArgumentException("Please enter 'yes', 'no', or 'partially'");
        }
    }

    private void emergencyCheckerWorkflow() {
        try {
            userInteraction.displayMessage("\n╔════════════════════════════════════╗");
            userInteraction.displayMessage("║      EMERGENCY SYMPTOM CHECKER    ║");
            userInteraction.displayMessage("╚════════════════════════════════════╝");
            
            userInteraction.displayMessage("\nWARNING: This is not a substitute for emergency care!");
            userInteraction.displayMessage("If experiencing life-threatening symptoms, call emergency services immediately.\n");
            
            displayEmergencyCategories();
            
            int choice = getEmergencyCategoryChoice();
            if (choice == 5) return;
            
            String[] emergencySymptoms = getEmergencySymptomsByCategory(choice);
            displayEmergencyChecklist(emergencySymptoms);
            
        } catch (NumberFormatException e) {
            userInteraction.displayMessage("Please enter a valid number (1-5)");
        } catch (IllegalArgumentException e) {
            userInteraction.displayMessage(e.getMessage());
        } catch (Exception e) {
            userInteraction.displayMessage("Emergency check failed: " + e.getMessage());
        }
    }

    private void displayEmergencyChecklist(String[] emergencySymptoms) {
        System.out.println("\n╔════════════════════════════════════╗");
        System.out.println("║      EMERGENCY SYMPTOM CHECKLIST    ║");
        System.out.println("╠════════════════════════════════════╣");
        
        for (int i = 0; i < emergencySymptoms.length; i++) {
            System.out.printf("║ %2d. %-30s ║\n", i+1, emergencySymptoms[i]);
        }
        System.out.println("╚════════════════════════════════════╝");
        
        System.out.println("\nIf experiencing any of these symptoms:");
        System.out.println("• Call emergency services immediately");
        System.out.println("• Do not attempt to drive yourself");
        System.out.println("• Have someone stay with you");
    }

    private String[] getEmergencySymptomsByCategory(int choice) {
        switch (choice) {
            case 1: // Chest/Heart symptoms
                return new String[]{
                    "Chest pain or pressure lasting >2 minutes",
                    "Pain radiating to arm/jaw/back",
                    "Sudden severe palpitations",
                    "Fainting with chest discomfort"
                };
            case 2: // Breathing difficulties
                return new String[]{
                    "Severe difficulty breathing",
                    "Lips/nails turning blue",
                    "Gasping for air",
                    "Inability to speak full sentences"
                };
            case 3: // Neurological symptoms
                return new String[]{
                    "Sudden severe headache (worst ever)",
                    "Loss of consciousness",
                    "Sudden weakness/numbness on one side",
                    "Slurred speech or confusion"
                };
            case 4: // Severe pain
                return new String[]{
                    "Sudden severe abdominal pain",
                    "Headache with fever and stiff neck",
                    "Severe eye pain with vision changes",
                    "Testicular pain with swelling"
                };
            default:
                return new String[]{"No emergency symptoms selected"};
        }
    }

	private void displayEmergencyCategories() {
        userInteraction.displayMessage("Select symptom category:");
        userInteraction.displayMessage("1. Chest/Heart Symptoms");
        userInteraction.displayMessage("2. Breathing Difficulties");
        userInteraction.displayMessage("3. Neurological Symptoms");
        userInteraction.displayMessage("4. Severe Pain");
        userInteraction.displayMessage("5. Return to Main Menu");
    }

    private int getEmergencyCategoryChoice() {
        String input = userInteraction.getUserInput().trim();
        if (input.isEmpty()) {
            throw new IllegalArgumentException("Please enter a number (1-5)");
        }
        
        int choice = Integer.parseInt(input);
        if (choice < 1 || choice > 5) {
            throw new IllegalArgumentException("Please enter a number between 1-5");
        }
        return choice;
    }

    public static void main(String[] args) {
        new main().start();
    }
}