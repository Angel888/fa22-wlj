package ngordnet.main;

import edu.princeton.cs.algs4.In;

import java.util.*;

// todo  根据 Suggested Steps to Take 来写
class Node {
    // 树的节点和孩子
    String[] val;
    ArrayList<Node> children;

}

public class WordNet {

    public ArrayList<Node> synsetsArray; // 每一个元素是个节点， ToDo 这种树可以中序遍历吗？需要中序遍历吗？
    public HashMap<String, HashSet<Integer>> NodeInd;  // 每个单词所在的节点,key是单词，val表示在synsets的index(第 i 个节点）


//    public  WordNet  hyponyms11;
    public WordNet(String synsets, String hyponyms) {
        // todo hyponyms不能使用LinkedList吧??因为可能有多个子节点，那么使用树还是图呢？
        //  synsets使用map,key是index ，val是节点
        In in1 = new In(synsets);
        String lineStr1 = in1.readLine();
        this.synsetsArray = new ArrayList<>();
        this.NodeInd = new HashMap<>();
        // 通过遍历synsets，获取所有节点的val,并且填充val和index关系的map
        while (lineStr1 != null) {
            String[] aa = lineStr1.split(","); // 这里的String[] 是一个array
            Integer index =Integer.valueOf(aa[0]);
            String wordStrings =aa[1];
            Node nn = new Node();
            nn.children = new ArrayList<>();
            nn.val = wordStrings.split(" ");
            this.synsetsArray.add(nn);
            for (int i = 0; i < nn.val.length; i++) {
                if (this.NodeInd.containsKey(nn.val[i])) {
                    this.NodeInd.get(nn.val[i]).add(index);
                } else {
                    HashSet<Integer> hh = new HashSet<>();
                    hh.add(index);
                    this.NodeInd.put(nn.val[i], hh);
                }
            }
            lineStr1 = in1.readLine();
        }
        In in2 = new In(hyponyms);
        String lineStr2 = in2.readLine();
        // 通过遍历hyponyms，获取所有节点的子节点
        while (lineStr2 != null) {
            String[] lineArray = lineStr2.split(",");

            for (int i = 1; i < lineArray.length; i++) {
                this.synsetsArray.get(Integer.parseInt(lineArray[i - 1])).children.add(synsetsArray.get(Integer.parseInt(lineArray[i])));
            }
            lineStr2 = in2.readLine();
        }
    }

    public HashSet<Integer> getNodes(String word) {

        return this.NodeInd.get(word);
    }

    public HashSet<String> findHyponyms(String word) {
        HashSet<String> hyponymsArray = new HashSet<>();
        HashSet<Integer> nodeIndx = this.NodeInd.get(word);
        if (nodeIndx != null) {
            for (int idx : nodeIndx) {
                // todo 层次遍历子节点，添加到set
                hyponymsArray.addAll(this.getNodeHyponyms(this.synsetsArray.get(idx)));
            }
        }
        return hyponymsArray;
    }

    public HashSet<String> getNodeHyponyms(Node node) {
        HashSet<String> childrenWords = new HashSet<>(Arrays.asList(node.val));
        ArrayDeque<Node> temporaryChildren = new ArrayDeque<>();
        temporaryChildren.addAll(node.children);
        while (temporaryChildren != null) {
            for (Node nn : temporaryChildren) {
                childrenWords.addAll(List.of(nn.val));
                temporaryChildren.addAll(nn.children);
                temporaryChildren.removeFirst();
            }
        }
        return childrenWords;

    }

}
