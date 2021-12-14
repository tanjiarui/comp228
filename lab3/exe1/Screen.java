package exe1;

import java.util.ArrayList;
import java.util.Scanner;

public class Screen {
    public static void main(String[] args) {
        ArrayList<Insurance> insurances = new ArrayList<>();
        int number = 0;
        while (true){
                System.out.println("Please enter the number of insurance");
                Scanner scanner = new Scanner(System.in);
                try {
                    number = scanner.nextInt();
                    break;
                }
                catch (Exception e){
                    System.out.println("Your input is wrong! Please enter the number of insurance");
                }
        }
        for (int i = 0;i < number;i++){
            int type ;
            Scanner scanner = new Scanner(System.in);
            while (true){
                System.out.println("Please choose the type of insurance:\n1.health insurance\n2.life insurance");
                try {
                    type = scanner.nextInt();
                    if (type==1){
                        insurances.add(new Health());
                        break;
                    }else if (type == 2){
                        insurances.add(new Life());
                        break;
                    }else {
                        System.out.println("Your input is wrong! Please choose 1 or 2");
                    }
                }
                catch (Exception e){
                    scanner.next();
                    System.out.println("Your input is wrong! Please choose 1 or 2");
                }
            }
            while (true){
                System.out.println("Please enter the monthly cost");
                double cost;
                try {
                    cost = scanner.nextDouble();
                    insurances.get(i).setInsuranceCost(cost);
                    break;
                }
                catch (Exception e){
                    scanner.next();
                    System.out.println("Your input is wrong! Please enter number");
                }
            }
        }
        System.out.println("Display the information of all insurance");
        for (int n = 0;n<number;n++){
            System.out.println(n+1+"—————");
            insurances.get(n).displayInfo();
        }
    }
}