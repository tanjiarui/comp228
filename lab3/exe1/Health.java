package exe1;

public class Health extends Insurance {

    public Health() {
        this.type = "Health Insurance ";
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