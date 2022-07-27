import java.util.*;
import java.io.*;
public class TextSummarizer {
    static String text;
    static String sentences[];
    static List<List<String>> filteredSentences;
    static HashSet<String> stopWords;
    static List<HashMap<String,Integer>> tf;
    static HashSet<String> uniqueWords;
    static HashMap<String,Integer> df;
    static HashMap<String,Double> idf;
    static List<Double> score;
    static List<Integer> storeResult;
    static double thresholdScore;

    public static void generatingStopWords() {
        stopWords = new HashSet<>();
        String[] stop = {"i", "me", "my", "myself", "we", "us", "our", "ours", "ourselves",
                "you", "your", "yours", "yourself", "yourselves", "he", "him", "his",
                "himself", "she", "her", "hers", "herself", "it", "its", "itself",
                "they", "them", "their", "theirs", "themselves", "what", "which",
                "who", "whom", "this", "that", "these", "those", "am", "is", "are",
                "was", "were", "be", "been", "being", "have", "has", "had", "having",
                "do", "does", "did", "doing", "would", "should", "could", "ought",
                "i'm", "you're", "he's", "she's", "it's", "we're", "they've", "i've",
                "you've", "we've", "they've", "i'd", "you'd", "he'd", "she'd", "we'd",
                "they'd", "i'll", "you'll", "he'll", "she'll", "we'll", "they'll",
                "isn't", "aren't", "wasn't", "weren't", "hasn't", "haven't", "hadn't",
                "doesn't", "don't", "didn't", "won't", "wouldn't", "can't", "cannot",
                "couldn't", "mustn't", "let's", "that's", "who's", "what's", "here's",
                "there's", "when's", "where's", "why's", "how's", "a", "an", "the",
                "and", "but", "if", "or", "because", "as", "until", "while", "of", "at",
                "by", "for", "with", "about", "against", "between", "into", "through",
                "during", "before", "after", "above", "below", "to", "from", "up", "down",
                "in", "out", "on", "off", "over", "under", "again", "further", "then",
                "once", "here", "there", "when", "where", "why", "how", "all", "any",
                "both", "each", "few", "more", "most", "other", "some", "such", "no",
                "nor", "not", "only", "own", "same", "so", "than", "too", "very"};
        stopWords.addAll(Arrays.asList(stop));
        //System.out.println(stopWords);
    }

    public static void splitSentences() {
        sentences = text.split("[.?!]");
        for(int i = 0; i < sentences.length ; i++) {
            sentences[i] = sentences[i].trim();
            //System.out.println(sentences[i]);
        }
    }

    public static void removeStopWords() {
        filteredSentences = new ArrayList<>();
        for(String sentence : sentences) {
            List<String> l = new ArrayList<>();
            String[] words = sentence.split("[ ,]");
            for(String word : words) {
                if(!stopWords.contains(word)) {
                    l.add(word);
                }
            }
            filteredSentences.add(l);
        }
        //verify
//        for(List<String> l:filteredSentences)
//            System.out.println(l);
    }

    public static void getTermFreq() {
        tf = new ArrayList<>();
        for(List<String> l : filteredSentences) {
            HashMap<String,Integer> hm = new HashMap<>();
            for(String word : l) {
                hm.put(word , hm.getOrDefault(word,0) + 1);
            }
            tf.add(hm);
        }
        //verify
//        for(HashMap<String,Integer> hm:tf)
//        {
//            for(Map.Entry m:hm.entrySet())
//            {
//                String s=(String)m.getKey();
//                int val=(int) m.getValue();
//                System.out.print(s+"= "+val+" ; ");
//            }
//            System.out.println();
//        }
    }

    public static void getUniqueWords() {
        uniqueWords = new HashSet<>();
        for(List<String> l : filteredSentences) {
            for(String word : l)
                uniqueWords.add(word);
        }
        //verify
//        for(String s:uniqueWords)
//            System.out.println(s);
    }

    public static void getDocumentFreq() {
        df = new HashMap<>();
        for(String word : uniqueWords) {
            int count = 0;
            for(List<String> l : filteredSentences) {
                if(l.contains(word))
                    count++;
            }
            df.put(word , count);
        }
        //verify
//        for(Map.Entry m:df.entrySet())
//        {
//            String s=(String)m.getKey();
//            int count=(int)m.getValue();
//            System.out.println(s+" = "+count);
//        }

    }

    public static void getInverseDocumentFreq() {
        idf = new HashMap<>();
        for(String word : uniqueWords) {
            idf.put(word , Math.log((double)filteredSentences.size()/(double)df.get(word)));
        }
        //verify
//        for(Map.Entry m:idf.entrySet())
//        {
//            String s=(String)m.getKey();
//            double val=(double)m.getValue();
//            System.out.println(s+" = "+val);
//        }
    }

    public static void getSentenceScore() {
        score = new ArrayList<>();
        for(int i = 0 ; i < filteredSentences.size() ; i++) {
            List<String> s = filteredSentences.get(i);
            double scr = 0.0;
            for(String word : s) {
                scr += tf.get(i).get(word) * idf.get(word);
            }
            score.add(scr/s.size()); // normalized threshold score
        }
        //verify
//        for(Custom d:score)
//            System.out.println(d.score);
    }

    public static void getThresholdScore() {
        thresholdScore = 0.0;
        for(double scr : score) {
            thresholdScore += scr;
        }
        thresholdScore /= (double)filteredSentences.size(); // finding avg
    }

    public static void getResult() {
        String summary = "";
        int countWordsPrinted = 0;
        int countSentencesInSummary = 0;
        for(int i = 0; i < filteredSentences.size() ; i++) {
            double scr = score.get(i);
            if(scr >= thresholdScore) {
                countSentencesInSummary++;
                String[] words = sentences[i].split("[ ,]");
                for(String word : words){
                    summary += word+" ";
                    countWordsPrinted++;
                    if(countWordsPrinted == 16){
                        countWordsPrinted = 0;
                        summary += "\n";
                    }
                }
            }
        }
        System.out.println("Original Passage :-\n\n");
        //System.out.println(text+"\n");
        for(char ch : text.toCharArray()){
            if(ch == '.'){
                System.out.print(".\n");
            }
            else{
                System.out.print(ch);
            }
        }


        System.out.println("\n\nSummary :- \n");
        System.out.println(summary+"\n\n");
        System.out.println("Sentences in Original passage = "+filteredSentences.size());
        System.out.println("Sentences in summary = " + countSentencesInSummary);
        double reduced = 100.0* (filteredSentences.size() - countSentencesInSummary)/filteredSentences.size() ;
        System.out.println("% sentences reduced = "+ reduced +" %");
    }

    public static void main(String args[])throws IOException {
        //reading text from source inputText.txt file
        FileInputStream in = new FileInputStream("src/inputText.txt");
        Scanner sc = new Scanner(in);
        text = "";

        //taking input from the text file
        while(sc.hasNextLine()){
            text += sc.nextLine();
        }

        //generating the stopwords
        generatingStopWords();

        //splitting the text into sentences.
        splitSentences();

        //removing stopwords from the sentences
        removeStopWords();

        //finding all the unique words in the document from filteredSentences
        getUniqueWords();

        //calculate the number of sentences in which each word appears, in the entire document
        getDocumentFreq();

        //calculate term frequency of each sentence.
        getTermFreq();

        //calculate idf
        getInverseDocumentFreq();

        //calculate score of each sentence
        getSentenceScore();

        //find the threshold score
        getThresholdScore();

        //get the sentences with score more than the threshold score
        getResult();

    }
}
