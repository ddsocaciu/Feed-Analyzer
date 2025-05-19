package TGMSEWFeedAnalyzer;
import java.io.*;
import java.util.*;
import java.util.HashMap;
import java.util.HashSet;

public class Utility {

    public double analyzeText(String text) {
        double gesamtscore = 0;
        Set<String> stopSet = new HashSet<>();
        Map<String, Double> vaderMap = new HashMap<>();
        try(BufferedReader br = new BufferedReader(new FileReader("./Resources/SmartStoplist.txt"))){
            String line;
            while ((line = br.readLine()) != null) {
                stopSet.add(line);
            }
        }catch(IOException e){
            e.printStackTrace();
        }

        try(BufferedReader br = new BufferedReader(new FileReader("./Resources/vader_lexicon.txt"))){
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\t");
                vaderMap.put(parts[0], Double.parseDouble(parts[1]));
            }
        }catch(IOException e){
            e.printStackTrace();
        }


        String[] textAbstand = text.split(" ");
        for(String s : textAbstand){
            if(vaderMap.containsKey(s) && !stopSet.contains(s)){
                gesamtscore += vaderMap.get(s);
            }
        }
        return gesamtscore;
    }
}
