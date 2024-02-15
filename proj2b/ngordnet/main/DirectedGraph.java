package ngordnet.main;

import ngordnet.ngrams.NGramMap;
import ngordnet.ngrams.TimeSeries;

public class DirectedGraph {
    public static void main(String[] args) {
        String wordFile = "./data/ngrams/top_49887_words.csv";
        String countFile = "./data/ngrams/total_counts.csv";
        NGramMap ngm= new NGramMap(wordFile, countFile);
        TimeSeries ts = ngm.countHistory("acreage", 1771, 1801);
        System.out.println(ts.data());
        System.out.println(ts.years());
    }
}
