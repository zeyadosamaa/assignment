package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int n,i,qt,count=0,temp,sq=0,bt[],wt[],tat[],rem_bt[],arrival[];
        float average=0,avtuar=0;
        Scanner zoz =new Scanner(System.in);
        System.out.print("Enter the number of process ");
        n = zoz.nextInt();
        arrival = new int[n];
        bt = new int[n];
        wt = new int[n];
        tat = new int[n];
        rem_bt = new int[n];

        System.out.print("\nEnter the arrival time of the processes : \n");
        for(int j = 0; j < n; j++) {
            System.out.print("P"+(j+1)+" = ");
            arrival[j] = zoz.nextInt();
        }

        System.out.print("Enter the burst time of the process\n");
        for (i=0;i<n;i++)
        {
            System.out.print("P"+(i+1)+" = ");
            bt[i] = zoz.nextInt();
            rem_bt[i] = bt[i];
        }
        System.out.print("Enter the quantum time: ");
        qt = zoz.nextInt();
        while(true)
        {
            for (i=0,count=0;i<n;i++)
            {
                temp = qt;
                if(rem_bt[i] == 0)
                {
                    count++;
                    continue;
                }
                if(rem_bt[i]>qt)
                    rem_bt[i]= rem_bt[i] - qt;
                else
                if(rem_bt[i]>=0)
                {
                    temp = rem_bt[i];
                    rem_bt[i] = 0;
                }
                sq = sq + temp;
                tat[i] = sq;
            }
            if(n == count)
                break;
        }
        System.out.print("--------------------------------------------------------------------------------");
        System.out.print("\nProcess\t      Burst Time\t       Turnaround Time\t          Waiting Time\n");
        System.out.print("--------------------------------------------------------------------------------");
        for(i=0;i<n;i++)
        {
            wt[i]=tat[i]-bt[i];
            average=average+wt[i];
            avtuar=avtuar+tat[i];
            System.out.print("\n "+(i+1)+"       \t\t "+bt[i]+"     \t\t\t\t "+tat[i]+"      \t\t\t\t\t "+wt[i]+"\n");
        }
        average=average/n;
        avtuar=avtuar/n;
        System.out.println("\nAverage waiting Time = "+average+"\n");
        System.out.println("Average turnaround time = "+avtuar);
    }
}