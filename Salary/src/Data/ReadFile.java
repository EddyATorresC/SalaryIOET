package Data;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadFile {

    private Scanner file;
    private String path;
    private ArrayList<String> data;

    public ReadFile(String path) {
        this.path=path;
        data =  new ArrayList();
    }

    public void openFile(){
        try{
            file =  new Scanner(new File(path));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public ArrayList<String> readFile(){

        while(file.hasNext()){
            data.add(file.nextLine());
        }
        return data;
    }

    public void closeFile(){
        file.close();
    }
}
