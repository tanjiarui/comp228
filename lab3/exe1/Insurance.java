package exe1;

public abstract class Insurance {
    public String type;
    public double monthlyCost;

    public String getType() {
        return type;
    }

    public double getMonthlyCost() {
        return monthlyCost;
    }
    public  abstract void setInsuranceCost(Double cost);

    public abstract  void displayInfo();
}