package services;

import interfaces.DiseaseInfo;
import java.util.*;
import java.util.stream.Collectors;

import diseases.Asthma;
import diseases.CommonCold;
import diseases.Covid19;
import diseases.Gastroenteritis;
import diseases.Hypertension;
import diseases.Influenza;
import diseases.Migraine;
import diseases.Pneumonia;
import diseases.Type2Diabetes;

import java.io.*;
import java.nio.file.*;

public class DiseaseRepository {
    private List<DiseaseInfo> diseases;
    private Map<String, DiseaseInfo> diseaseNameMap;
    private static final String DISEASE_DATA_FILE = "disease_data.dat";

    public List<DiseaseInfo> loadDiseases() {
        // Try loading from serialized file first
        if (Files.exists(Paths.get(DISEASE_DATA_FILE))) {
            try (ObjectInputStream ois = new ObjectInputStream(
                    new FileInputStream(DISEASE_DATA_FILE))) {
                diseases = (List<DiseaseInfo>) ois.readObject();
                return diseases;
            } catch (Exception e) {
                System.err.println("Error loading disease data: " + e.getMessage());
            }
        }
        
        // Initialize default diseases if file doesn't exist
        initializeDefaultDiseases();
        saveDiseasesToFile();
		return diseases;
    }

    private void initializeDefaultDiseases() {
        diseases.add(new Covid19());
        diseases.add(new Type2Diabetes());
        // Add all other diseases here
    }

    private void saveDiseasesToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(DISEASE_DATA_FILE))) {
            oos.writeObject(diseases);
        } catch (Exception e) {
            System.err.println("Error saving disease data: " + e.getMessage());
        }
    }
    
    public DiseaseRepository() {
        diseases = new ArrayList<>();
        diseaseNameMap = new HashMap<>();
        initializeDiseases();
    }

    private void initializeDiseases() {
        // Initialize all diseases
        DiseaseInfo[] allDiseases = {
            new Asthma(),
            new CommonCold(),
            new Covid19(),
            new Gastroenteritis(),
            new Hypertension(),
            new Migraine(),
            new Pneumonia(),
            new Type2Diabetes()
        };

        // Add to collections
        for (DiseaseInfo disease : allDiseases) {
            diseases.add(disease);
            diseaseNameMap.put(disease.getDiseaseName().toLowerCase(), disease);
        }
    }

    public List<DiseaseInfo> findPossibleDiseases(List<String> symptoms) {
        if (symptoms == null || symptoms.isEmpty()) {
            return Collections.emptyList();
        }

        // Convert symptoms to lowercase for case-insensitive matching
        List<String> normalizedSymptoms = symptoms.stream()
            .map(String::toLowerCase)
            .collect(Collectors.toList());

        return diseases.stream()
            .filter(disease -> hasMatchingSymptoms(disease, normalizedSymptoms))
            .sorted(Comparator.comparingInt(disease -> 
                -countMatchingSymptoms(disease, normalizedSymptoms))) // Sort by match count descending
            .collect(Collectors.toList());
    }

    private boolean hasMatchingSymptoms(DiseaseInfo disease, List<String> symptoms) {
        return disease.getSymptoms().stream()
            .anyMatch(symptom -> symptoms.contains(symptom.toLowerCase()));
    }

    private int countMatchingSymptoms(DiseaseInfo disease, List<String> symptoms) {
        return (int) disease.getSymptoms().stream()
            .filter(symptom -> symptoms.contains(symptom.toLowerCase()))
            .count();
    }

    public DiseaseInfo getDiseaseByName(String input) {
        if (input == null || input.trim().isEmpty()) {
            return null;
        }

        // Try exact match first
        DiseaseInfo disease = diseaseNameMap.get(input.toLowerCase());
        if (disease != null) {
            return disease;
        }

        // Try partial match if exact not found
        return diseases.stream()
            .filter(d -> d.getDiseaseName().toLowerCase().contains(input.toLowerCase()))
            .findFirst()
            .orElse(null);
    }

    // Additional method for alcohol-related analysis
    public List<DiseaseInfo> getAlcoholRelatedDiseases() {
        return diseases.stream()
            .filter(d -> d.getDescription().toLowerCase().contains("alcohol") || 
                        d.getPrecautions().stream().anyMatch(p -> p.toLowerCase().contains("alcohol")))
            .collect(Collectors.toList());
    }

    public List<DiseaseInfo> getAllDiseases() {
        return new ArrayList<>(diseases);
    }
}


	