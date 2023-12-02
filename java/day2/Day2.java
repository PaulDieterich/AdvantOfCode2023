import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Day2{

    
    public static void main(String[] args){
        System.out.println(part1());
        System.out.println(part2());
    }
    


    private static int part1(){
    
            Map<String,Integer> color = createColorBag();
            List<String> lines = readLines(new File("C:\\Users\\pjd\\Documents\\AdvantOfCode2023\\java\\day2\\inputFile.txt"));
            int sum = 0;
            for(String l : lines){
                boolean okay = true;
                String id = l.substring(l.indexOf(" "),l.indexOf(":")).trim();
                String[] bags = l.split(";");
                bags[0] = bags[0].split(":")[1];
                for(String hand: bags){
                    for(String c: hand.split(",")){
                        String[] sub = c.trim().split(" ");
                        if(color.get(sub[1]) < Integer.parseInt(sub[0])){
                            okay = false;
                        }
                    } 
                }
                if(okay){
                    sum += Integer.parseInt(id);
                }
            }
            return sum;

    }


    private static Map<String, Integer> createColorBag(){
        Map<String,Integer> color = new HashMap<>();
          color.put("red",12);
          color.put("green",13);
          color.put("blue",14);
          return color; 
    } 
    private static int part2(){
        List<String> lines = readLines(new File("C:\\Users\\pjd\\Documents\\AdvantOfCode2023\\java\\day2\\inputFile.txt"));
        int sum = 0;
        for(String l : lines){
            Map<String, Integer> colors = new HashMap<>();
                String[] bags = l.split(";");
                bags[0] = bags[0].split(":")[1];
                for(String hand: bags){
                    for(String c: hand.split(",")){
                        String[] sub = c.trim().split(" ");
                        if(!colors.containsKey(sub[1]) || colors.get(sub[1]) < Integer.parseInt(sub[0])){
                           colors.put(sub[1], Integer.parseInt(sub[0]));
                        }
                    }
                }  
                sum+= colors.values().stream().mapToInt(Integer::intValue).reduce(1, (a,b) -> a *b);
            }       
            return sum; 
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