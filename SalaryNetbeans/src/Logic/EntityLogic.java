package Logic;

import Classes.Entity;
import Classes.MyException;

import Data.ReadFile;
import Data.WriteFile;

import java.util.ArrayList;

public class EntityLogic {
    private WeekLogic weekLogic;
    private WriteFile writeFile;

    public EntityLogic() {
        weekLogic = new WeekLogic();
        writeFile = new WriteFile();
    }

    public boolean calculateSalary(String pSource) {
        boolean flag = true;
        try {
            if (pSource.isEmpty()) {
                throw new MyException(0);
            } else {
                String[] nameAndHours;
                nameAndHours = pSource.split("=");

                if (nameAndHours.length != 2) {
                    throw new MyException(1);
                } else {
                    float temp = weekLogic.toBePaid(nameAndHours[1]);
                    if(temp!=0){
                        System.out.println("The amount to pay " + nameAndHours[0]+ " is: "+ temp);
                        //writeFile.openFile();
                        writeFile.addRecords(pSource);
                        writeFile.closeFile();
                        flag = true;
                    }
                }
            }
        }catch(MyException e){
            System.out.println(e.getMessage());
        }
        return flag;
    }
    private void askSalary(String pSource){
        try {
            if (pSource.isEmpty()) {
                throw new MyException(0);
            } else {
                String[] nameAndHours;
                nameAndHours = pSource.split("=");

                if (nameAndHours.length != 2) {
                    throw new MyException(1);
                } else {
                    System.out.println("The amount to pay " + nameAndHours[0]+ " is: "+
                            weekLogic.toBePaid(nameAndHours[1]));
                }
            }
        }catch(MyException e){
            System.out.println(e.getMessage());
        }
    }
    public void search(String pSource){
        ReadFile readFile = new ReadFile("data.txt");
        readFile.openFile();
        ArrayList<String> salaries = readFile.readFile();
        readFile.closeFile();
        for (int i = 0; i< salaries.size(); i++){
            String[] temp = salaries.get(i).split("=");
            if(pSource.toUpperCase().compareTo(temp[0].toUpperCase()) == 0){
                weekLogic = new WeekLogic();
                askSalary(salaries.get(i));
            }
        }
    }
}
