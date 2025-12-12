import java.util.*;

public class sjf_Preemptive {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of processes: ");
        int n = sc.nextInt();

        int[] burst = new int[n];
        int[] remaining = new int[n];
        int[] waiting = new int[n];
        int[] finish = new int[n];
        
        for (int i = 0; i < n; i++) {
            System.out.print("Enter burst time of P" + (i+1) + ": ");
            burst[i] = sc.nextInt();
            remaining[i] = burst[i];
        }

        int time = 0, completed = 0;

        while (completed < n) {
            int shortest = -1;
            int min = Integer.MAX_VALUE;

            for (int i = 0; i < n; i++) {
                if (remaining[i] > 0 && remaining[i] < min) {
                    min = remaining[i];
                    shortest = i;
                }
            }

            remaining[shortest]--;
            time++;

            if (remaining[shortest] == 0) {
                completed++;
                finish[shortest] = time;
                waiting[shortest] = finish[shortest] - burst[shortest];
            }
        }

        int sum = 0;
        System.out.println();
        for (int i = 0; i < n; i++) {
            System.out.println("Waiting time for P" + (i+1) + " = " + waiting[i]);
            sum += waiting[i];
        }

        double avg = (double)sum / n;
        System.out.println("Average Waiting Time = " + avg);
    }
}
