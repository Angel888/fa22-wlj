package ngordnet.ngrams;

import edu.princeton.cs.algs4.In;

import java.util.*;
//todo 帮我改改 不知道哪里有问题 我觉得你比chatgpt写得好
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

public class NGramMap<String, ArrayList<Factor>>{
/**
 * Constructs an NGramMap from WORDSFILENAME and COUNTSFILENAME.
 */

public static String word;
public static ArrayList<Factor> factors;

public static class Factor {
    int year;
    int times;
    int sources;

    public Factor(int year, int times, int numSources) {
        this.year = year;
        this.times = times;
        this.sources = numSources;
    }


}


public NGramMap(String wordsFilename, String countsFilename) {
    // very_short.csv第3行是times 第4行是sources
    //total_counts.csv 年份，次数，出现的页数，来源的个数
    In in1 = new In(wordsFilename);

    String lineStr = in1.readLine();
    while (lineStr != null) {
        String[] aa = lineStr.split("\t"); // 这里的String[] 是一个array

    }


}

/**
 * Provides the history of WORD. The returned TimeSeries should be a copy,
 * not a link to this NGramMap's TimeSeries. In other words, changes made
 * to the object returned by this function should not also affect the
 * NGramMap. This is also known as a "defensive copy".
 */
public TimeSeries countHistory(String word) {

    //todo

    return null;
}

/**
 * Provides the history of WORD between STARTYEAR and ENDYEAR, inclusive of both ends. The
 * returned TimeSeries should be a copy, not a link to this NGramMap's TimeSeries. In other words,
 * changes made to the object returned by this function should not also affect the
 * NGramMap. This is also known as a "defensive copy".
 */
public TimeSeries countHistory(String word, int startYear, int endYear) {
    return null;
}

/**
 * Returns a defensive copy of the total number of words recorded per year in all volumes.
 */
public TimeSeries totalCountHistory() {
    return null;
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
