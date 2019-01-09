package Data;

import java.io.*;

public class WriteFile {
    File file;
    FileWriter fileWriter;
    BufferedWriter bufferedWriter;
    PrintWriter printWriter;

    public WriteFile() {
        file = new File("data.txt");
        try {
            fileWriter = new FileWriter(file,true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        bufferedWriter = new BufferedWriter(fileWriter);
        printWriter = new PrintWriter(bufferedWriter);
    }

    public void openFile(){
        try{
            if (file.exists() == false){
                file.createNewFile();
                System.out.println("The file has been created.");
            }else{
                System.out.println("The file already exists.");
            }

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void addRecords(String pSource){
        printWriter.println(pSource);
    }

    public void closeFile(){
        printWriter.close();
    }

}
