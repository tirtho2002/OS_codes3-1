
package code;
import java.util.*;

public class bankers_algo {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("pro: ");
        int n = sc.nextInt();

        System.out.print("res: ");
        int m = sc.nextInt();

        int[][] max = new int[n][m];
        int[][] alloc = new int[n][m];
        int[][] need = new int[n][m];
        int[] avail = new int[m];

        System.out.println("\nMaximum need Resources::");
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                max[i][j] = sc.nextInt();

        System.out.println("\nAssigned Resources::");
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                alloc[i][j] = sc.nextInt();

        System.out.println("\nEnter Available resources:");
        for (int j = 0; j < m; j++)
            avail[j] = sc.nextInt();

        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                need[i][j] = max[i][j] - alloc[i][j];

        int[] safeSeq = new int[n];
        boolean[] finished = new boolean[n];
        int count = 0;

        while (count < n) {
            boolean found = false;

            for (int i = 0; i < n; i++) {
                if (!finished[i]) {
                    int j;
                    for (j = 0; j < m; j++) {
                        if (need[i][j] > avail[j])
                            break;
                    }

                    if (j == m) {
                        for (int k = 0; k < m; k++)
                            avail[k] += alloc[i][k];

                        safeSeq[count++] = i;
                        finished[i] = true;
                        found = true;
                    }
                }
            }

            if (!found) {
                System.out.println("\nSystem is NOT in safe state!");
                return;
            }
        }

        System.out.println("\nSAFE");
        System.out.print("Seq: ");
        for (int i = 0; i < n; i++)
            System.out.print("P" + safeSeq[i] + " ");
    }
}
