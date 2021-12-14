package exe3;

import java.util.ArrayList;
import java.util.Scanner;

public class ProcessMortgage {
    public static void main(String[] args) {
        ArrayList<Mortgage> mortgages = new ArrayList<>();
        double currentRate;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Please enter a number as your current rate");
            try {
                currentRate = scanner.nextDouble();
                break;
            }catch (Exception e){
                scanner.next();
            }
        }
        Mortgage.setCurrentRate(currentRate);
        for (int i =0;i<3;i++) {
            Mortgage mortgage;
            System.out.println("Please choose the type of mortgages:\n1. Business Mortgage\n2. Personal Mortgage");
            while (true) {
                try {
                    int type = scanner.nextInt();
                    if (type == 1){
                        mortgage = new BusinessMortgage();
                        break;
                    }else if(type == 2){
                        mortgage = new PersonalMortgage();
                        break;
                    }else {
                        scanner.next();
                        System.out.println("Please choose 1 or 2");
                    }
                }catch (Exception e){
                    scanner.next();
                    System.out.println("Please choose 1 or 2");
                }
            }
            System.out.println("Please enter the number of mortgage unit");
            String mortgageNum = scanner.next();
            mortgage.setMortgageNumber(mortgageNum);
            System.out.println("Please enter customer name");
            String name = scanner.next();
            mortgage.setCustomerName(name);
            System.out.println("Please enter the amount of mortgage");
            while (true) {
                try {
                    double amount = scanner.nextDouble();
                    if(mortgage.setAmount(amount)){
                        break;
                    }else {
                        System.out.println("mortgage amounts is over $300,000, please try again");
                    }
                } catch (Exception e) {
                    scanner.next();
                    System.out.println("Please enter the amount of mortgage");
                }
            }
            System.out.println("Please choose term.\n1. short-term (one year)\n2. medium-term (three years)\n3. long-term (five years)");
            while (true) {
                try {
                    int type = scanner.nextInt();
                    if (type == 1){
                        mortgage.setTerm(MortgageConstants.shortTerm);
                        break;
                    }else if(type == 2){
                        mortgage.setTerm(MortgageConstants.mediumTerm);
                        break;
                    }else if(type ==3){
                        mortgage.setTerm(MortgageConstants.mediumTerm);
                        break;
                    }else {
                        scanner.next();
                        System.out.println("Please choose 1 or 2 or 3");
                    }
                }catch (Exception e){
                    scanner.next();
                    System.out.println("Please choose 1 or 2 or 3");
                }
            }
            mortgages.add(mortgage);
        }
        for (Mortgage m:mortgages) {
            m.getMortgageInfo();
        }
    }
}