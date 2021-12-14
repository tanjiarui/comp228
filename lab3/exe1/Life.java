package exe1;

public class Life extends Insurance {
    public Life() {
        this.type = "Life Insurance";
    }

    @Override
    public void setInsuranceCost(Double cost) {
        this.monthlyCost = cost;
    }

    @Override
    public void displayInfo() {
        System.out.println("The type of insurance: "+this.getType());
        System.out.println("Monthly cost:"+this.getMonthlyCost());
    }
}