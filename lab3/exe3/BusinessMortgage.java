package exe3;

public class BusinessMortgage extends Mortgage {
    public BusinessMortgage() {
        this.rate = 1.01 * currentRate;
    }
}