package ngordnet.ngrams;

import edu.princeton.cs.algs4.In;

import java.util.*;

import static java.lang.Integer.parseInt;

/**
 * An object that provides utility methods for making queries on the
 * Google NGrams dataset (or a subset thereof).
 * <p>
 * An NGramMap stores pertinent data from a "words file" and a "counts
 * file". It is not a map in the strict sense, but it does provide additional
 * functionality.
 *
 * @author Josh Hug
 */
// 使用自定义类型 而非嵌套的 HashMap or TreeMap来表达复杂的数据结构
class Factor {
    int year;
    int times;
    int sources;


    public Factor(int year, int times, int numSources) {
        this.year = year;
        this.times = times;
        this.sources = numSources;
    }


}
// 对应文件 total_counts.csv
class YearCount{
    float times;
    float pages;
    float sources;
    public YearCount(float times, float pages, float sources) {
        this.times = times;
        this.pages = pages;
        this.sources = sources;
    }

}

public class NGramMap {
//public class NGramMap<String, ArrayList<Factor>>{
    /**
     * Constructs an NGramMap from WORDSFILENAME and COUNTSFILENAME.
     */

    public String word;
    public ArrayList<Factor> factors;

    public HashMap<String, ArrayList<Factor>> mmap;  // 对应very_short.csv，key是word
    public HashMap<Integer, ArrayList<String>> yearMap;
    public HashMap<Integer, YearCount> yearTotalCount;


    public NGramMap(String wordsFilename, String countsFilename) {
        // very_short.csv 第2行是year,第3行是times 第4行是sources
        //total_counts.csv 年份，单词的个数，出现的页数，来源的个数
        this.mmap = new HashMap<>();
//        this.yearMap = new HashMap<>();
        this.yearTotalCount = new HashMap<>();
        In in1 = new In(wordsFilename);
        String lineStr = in1.readLine();
        while (lineStr != null) {
            String[] aa = lineStr.split("\t"); // 这里的String[] 是一个array
            lineStr = in1.readLine();
            String wordName = aa[0];
            int year=parseInt(aa[1]);
            Factor ff = new Factor(year, parseInt(aa[2]), parseInt(aa[3]));
            if (this.mmap.get(wordName) == null) {
                ArrayList<Factor> ffArrayList = new ArrayList<Factor>() {
                };
                ffArrayList.add(ff);
                this.mmap.put(wordName, ffArrayList);
            } else {
                this.mmap.get(wordName).add(ff);
            }
        }
        In in2 = new In(countsFilename);
        String lineStr2 = in2.readLine();
        while (lineStr2 != null) {
            String[] bb = lineStr2.split(",");
            Integer year = parseInt(bb[0]);
            float times=Float.parseFloat(bb[1]);
            float pages=Float.parseFloat(bb[2]);
            float sources=Float.parseFloat(bb[3]);
            if (this.yearTotalCount.get(year) == null) {
                YearCount yearCount = new YearCount(times,pages, sources);
                this.yearTotalCount.put(year,yearCount);
            } else {
                this.yearTotalCount.get(year).times+=times;
                this.yearTotalCount.get(year).pages+=pages;
                this.yearTotalCount.get(year).sources+=sources;
            }
            lineStr2 = in2.readLine();
        }
    }

    /**
     * Provides the history of WORD. The returned TimeSeries should be a copy,
     * not a link to this NGramMap's TimeSeries. In other words, changes made
     * to the object returned by this function should not also affect the
     * NGramMap. This is also known as a "defensive copy".
     */
    public TimeSeries countHistory(String word) {

        //todo defensive copy of year 是啥意思？
        TimeSeries res = new TimeSeries();
        res.years = new ArrayList<>();
        res.times = new ArrayList<>();
        for (Factor item : this.mmap.get(word)) {
            res.years.add(item.year);
            res.times.add((double) item.times);
            res.factors.add(item);
        }
        ;
        return res;
    }

    /**
     * Provides the history of WORD between STARTYEAR and ENDYEAR, inclusive of both ends. The
     * returned TimeSeries should be a copy, not a link to this NGramMap's TimeSeries. In other words,
     * changes made to the object returned by this function should not also affect the
     * NGramMap. This is also known as a "defensive copy".
     */
    public TimeSeries countHistory(String word, int startYear, int endYear) {
        TimeSeries res = new TimeSeries();
        res.years = new ArrayList<>();
        res.factors = new ArrayList<>();
        res.times = new ArrayList<>();
        for (Factor item : this.mmap.get(word)) {
            if (item.year >= startYear && item.year <= endYear) {
                res.years.add(item.year);
                res.times.add((double) item.times);
                res.factors.add(item);
            }
        }
        return res;
    }

    /**
     * Returns a defensive copy of the total number of words recorded per year in all volumes.
     */
    public TimeSeries totalCountHistory() {
        TimeSeries res = new TimeSeries();
        res.yearTotalCount=this.yearTotalCount;
        System.out.println("1865:"+this.yearTotalCount.get(1865));
        return res;

    }

    /**
     * Provides a TimeSeries containing the relative frequency per year of WORD compared to
     * all words recorded in that year.
     */
    public TimeSeries weightHistory(String word) {
        return null;
    }

    /**
     * Provides a TimeSeries containing the relative frequency per year of WORD between STARTYEAR
     * and ENDYEAR, inclusive of both ends.
     */
    public TimeSeries weightHistory(String word, int startYear, int endYear) {
        return null;
    }

    /**
     * Returns the summed relative frequency per year of all words in WORDS.
     */
    public TimeSeries summedWeightHistory(Collection<String> words) {
        return null;
    }

    /**
     * Provides the summed relative frequency per year of all words in WORDS
     * between STARTYEAR and ENDYEAR, inclusive of both ends. If a word does not exist in
     * this time frame, ignore it rather than throwing an exception.
     */
    public TimeSeries summedWeightHistory(Collection<String> words,
                                          int startYear, int endYear) {
        return null;
    }


}
