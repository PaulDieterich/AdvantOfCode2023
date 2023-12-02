
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day1{

    public static void main(String[] args){
            
        try{
            Scanner scanner = new Scanner(new File("inputFile.txt"));        
            int total = 0;
            while (scanner.hasNextLine()) {
                char[] characters = scanner.nextLine().toCharArray();
                Integer sum = 0;
                String firstNumber = "";
                String lastNumber = "";            
                boolean firstNumberFound = false;

                for(int i = 0; i < characters.length; i++){
                    if(Character.isDigit(characters[i])){
                        if(!firstNumberFound){
                            firstNumberFound = true;
                            firstNumber = String.valueOf(characters[i]);
                            lastNumber = String.valueOf(characters[i]); 
                        }else{
                            lastNumber = String.valueOf(characters[i]);
                        }
                    }
                    
                }
                sum = Integer.parseInt(firstNumber+""+lastNumber);
                total += sum;        
            }
            scanner.close();
            System.out.println(total);
        
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
    } 

}