class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();

        for(int asteroid: asteroids){
            boolean destroyed = false;

            while(!st.isEmpty() && asteroid < 0 && st.peek() > 0){
                if(st.peek() < Math.abs(asteroid)){
                    st.pop();
                    continue;
                }
                else if(st.peek() == -asteroid){
                    st.pop();
                }
                destroyed = true;
                break;
            }

            if(!destroyed){
                st.push(asteroid);
            }
        }

        int[] ans = new int[st.size()];
        for(int i = ans.length - 1; i >= 0; i--){
            ans[i] = st.pop();
        }

        return ans;
    }
}