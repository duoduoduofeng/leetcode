package leetcodeproblems.LC_701_800;

import java.util.*;

//752. [Open the Lock](https://leetcode.com/problems/open-the-lock)
public class S_752_OpenLock {
    public int openLock(String[] deadends, String target) {
        Set<String> deadendsList = new HashSet<>(Arrays.asList(deadends)); // set to speed up
        String start = "0000";

        if(deadendsList.contains(start) || deadendsList.contains(target)) {
            return -1; // cannot reach
        }

        if(start.equals(target)) {
            return 0;
        }

        Queue<String> states = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        states.add(start);
        int steps = 0;

        while(states.size() > 0) {
            int curLen = states.size();
            for(int j = 0; j < curLen; j++) {
                String curState = states.poll();

                if(curState.equals(target)) {
                    return steps;
                }

                char[] curStateChars = curState.toCharArray();
                for(int i = 0;  i < 4; i++) { // 只有4位
                    int c = curStateChars[i] - '0';

                    // add
                    int newc = c == 9? 0: c + 1;
                    curStateChars[i] = (char)(newc + '0');

                    String newStateStr = String.valueOf(curStateChars);
                    if(!visited.contains(newStateStr) && !deadendsList.contains(newStateStr)) {
                        states.add(newStateStr);
                        visited.add(newStateStr); // has been traversed already
                    }

                    // minus
                    newc = c == 0? 9: c - 1;
                    curStateChars[i] = (char)(newc + '0'); // here must plus '0', or newc will be turned into 'A' but not '1' when newc=1

                    newStateStr = String.valueOf(curStateChars);
                    if(!visited.contains(newStateStr) && !deadendsList.contains(newStateStr)) {
                        states.add(newStateStr);
                        visited.add(newStateStr);
                    }

                    curStateChars[i] = (char)(c + '0'); // reset
                }
            }
            steps++;
        }

        return -1;
    }

    public static void main(String[] args) {
        S_752_OpenLock ex = new S_752_OpenLock();
//        String target = "0202";
//        String[] deadends = {"0201","0101","0102","1212","2002"};
        String target = "8888";
        String[] deadends = {"0000"};

        int steps = ex.openLock(deadends, target);

        System.out.println(steps);
    }
}
