package timingtest;
import edu.princeton.cs.algs4.Stopwatch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by hug.
 */
public class TimeAList {
    private static void printTimingTable(AList<Integer> Ns, AList<Double> times, AList<Integer> opCounts) {
        System.out.printf("%12s %12s %12s %12s\n", "N", "time (s)", "# ops", "microsec/op");
        System.out.printf("------------------------------------------------------------\n");
        for (int i = 0; i < Ns.size(); i += 1) {
            int N = Ns.get(i);
            double time = times.get(i);
            int opCount = opCounts.get(i);
            double timePerOp = time / opCount * 1e6;
            System.out.printf("%12d %12.2f %12d %12.2f\n", N, time, opCount, timePerOp);
        }
    }

    public static void main(String[] args) {
        timeAListConstruction();
    }

    public static void timeAListConstruction() {
        // TODO: YOUR CODE HERE
//        SLList L = new SLList();
//        L.addLast(20);
//        TimeAList();
        List<Integer> times = new ArrayList<Integer>(Arrays.asList(100, 1000, 2000));;
        for (int i = 0; i < times.size(); i += 1){
            Integer execute_times = times.get(i);
            Stopwatch sw = new Stopwatch();
            SLList<Integer> Ns = new SLList<>();
            for (int j=0;j<execute_times;j+=1){
                Ns.addLast(j);
            }
            double timeInSeconds = sw.elapsedTime();
            System.out.printf("%12s %12s %12s %12s\n", execute_times, timeInSeconds, execute_times, timeInSeconds/execute_times);

        }
    }


}
