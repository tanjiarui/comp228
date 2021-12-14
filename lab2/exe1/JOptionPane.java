package exe1;

public class JOptionPane {
    private String [] question;
    private String [] options;
    private char [] answer ;

    public JOptionPane() {
        question = new String[5];
        options =  new String[5];
        answer = new char[]{'C','C','C','A','D'};
        question[0] = "1.\tWhich of the following typically groups related classes so that they could be imported into programs and reused?";
        options[0] = "A: Function\n" + "B: Method\n" + "C: Package\n" + "D: IDE\n";
        question[1] = "2.\tWhich of the following statements is false about Java method statements?";
        options[1] = "A: Statements in a method body determine the behavior of an object.\n" +
                "B: Statements in a method body use existing classes and methods as building blocks to create new programs.\n" +
                "C: Statements in a method body are not hidden from other methods.\n" +
                "D: Statements in a method body is written only once\n";
        question[2] = "3.\tMethod arguments may be";
        options[2] = "A: only constants.\n" +
                "B: only variables\n" +
                "C: constants, variables, or expressions.\n" +
                "D: only strings.\n";
        question[3] = "4.\tWhat does Math static method Math.ceil(x) do?";
        options[3] = "A: Round x to the smallest integer not less than x\n" +
                "B: Rounds x to it is absolute value.\n" +
                "C: Rounds x to the smallest integer smaller than x.\n" +
                "D: Rounds x to the largest integer not greater than x.\n";
        question[4] = "5.\tThere are variables for which each object of a class does not need its own separate copy. They are called";
        options[4] = "A: constants\n" +
                "B: local variables\n" +
                "C: instance variables\n" +
                "D: class variables\n";
    }

    public String[] getQuestion() {
        return question;
    }

    public void setQuestion(String[] question) {
        this.question = question;
    }

    public String[] getOptions() {
        return options;
    }

    public void setOptions(String[] options) {
        this.options = options;
    }

    public char[] getAnswer() {
        return answer;
    }

    public void setAnswer(char[] answer) {
        this.answer = answer;
    }

    public void showAllQuestion(){
        int num = question.length;
        for (int i=0;i<num;i++){
            System.out.println(question[i]);
            System.out.println(options[i]);
        }
    }
    public void showQuestion(int num){
        int max = question.length;
        if ( num >=0 & num < max){
            System.out.println(question[num]);
            System.out.println(options[num]);
        }
        else {
            System.out.println("The number of question is error");
        }
    }
}