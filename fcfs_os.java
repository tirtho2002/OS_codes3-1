import java.util.*;



public class fcfs_os {
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the process number: ");
        int n=sc.nextInt();
        int burst[]=new int[n+1];
        burst[0]=0;



        for(int i=1;i<=n;i++){
            System.out.print("Enter the Brust number of P"+i+":");
            burst[i]=sc.nextInt();
            burst[i]=burst[i-1]+burst[i];
            System.out.println();

       
        }
        for(int i=0;i<n;i++){
            System.out.println("Waiting time for P"+(i+1)+" "+burst[i]);
        }
    }
}
