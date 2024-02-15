package ngordnet.main;

import ngordnet.hugbrowsermagic.NgordnetQuery;
import ngordnet.hugbrowsermagic.NgordnetQueryHandler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import ngordnet.ngrams.NGramMap;
import ngordnet.ngrams.TimeSeries;
import org.eclipse.jetty.util.Callback;

// synthesizing the results with the dataset from Project 2A.
// build your own graph class or classes.

// todo 为啥没法继承Comparable?
public class HyponymsHandler  extends NgordnetQueryHandler implements Comparable {
//public class HyponymsHandler  extends NgordnetQueryHandler{
    public NGramMap ngm;
    public WordNet Wdn;

    public HyponymsHandler(NGramMap ngm, WordNet wdn) {
        this.ngm = ngm;
        this.Wdn = wdn;
    }

    @Override
    public String handle(NgordnetQuery q) {
        ArrayList<String> resArrayList = new ArrayList<>();
        List<String> qWords = q.words(); // 先默认是两个words
        if (qWords != null && q.k() == 0) {
            resArrayList.addAll(this.Wdn.IntersectionWords(qWords.get(0), qWords.get(1)));
            resArrayList.sort(Comparator.naturalOrder());
//            System.out.println(resArrayList);
            return resArrayList.toString();
        } else if (qWords != null && q.k() > 0) {
            resArrayList.addAll(this.Wdn.IntersectionWords(qWords.get(0), qWords.get(1)));
            if (resArrayList.size() <= q.k()) {
                return resArrayList.toString();
            } else {
                ArrayList<TimeSeries> tss = new ArrayList<>();
                for (String word : resArrayList) {
                    TimeSeries ts = ngm.countHistory(word);
                    tss.add(ts);
                }
                Collections.sort(tss); //todo
            }
            resArrayList.sort(Comparator.naturalOrder());
            System.out.println(resArrayList);
            return resArrayList.toString();
        }
        return null;

    }

//todo 或许应该写到wordNet或者 NGramMap
    @Override
    public int compareTo(Object o) {
        Object aa =(TimeSeries) o;
        return ((aa.data() < aa.data ()) ? (-1) //todo 转成object后怎么比较??
                : ((this.getAge() == candidate.getAge())
                ? 0 : 1));
    }


}
