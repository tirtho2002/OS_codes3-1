import java.util.*;

public class PreemptiveRR {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arrival = new int[n];
        int[] bt = new int[n];
        int[] rem_bt = new int[n];
        int[] ct = new int[n];
        int[] tat = new int[n];
        int[] wt = new int[n];
        boolean[] finished = new boolean[n];

        int completed = 0;
        int time = 0;
        int[] seq = new int[100];
        int seqIndex = 0;

        for (int i = 0; i < n; i++) arrival[i] = sc.nextInt();
        for (int i = 0; i < n; i++) {
            bt[i] = sc.nextInt();
            rem_bt[i] = bt[i];
        }

        int tq = sc.nextInt();

        while (completed < n) {
            boolean didSomething = false;
            for (int i = 0; i < n; i++) {
                if (!finished[i] && rem_bt[i] > 0 && arrival[i] <= time) {
                    didSomething = true;
                    if (rem_bt[i] > tq) {
                        rem_bt[i] -= tq;
                        time += tq;
                        seq[seqIndex++] = i + 1;
                    } else {
                        time += rem_bt[i];
                        rem_bt[i] = 0;
                        finished[i] = true;
                        ct[i] = time;
                        completed++;
                        seq[seqIndex++] = i + 1;
                    }
                }
            }
            if (!didSomething) time++;
        }

        for (int i = 0; i < n; i++) {
            tat[i] = ct[i] - arrival[i];
            wt[i] = tat[i] - bt[i];
        }



        // System.out.println("P\tAT\tBT\tCT\tTAT\tWT");
        for (int i = 0; i < n; i++) {
            System.out.println( "\n"+arrival[i] + "\t" + bt[i] + "\t" + ct[i] + "\t" + tat[i] + "\t" + wt[i]);
        }

                System.out.print("\n ");
        for (int i = 0; i < seqIndex; i++) System.out.print("P" + seq[i] + " ");
        System.out.println();
    }
}
