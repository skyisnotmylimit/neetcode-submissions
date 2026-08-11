class Pair implements Comparable<Pair> {
    int dist;
    int speed;
    Pair(int dist,int speed) {
        this.dist = dist;
        this.speed = speed;
    }
    @Override
    public int compareTo(Pair other) {
        return this.dist - other.dist;
    }
}
class Solution {
    public boolean check(Pair p1,Pair p2,int target) {
        double t1 = (target - p1.dist) / (double)p1.speed;
        double t2 = (target - p2.dist) / (double)p2.speed;
        if(t1 >= t2) return true;
        else return false;
    }
    public int carFleet(int target, int[] position, int[] speed) {
        ArrayList<Pair> list = new ArrayList<>();
        for(int i=0;i<speed.length;i++) {
            list.add(new Pair(position[i],speed[i]));
        }
        Collections.sort(list);
        Stack<Pair> st = new Stack<>();
        for(int i=0;i<list.size();i++) {
            while(!st.isEmpty() && check(list.get(i),st.peek(),target)) {
                st.pop();
            }
            st.push(list.get(i));
        }
        return st.size();
    }
}