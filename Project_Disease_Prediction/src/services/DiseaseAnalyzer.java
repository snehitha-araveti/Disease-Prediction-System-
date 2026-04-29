package services;

import interfaces.DiseaseInfo;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class DiseaseAnalyzer {
    public Map<DiseaseInfo, Integer> analyzeSymptomMatches(List<DiseaseInfo> possibleDiseases, List<String> userSymptoms) {
        Map<DiseaseInfo, Integer> matchScores = new HashMap<>();
        
        for (DiseaseInfo disease : possibleDiseases) {
            int score = 0;
            for (String symptom : userSymptoms) {
                if (disease.getSymptoms().stream().anyMatch(s -> s.equalsIgnoreCase(symptom))) {
                    score++;
                }
            }
            matchScores.put(disease, score);
        }
        
        return matchScores;
    }

    public DiseaseInfo getMostLikelyDisease(Map<DiseaseInfo, Integer> matchScores) {
        return matchScores.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);
    }

	public DiseaseInfo getMostLikelyDisease(List<DiseaseInfo> possibleDiseases, List<String> symptoms) {
		if (possibleDiseases == null || possibleDiseases.isEmpty()) {
            return null;
        }
        
        if (symptoms == null || symptoms.isEmpty()) {
            return possibleDiseases.get(0); // Return first disease if no symptoms provided
        }

        // Create a map to store disease scores
        Map<DiseaseInfo, Double> diseaseScores = new HashMap<>();

        // Calculate score for each disease
        for (DiseaseInfo disease : possibleDiseases) {
            double score = calculateMatchScore(disease, symptoms);
            diseaseScores.put(disease, score);
        }

        // Return disease with highest score
        return diseaseScores.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(possibleDiseases.get(0)); // Fallback to first disease
    }

    private double calculateMatchScore(DiseaseInfo disease, List<String> symptoms) {
        // Count how many symptoms match
        long matchCount = disease.getSymptoms().stream()
                .filter(diseaseSymptom -> symptoms.stream()
                        .anyMatch(inputSymptom -> inputSymptom.equalsIgnoreCase(diseaseSymptom)))
                .count();

        // Calculate percentage of matching symptoms
        double symptomMatchRatio = (double) matchCount / disease.getSymptoms().size();

        // Consider disease severity (higher severity = higher score)
        double severityFactor = getSeverityFactor(disease.getSeverity());

        // Combine factors (70% symptom match, 30% severity)
        return (0.7 * symptomMatchRatio) + (0.3 * severityFactor);
    }

    private double getSeverityFactor(String severity) {
        if (severity == null) return 0.5;
        
        return switch (severity.toLowerCase()) {
            case "severe" -> 1.0;
            case "high" -> 0.9;
            case "moderate" -> 0.7;
            case "chronic" -> 0.8;
            case "low" -> 0.5;
            case "mild" -> 0.3;
            default -> 0.5;
        };
    
		
	}
}