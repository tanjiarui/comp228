package exe2;

import java.util.Scanner;

public class JOptionPane {
    public void showGameRule(){
        System.out.print("Please chooses a number between 3 and 27.\n");
    }

    public static void main(String[] args) {
        JOptionPane jOptionPane = new JOptionPane();
        for (int i=0;i < 5;i++){
            jOptionPane.showGameRule();
            Lotto lotto = new Lotto();
            //peek lotto
//            int []lottoNum = lotto.getLottoNum();
//            for (int x:lottoNum) {
//                System.out.println(x);
//            }
            Scanner scanner = new Scanner(System.in);
            if (scanner.hasNextInt()) {
                int answer = scanner.nextInt();
                if (answer>=3 && answer<=27){
                    lotto.setUserAnswer(answer);
                    if(lotto.check()) {
                        scanner.close();
                        break;
                    }
                }
            }
        }
    }
}