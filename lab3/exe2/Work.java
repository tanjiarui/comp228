package exe2;

import java.util.Scanner;

public class Work {
    public static void main(String[] args) {
        int type;
        float time;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Please choose the type of game testers:\n1.Full-time\n2.Part-time");
            System.out.println("Or choose 3 to exit");
            try {
                type = scanner.nextInt();
                if (type == 1) {
                    FullTimeGameTester gameTester = new FullTimeGameTester();
                    System.out.println("You are a full time game tester.Your salary is " + gameTester.getSalary());
                } else if (type == 2) {
                    PartTimeGameTester gameTester = new PartTimeGameTester();
                    System.out.println("Please enter your working time by hour");
                    while (true) {
                        if (scanner.hasNextFloat()) {
                            time = scanner.nextFloat();
                            gameTester.setTime(time);
                            System.out.println("You are a part time game tester.Your salary is " + gameTester.getSalary());
                            break;
                        } else {
                            scanner.next();
                            System.out.println("Please enter your working time by hour");
                        }
                    }
                } else if (type == 3) {
                    break;
                } else {
                    System.out.println("Your input is wrong! Please choose 1 or 2 or 3");
                }
            } catch (Exception e) {
                scanner.next();
                System.out.println("Your input is wrong! Please choose 1 or 2 or 3");
            }
        }
    }
}