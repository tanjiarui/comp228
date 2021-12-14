package exe1;

import java.util.Random;
import java.util.Scanner;

public class Test {
    private static int correct;
    private int sum;
    private static JOptionPane jOptionPane = new JOptionPane();
    public static void main(String []args){
        Test test = new Test();
        test.inputAnswer();
    }

    public Test() {
        sum = jOptionPane.getQuestion().length;
        correct =0;
    }

    private static boolean checkAnswer(String answer, int questionID){
        if (answer.length() == 1){
            char correctAnswer = Test.jOptionPane.getAnswer()[questionID];
            char userAnswer = answer.charAt(0);
            return correctAnswer == Character.toUpperCase(userAnswer);
        }
        return false;
    }

    private static String generateMessage(String answer, int questionID){
        Random random = new Random();
        if(checkAnswer(answer,questionID)){
            correct++;
            switch ( random.nextInt( 4 ) )
            {
                case 0:
                    return( "Excellent" );
                case 1:
                    return ("Good");
                case 2:
                    return ("Keep up the good work!");
                case 3:
                    return ("Nice work!");
            }
        }else {
            switch ( random.nextInt( 4 ) )
            {
                case 0:
                    return( "No. Please try again" );
                case 1:
                    return ("Wrong. Try once more");
                case 2:
                    return ("Don't give up!");
                case 3:
                    return ("No. Keep trying.");
            }
        }
        return "Error";
    }

    private void inputAnswer(){
        for (int i=0;i<this.sum;i++){
            Test.jOptionPane.showQuestion(i);
            Scanner scanner = new Scanner(System.in);
            String answer = scanner.next();
            System.out.println(generateMessage(answer,i));      
        }
        float rate = (float) correct/this.sum*100;
        int incorrect = this.sum- correct;
        System.out.println("The number of correct answers is "+ correct+
                ". The number of incorrect answers is "+incorrect+
                ". The percentage of the correct answers is "+rate+"%.");
    }
}