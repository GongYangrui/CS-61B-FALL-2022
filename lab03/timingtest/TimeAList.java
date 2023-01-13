package timingtest;
import edu.princeton.cs.algs4.Stopwatch;

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
        AList<Integer> Ns = new AList<>();
        int n = 1;
        for (int i = 0; i < 8; i += 1) {
            int result = 1;
            for (int j = 0; j < n; j += 1) {
                result *= 2;
            }
            Ns.addLast(result * 1000);
            n++;
        }

        AList<Double> times = new AList<>();
        AList<Integer> N = new AList<>();
        for (int i = 0; i < 8; i++) {
            Stopwatch sw = new Stopwatch();
            for (int j = 0; j < Ns.get(i); j += 1) {
                N.addLast(0);
            }
            double timeInSeconds = sw.elapsedTime();
            times.addLast(timeInSeconds);
        }

        AList<Integer> opCounts = new AList<>();
        int m = 1;
        for (int i = 0; i < 8; i += 1) {
            int result = 1;
            for (int j = 0; j < m; j += 1) {
                result *= 2;
            }
            opCounts.addLast(result * 1000);
            m++;
        }
        TimeAList.printTimingTable(Ns, times, opCounts);
    }
}
