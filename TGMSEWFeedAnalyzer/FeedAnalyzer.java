package TGMSEWFeedAnalyzer;
import java.io.*;
import java.util.*;

public class FeedAnalyzer {
    public static void main(String[] args) {
        Map<AnalyzedText, String> analyseMap = new HashMap<>();
        double gesamtscore = 0;
        try(BufferedReader br = new BufferedReader(new FileReader("./Resources/potus_tweets_2017_webarchive_publicaccess.csv"))){
            String line;
            while ((line = br.readLine()) != null) {
                AnalyzedText at = new AnalyzedText(line);
                Utility utility = new Utility();
                gesamtscore += utility.analyzeText(at.getText());
                analyseMap.put(at, "Potus");

            }
        }catch(IOException e){
            e.printStackTrace();
        }

        System.out.println(gesamtscore);
    }
}
