package Classes;

public class MyException extends Exception {
    int option;
    String answer;

    public MyException(int option) {
        this.option = option;
    }

    @Override
    public String getMessage(){
        switch (option){
            case 0:{
                answer = "The parameter could not be empty.";
            }
            break;
            case 1:{
                answer = "Line entered does not comply with the format. Please check: NAME=DDhh:mm,DDhh:mm,...,DDhh:mm.";
            }
            break;
            case 2:{
                answer = "Line entered does not comply with the format. First hour is bigger than second hour.";
            }
            break;
            case 3:{
                answer = "There could not be any negative hour or bigger than 24.";
            }
            break;
            default:{
                answer ="Could not identify the error.";
            }
            break;
        }
        return answer;
    }
}
