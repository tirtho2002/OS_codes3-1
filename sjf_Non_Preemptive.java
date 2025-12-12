import java.util.*;

public class sjf_Non_Preemptive {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of processes: ");
        int n = sc.nextInt();

        int burst[] = new int[n+1];
        int process[] = new int[n+1];
        int waiting[] = new int[n+1];

        for(int i=1; i<=n; i++){
            System.out.print("Enter burst time of P"+i+": ");
            burst[i] = sc.nextInt();
            process[i] = i;
        }

        for(int i=1; i<=n; i++){
            for(int j=i+1; j<=n; j++){
                if(burst[i] > burst[j]){
                    int temp = burst[i]; burst[i] = burst[j]; burst[j] = temp;
                    int t2 = process[i]; process[i] = process[j]; process[j] = t2;
                }
            }
        }

        int cumulative = 0;
        for(int i=1; i<=n; i++){
            waiting[process[i]] = cumulative;
            cumulative += burst[i];
        }

        int sum = 0;
        System.out.println();
        for(int i=1; i<=n; i++){
            System.out.println("Waiting time for P" + i + " = " + waiting[i]);
            sum += waiting[i];
        }

        double avg = (double)sum / n;
        System.out.println("Average Waiting Time = " + avg);
    }
}
