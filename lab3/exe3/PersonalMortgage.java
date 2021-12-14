package exe3;

public class PersonalMortgage extends Mortgage {
    public PersonalMortgage() {
        this.rate = 1.02 * currentRate;
    }
}