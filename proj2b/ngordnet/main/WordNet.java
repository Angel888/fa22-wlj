package ngordnet.main;

import edu.princeton.cs.algs4.In;

import java.util.*;

// todo  根据 Suggested Steps to Take 来写
class Node {
    // 树的节点和孩子
    String[] val;
    ArrayList<Node> children;
    Integer NodeIndex ;

    @Override
    public String toString() {
        return "val: " + Arrays.toString(val) + ", children: " + children.toString() + ", NodeIndex: " + NodeIndex.toString();
    }
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
            Integer index = Integer.valueOf(aa[0]);
            String wordStrings = aa[1];
            Node nn = new Node();
            nn.children = new ArrayList<>();
            nn.val = wordStrings.split(" ");
            nn.NodeIndex = index;
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
        // 通过遍历 hyponyms，获取所有节点的子节点
        while (lineStr2 != null) {
            String[] lineArray = lineStr2.split(",");
            Integer parentIndex= Integer.parseInt(lineArray[0]);
            for (int i = 1; i < lineArray.length; i++) {
                this.synsetsArray.get(parentIndex).children.add(synsetsArray.get(Integer.parseInt(lineArray[i])));
            }
            lineStr2 = in2.readLine();
        }
    }

    public HashSet<Integer> getNodes(String word) {
        return this.NodeInd.get(word);
    }

    public HashSet<Node> findHyponyms(String word) {
        // 给出一个word 找到这个word在的所有节点和其对应的子节点
        HashSet<Node> hyponymsArray = new HashSet<>();
        HashSet<Integer> nodeIndx = this.NodeInd.get(word);
        if (nodeIndx != null) {
            for (int idx : nodeIndx) {
                // todo 层次遍历子节点，添加到set
                hyponymsArray.addAll(this.getNodeHyponyms(this.synsetsArray.get(idx)));
            }
        }
        System.out.println("hyponymsArray:"+hyponymsArray+"\n");
        return hyponymsArray;
    }

    public HashSet<Node> getNodeHyponyms(Node node) {
        // 层次遍历 给出一个Node 返回这个Node在的所有节点和其对应的子节点
        HashSet<Node> childrenNodes = new HashSet<>();
        ArrayDeque<Node> temporaryChildren = new ArrayDeque<>();
        temporaryChildren.add(node);
        while (temporaryChildren.size() > 0) { // todo 层次遍历除了用两个arrayList 还有没有别的简单办法？
            temporaryChildren.addAll(temporaryChildren.getFirst().children);
            childrenNodes.add(temporaryChildren.removeFirst());
        }
        return childrenNodes;
    }

    public HashSet<Node> IntersectionNodes(String word1, String word2) {
        HashSet<Node> word1Nodes = this.findHyponyms(word1);
        HashSet<Node> word2Nodes = this.findHyponyms(word2);
        ArrayList<Integer> a1=this.getNodesIndex(word1Nodes);
        a1.sort(Comparator.naturalOrder());
        ArrayList<Integer> a2=this.getNodesIndex(word2Nodes);
        a2.sort(Comparator.naturalOrder());
        System.out.println("a1,a2:"+a1+a2);
        word1Nodes.retainAll(word2Nodes);
        ArrayList<Integer> a3=this.getNodesIndex(word1Nodes);
        a3.sort(Comparator.naturalOrder());
        System.out.println("a3:"+a3);
        return word1Nodes;
    }
    public HashSet<String> IntersectionWords(String word1, String word2) {
        HashSet<Node> word1Nodes = this.findHyponyms(word1);
        HashSet<Node> word2Nodes = this.findHyponyms(word2);
        HashSet<String> a1=this.NodeToWords(word1Nodes);
        HashSet<String> a2=this.NodeToWords(word2Nodes);
        a1.retainAll(a2);
        return a1;
    }

    public HashSet<String> NodeToWords(HashSet<Node> nodes) {
        HashSet<String> resW = new HashSet<>();
        for (Node nn : nodes) {
            resW.addAll(List.of(nn.val));
        }
        System.out.println("resW:"+resW);
        return resW;
    }
    public ArrayList<Integer> getNodesIndex(HashSet<Node> nodes){
        ArrayList<Integer> resW = new ArrayList<>();
        for (Node nn : nodes) {
            resW.add(nn.NodeIndex);
        }
        return resW;

    }
}

