package Logic;

import Classes.MyException;

public class WeekLogic {
    private float rate1;
    private float rate2;
    private float rate3;
    int i;
    int length;
    float value;
    boolean flag;

    public WeekLogic() {
        i=0;
        length = 0;
        value = 0;
        flag = false;
    }

    public float toBePaid(String pSource){
        String[] hours = pSource.split(",");
        length = hours.length;
        try{
            for (i = 0; i < length; i++) {
                if (!hours[i].startsWith("MO") && !hours[i].startsWith("TU") && !hours[i].startsWith("WE") &&
                        !hours[i].startsWith("TH") && !hours[i].startsWith("FR") && !hours[i].startsWith("SA") &&
                        !hours[i].startsWith("SU")) {
                    throw new MyException(1);
                }else {
                    if(hours[i].charAt(0) == 'M' || hours[i].charAt(0) == 'T' || hours[i].charAt(0) == 'W'
                            || hours[i].charAt(0) == 'F'){
                        rate1 = 25;
                        rate2 = 15;
                        rate3 = 20;
                        float temp = calculatePayment(hours[i]);
                        if(!flag) {
                            value += temp;
                        }else{
                            length = i;
                            value = 0;
                        }
                    }
                    if(hours[i].charAt(0) == 'S'){
                        rate1 = 30;
                        rate2 = 20;
                        rate3 = 25;
                        float temp = calculatePayment(hours[i]);
                        if(!flag) {
                            value += temp;
                        }else{
                            length = i;
                            value = 0;
                        }
                    }
                }

            }
        }catch (MyException e){
            System.out.println(e.getMessage());
        }
        return value;
    }

    public float calculatePayment(String pSource){

        float hours1;
        float hours2;

        float interval1 = 0;
        float interval2 = 0;
        float interval3 = 0;

        float totalHours=0;
        try{
            char temp[] = new char[4];
            temp[0] = pSource.charAt(2);
            temp[1] = pSource.charAt(3);
            temp[2] = pSource.charAt(5);
            temp[3] = pSource.charAt(6);
            String concatenate = new StringBuilder().append(pSource.charAt(2)).append(pSource.charAt(3)).toString();
            String concatenateMin = new StringBuilder().append(pSource.charAt(5)).append(pSource.charAt(6)).toString();
            hours1 = Float.parseFloat(concatenate)+ Float.parseFloat(concatenateMin)/60;

            char temp1[] = new char[4];
            temp1[0] = pSource.charAt(8);
            temp1[1] = pSource.charAt(9);
            temp1[2] = pSource.charAt(11);
            temp1[3] = pSource.charAt(12);
            String concatenate1 = new StringBuilder().append(pSource.charAt(8)).append(pSource.charAt(9)).toString();
            String concatenateMin1 = new StringBuilder().append(pSource.charAt(11)).append(pSource.charAt(12)).toString();
            hours2 = Float.parseFloat(concatenate1)+ Float.parseFloat(concatenateMin1)/60;
            if((hours1>24 || hours1<0) || (hours2>24 || hours2<0)){
                totalHours=0;
                throw new MyException(3);
            }else {
                if (hours1 > hours2) {
                    throw new MyException(2);
                } else {
                    if (hours2 == 0) {
                        hours2 = 24;
                    }

                    if ((hours1 >= 0 && hours1 <= 9) && ((hours2 > 0) && (hours2 <= 9))) {
                        hours1 = 9 - hours1;
                        hours2 = 9 - hours2;

                        interval1 = hours1 - hours2;
                    }
                    if ((hours1 > 9 && hours1 <= 18) && ((hours2 > 9) && (hours2 <= 18))) {
                        hours1 = 18 - hours1;
                        hours2 = 18 - hours2;

                        interval2 = hours1 - hours2;
                    }
                    if ((hours1 > 18 && hours1 <= 24) && ((hours2 > 18) && (hours2 <= 24))) {
                        hours1 = 24 - hours1;
                        hours2 = 24 - hours2;
                        interval3 = hours1 - hours2;
                    }

                    if ((hours1 >= 0 && hours1 <= 9) &&
                            ((hours2 > 9))) {
                        interval1 = 9 - hours1;
                    }
                    if ((hours1 > 9 && hours1 <= 18) &&
                            ((hours2 > 18) || (hours2 < 9))) {
                        interval2 = 18 - hours1;
                    }
                    if ((hours1 > 18 && hours1 <= 24) &&
                            ((hours2 < 18))) {
                        interval3 = 24 - hours1;
                    }


                    if (hours2 > 9 && hours2 <= 18 &&
                            (hours1 <= 9) || (hours1 > 18)) {
                        interval2 = hours2 - 9;

                    }
                    if (hours2 > 18 && hours2 <= 24 &&
                            ((hours1 <= 18))) {
                        interval3 = hours2 - 18;
                    }


                    if (interval1 != 0 && interval3 != 0) {
                        interval2 = 9;
                    }

                    totalHours = interval1 * rate1 + interval2 * rate2 + interval3 * rate3;
                }
            }
        }catch (MyException e){
            flag = true;
            System.out.println(e.getMessage());
        }catch (NumberFormatException e){
            flag = true;
            System.out.println("Line entered does not satisfy the format hh:mm-hh:mm");
        }catch (Exception e){
            flag = true;
            System.out.println("Possible format error. Please check format: NAME=DDhh:mm,DDhh:mm,...,DDhh:mm.");
        }

        return totalHours;
    }
}
