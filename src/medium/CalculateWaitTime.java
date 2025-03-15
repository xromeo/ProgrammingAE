package medium;

/*
 
Calculate the total wait time for a customer C ( C = M + 1) to speak to an agent given N agents, M customers, and T[] time for an agent to serve a customer. 
T[i] represents the amount of time it takes for an agent i to serve one customer. 
One agent can serve one customer at a time. 
All N agents can serve concurrently. The customer chooses the agent with the lowest wait time.

Examples:

N = 2
M = 2
T = [4, 5]
First customer chooses agent 1. Second customer chooses agent 2.
Customer C will wait 4 minutes.
N = 2
M = 4
T = [4, 5]
First customer chooses agent 1. Second customer chooses agent 2.
Third customer chooses agent 1. Forth customer chooses agent 2.
Customer C will wait 8 minutes.
Initial questions:

Bounds on N and M - No bounds
Can N or M be zero - Both can be zero
Are the T values constant - Yes
Are the T values integers - Yes
 * 
 */
import java.util.*;
public class CalculateWaitTime {
    public static int solution(int N, int M, int time[]){
        PriorityQueue<Agent> q = new PriorityQueue<Agent>((a,b) -> Integer.compare(a.wait, b.wait));
 
        if(M < N){
            return time[M];
        }        

        // while (!q.isEmpty()) {
        //     System.out.println(q.poll());
        // }
        for (int j = 0; j < N; j++) {
            q.offer(new Agent(j,time[j]));            
        }            
        
        for (int i = N; i < M; i++) {
            Agent agent = q.poll();            
            agent.wait = agent.wait + time[agent.index];
            q.offer(agent);
        }
        
        Agent agent = q.poll();

        return agent.wait;

    }



    public static void main(String[] args){
        int[] t = {4,5,6}; 
        System.out.println(solution(2,2, t));// 4
        System.out.println(solution(2,4, t));//8

        System.out.println(solution(3,5, t));// 6
        System.out.println(solution(3,1, t));// 6
    }
}

class Agent {
    public int index;
    public int wait;   
    
    public Agent(int index, int wait){
        this.index = index;
        this.wait = wait;
    }

    @Override
    public String toString() {
        return "Agent [index=" + index + ", wait=" + wait + "]";
    }

    
}
