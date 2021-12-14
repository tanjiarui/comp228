package exe3;

public abstract class Mortgage implements MortgageConstants {
    public String mortgageNumber;
    public String customerName;
    public double amount;
    public static double currentRate;
    public double rate;
    public String term = this.shortTerm;

    public String getMortgageNumber() {
        return mortgageNumber;
    }

    public void setMortgageNumber(String mortgageNumber) {
        this.mortgageNumber = mortgageNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public double getAmount() {
        return amount;
    }

    public boolean setAmount(double amount) {
        if(amount<this.maxAmount) {
            this.amount = amount;
            return true;
        }else {
            return false;
        }
    }

    public static double getCurrentRate() {
        return currentRate;
    }

    public static void setCurrentRate(double currentRate) {
        Mortgage.currentRate = currentRate;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public void getMortgageInfo(){
        System.out.println("mortgage numbe:"+this.mortgageNumber);
        System.out.println("customer name:"+this.customerName);
        System.out.println("amount of mortgage:"+this.mortgageNumber);
        System.out.println("interest rate:"+this.rate);
        System.out.println("term:"+this.term);
    }
}