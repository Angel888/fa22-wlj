package ngordnet.main;

import ngordnet.hugbrowsermagic.NgordnetQuery;
import ngordnet.hugbrowsermagic.NgordnetQueryHandler;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import ngordnet.ngrams.NGramMap;

//todo synthesizing the results with the dataset from Project 2A.
// build your own graph class or classes.
public class HyponymsHandler extends NgordnetQueryHandler {
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
        if (qWords != null) {
//                resArrayList.addAll(this.Wdn.NodeToWords(this.Wdn.IntersectionNodes(qWords.get(0), qWords.get(1))));
                resArrayList.addAll(this.Wdn.IntersectionWords(qWords.get(0), qWords.get(1)));
        }
        resArrayList.sort(Comparator.naturalOrder());
        System.out.println(resArrayList);
        return resArrayList.toString();
    }
}
