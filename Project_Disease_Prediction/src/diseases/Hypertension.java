package diseases;

import java.util.List;

import abstract_classes.ChronicDisease;

public class Hypertension extends ChronicDisease {
    public Hypertension() {
        name = "Hypertension (High Blood Pressure)";
        icdCode = "I10";
        description = "Chronic elevation of arterial blood pressure";
        bodySystemAffected = "Cardiovascular";
        severity = "Chronic";
        isGenetic = true;
        managementPlan = "Lifestyle modifications and pharmacotherapy";
        
        riskFactors.add("Family history");
        riskFactors.add("Obesity");
        riskFactors.add("High sodium diet");
        riskFactors.add("Sedentary lifestyle");
        
        symptoms.add("Often asymptomatic (silent killer)");
        symptoms.add("Headaches (typically morning occipital)");
        symptoms.add("Dizziness");
        symptoms.add("Blurred vision");
        symptoms.add("Nosebleeds (severe cases)");
        
        precautions.add("DASH diet (Dietary Approaches to Stop Hypertension)");
        precautions.add("Regular aerobic exercise (150 mins/week)");
        precautions.add("Sodium restriction (<2g/day)");
        precautions.add("Alcohol moderation");
        precautions.add("Stress management techniques");
        
        medications.add("ACE inhibitors (lisinopril)");
        medications.add("ARBs (losartan)");
        medications.add("Calcium channel blockers (amlodipine)");
        medications.add("Diuretics (hydrochlorothiazide)");
        
        homeRemedies.add("Garlic supplementation");
        homeRemedies.add("Hibiscus tea");
        homeRemedies.add("Dark chocolate (85%+ cocoa)");
        
        primaryTreatments.add("Lifestyle modification first-line");
        primaryTreatments.add("Stepwise pharmacotherapy if >140/90 mmHg");
        
        recoveryTime = "Lifelong management";
        whenToSeeDoctor = "If BP >180/120 mmHg (hypertensive crisis)";
    }

	
}
