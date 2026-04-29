package diseases;

import java.util.List;

import abstract_classes.ChronicDisease;

public class Type2Diabetes extends ChronicDisease {
    public Type2Diabetes() {
        name = "Type 2 Diabetes";
        icdCode = "E11";
        description = "Chronic metabolic disorder characterized by insulin resistance";
        bodySystemAffected = "Endocrine";
        severity = "Chronic";
        isGenetic = true;
        managementPlan = "Lifestyle modifications and medication";
        
        riskFactors.add("Obesity");
        riskFactors.add("Family history");
        riskFactors.add("Sedentary lifestyle");
        
        symptoms.add("Increased thirst");
        symptoms.add("Frequent urination");
        symptoms.add("Blurred vision");
        symptoms.add("Slow healing wounds");
        
        precautions.add("Regular exercise");
        precautions.add("Healthy diet");
        precautions.add("Blood sugar monitoring");
        
        medications.add("Metformin");
        medications.add("Sulfonylureas");
        medications.add("Insulin (in advanced cases)");
        
        homeRemedies.add("Fenugreek water");
        homeRemedies.add("Bitter gourd juice");
        homeRemedies.add("Cinnamon");
        
        primaryTreatments.add("Blood glucose control");
        primaryTreatments.add("HbA1c monitoring");
        
        recoveryTime = "Lifelong management";
        whenToSeeDoctor = "If blood sugar > 300 mg/dL or < 70 mg/dL";
    }

	
}