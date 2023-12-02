import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Day2{

    
    public static void main(String[] args){
            Map<String,Integer> color = new HashMap<>();
            color.put("red",12);
            color.put("green",13);
            color.put("blue",14);
            List<String> lines = readLines(new File("C:\\Users\\pjd\\Documents\\AdvantOfCode2023\\java\\day2\\inputFile.txt"));
            
            int sum = 0;
            for(String l : lines){
                
                boolean okay = true;
                String id = l.substring(l.indexOf(" "),l.indexOf(":")).trim();
                String[] bags = l.split(";");
                bags[0] = bags[0].split(":")[1];
                for(String hand: bags){
                    for(String c: hand.split(",")){
                        String zahl = c.substring(0,l.indexOf(" ")-1).trim();
                        String cubeColor = c.substring(c.lastIndexOf(" ")).trim();
                        if(color.get(cubeColor) < Integer.parseInt(zahl)){
                            okay = false;
                        }
                    } 
                }
                if(okay){
                    sum += Integer.parseInt(id);
                }
            }
            System.out.println(sum);
    }
    
    
    
    private static List<String> readLines(File file){
        List<String> lines = new ArrayList<>();
       
        try{
            Scanner scanner = new Scanner(file);        
            while (scanner.hasNextLine()) {        
                lines.add(scanner.nextLine());
            }
            scanner.close();
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
        return lines; 
        }

} 