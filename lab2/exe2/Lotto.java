package exe2;

import java.util.Random;

public class Lotto {
    private int[] lottoNum;
    private int userAnswer;
    public Lotto(){
        Random random = new Random();
        lottoNum = new int[3];
        for (int count = 0;count < 3;count++) {
            lottoNum[count] = random.nextInt(9)+1;
        }
    }

    public int getUserAnswer() {
        return userAnswer;
    }

    public void setUserAnswer(int userAnswer) {
        this.userAnswer = userAnswer;
    }

    public int[] getLottoNum() {
        return lottoNum;
    }

    public void setLottoNum(int[] lottoNum) {
        this.lottoNum = lottoNum;
    }

    public boolean check(){
        int sum = 0;
        for (int num:lottoNum) {
            sum = sum+num;
        }
        if (userAnswer == sum){
            System.out.println("You win");
            return true;
        }
        System.out.println("Computer win");
        return false;
    }
}