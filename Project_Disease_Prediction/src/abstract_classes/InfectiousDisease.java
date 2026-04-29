package abstract_classes;

public abstract class InfectiousDisease extends AbstractDisease {
    protected String transmissionMethod;
    protected boolean isContagious;
    protected String incubationPeriod;

    public String getTransmissionMethod() { return transmissionMethod; }
    public boolean isContagious() { return isContagious; }
    public String getIncubationPeriod() { return incubationPeriod; }
}