package diseases;

import java.util.List;

import abstract_classes.InfectiousDisease;

public class Gastroenteritis extends InfectiousDisease {
    public Gastroenteritis() {
        name = "Gastroenteritis";
        icdCode = "A09";
        description = "Inflammation of stomach and intestines from infection";
        bodySystemAffected = "Gastrointestinal";
        severity = "Mild to Severe";
        transmissionMethod = "Fecal-oral, contaminated food/water";
        isContagious = true;
        incubationPeriod = "12-48 hours (viral), 1-7 days (bacterial)";
        
        symptoms.add("Watery diarrhea (non-bloody)");
        symptoms.add("Vomiting (often projectile)");
        symptoms.add("Abdominal cramps");
        symptoms.add("Low-grade fever");
        symptoms.add("Dehydration signs (dry mouth, decreased urine)");
        
        precautions.add("Proper handwashing (especially after toileting)");
        precautions.add("Food safety practices");
        precautions.add("Rotavirus vaccination for infants");
        precautions.add("Avoid antidiarrheals in infectious cases");
        
        medications.add("Oral rehydration solutions (WHO formula)");
        medications.add("Zinc supplements (for children)");
        medications.add("Antiemetics (ondansetron for severe vomiting)");
        medications.add("Probiotics (Saccharomyces boulardii)");
        
        homeRemedies.add("BRAT diet (bananas, rice, applesauce, toast)");
        homeRemedies.add("Ginger tea for nausea");
        homeRemedies.add("Chamomile tea for abdominal cramps");
        
        primaryTreatments.add("Oral rehydration therapy (small frequent sips)");
        primaryTreatments.add("Early refeeding with bland foods");
        
        recoveryTime = "1-3 days (viral), up to 1 week (bacterial)";
        whenToSeeDoctor = "If bloody diarrhea, "
                + "signs of severe dehydration, "
                + "or symptoms persist >3 days";
    }

    
}
