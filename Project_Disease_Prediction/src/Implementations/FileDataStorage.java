package Implementations;

import interfaces.DataStorage;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileDataStorage implements DataStorage {
    private static final String QUERY_FILE = "user_queries.txt";
    private static final String FEEDBACK_FILE = "user_feedback.txt";

    @Override
    public void saveUserQuery(String symptoms, String diagnosis) throws IOException {
        try (PrintWriter out = new PrintWriter(new FileWriter(QUERY_FILE, true))) {
            out.println("SYMPTOMS: " + symptoms);
            out.println("DIAGNOSIS: " + diagnosis);
            out.println("TIMESTAMP: " + System.currentTimeMillis());
            out.println("----------------------------");
        }
    }

    @Override
    public List<String> getQueryHistory() throws IOException {
        List<String> history = new ArrayList<>();
        File file = new File(QUERY_FILE);
        
        if (!file.exists()) {
            return history;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                history.add(line);
            }
        }
        return history;
    }

    @Override
    public void saveUserFeedback(String diseaseName, boolean wasCorrect) throws IOException {
        try (PrintWriter out = new PrintWriter(new FileWriter(FEEDBACK_FILE, true))) {
            out.println("DISEASE: " + diseaseName);
            out.println("CORRECT: " + wasCorrect);
            out.println("TIMESTAMP: " + System.currentTimeMillis());
            out.println("----------------------------");
        }
    }
}