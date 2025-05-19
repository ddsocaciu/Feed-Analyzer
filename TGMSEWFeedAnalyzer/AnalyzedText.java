package TGMSEWFeedAnalyzer;

public class AnalyzedText implements Comparable<AnalyzedText>{

    private String text;
    private double sentiment;

    public void AnalyzedText(String text) {
        if(!text.equals("")){
            this.text = text;
        }else{
            this.text = "mahrhofer";
        }
    }

    public String getText() {
        return text;
    }

    public double getSentiment(){
        return sentiment;
    }

    @Override
    public int compareTo(AnalyzedText o) {
        if(o == null){
            return -1;
        }
        if(this.equals(o)){
            return 0;
        }
        int ret = this.text.compareTo(o.text);
        if(ret != 0){
            return ret;
        }
        ret = (int) (this.sentiment - o.sentiment);
        if(ret != 0){
            return ret;
        }
        return 0;
    }

    @Override
    public String toString() {
        String txt = "";
        txt+= "Text: " +getText()+", Sentiment:" +getSentiment();
        return txt;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj){
            return true;
        }
        if(obj == null){
            return false;
        }
        if(this.getClass() != obj.getClass()){
            return false;
        }
        AnalyzedText other = (AnalyzedText) obj;
        if(this.text == null) {
            if(other.text != null){
                return false;
            }
        }else if(!this.text.equals(other.text)){
            return false;
        }
        if(this.sentiment != other.sentiment){
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int prime = 31;
        int result = 1;
        result = prime * result + ((text == null) ? 0 : text.hashCode());
        result = prime * result + (int) sentiment;
        return result;
    }
}
