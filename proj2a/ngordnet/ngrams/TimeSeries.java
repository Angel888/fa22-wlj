package ngordnet.ngrams;

import java.util.*;

/**
 * An object for mapping a year number (e.g. 1996) to numerical data. Provides
 * utility methods useful for data analysis.
 *
 * @author Josh Hug
 */
public class TimeSeries extends TreeMap<Integer, Double> {
    public List<Integer> years;
    public String word;
    public List<Double> times;
    public ArrayList<Factor>  factors=new ArrayList<>();  //todo 这样初始化会有问题吗？好像没有见过别人这么搞？
    public HashMap<Integer, YearCount> yearTotalCount=new HashMap<Integer, YearCount>();
    /**
     * Constructs a new empty TimeSeries.
     */
    public TimeSeries() {
        super();
    }

    /**
     * Creates a copy of TS, but only between STARTYEAR and ENDYEAR,
     * inclusive of both end points.
     */
    public TimeSeries(TimeSeries ts, int startYear, int endYear) {
        super();
    }

    /**
     * Returns all years for this TimeSeries (in any order).
     */
    public List<Integer> years() {
        return this.years;
    }

    /**
     * Returns all data for this TimeSeries (in any order).
     * Must be in the same order as years().
     */
    public List<Double> data() {
        return this.times;
    }

    /**
     * Returns the yearwise sum of this TimeSeries with the given TS. In other words, for
     * each year, sum the data from this TimeSeries with the data from TS. Should return a
     * new TimeSeries (does not modify this TimeSeries).
     */
    public TimeSeries plus(TimeSeries ts) {
        // 遍历这个原本的类
        for (Map.Entry<Integer, Double> entry : this.entrySet()) {
            Integer kk = entry.getKey();
            Double vv = entry.getValue();
            if (ts.containsKey(kk)) { // 二者都有这个key
                ts.put(kk, ts.get(kk) + vv);
            } else {
                ts.put(kk, vv);
            }
            // 处理键值对
        }
        return ts;
    }

    /**
     * Returns the quotient of the value for each year this TimeSeries divided by the
     * value for the same year in TS. If TS is missing a year that exists in this TimeSeries,
     * throw an IllegalArgumentException. If TS has a year that is not in this TimeSeries, ignore it.
     * Should return a new TimeSeries (does not modify this TimeSeries).
     */
    public TimeSeries dividedBy(TimeSeries ts) {
        return null;
    }

    public Double get(int year) {
        System.out.println("1865:"+this.yearTotalCount.get(1865));
        return (double) this.yearTotalCount.get(year).times;
    }
}
