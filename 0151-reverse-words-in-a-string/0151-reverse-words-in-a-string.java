class Solution {
    public String reverseWords(String s) {
        s = s.trim().replaceAll("\\s+", " ");

        char[] ch = s.toCharArray();
        reverse(ch, 0, ch.length - 1);

        int start = 0;
        for(int end = 0; end < ch.length; end++){
            if(ch[end] == ' '){
                reverse(ch, start, end - 1);
                start = end + 1;
            }
        }

        reverse(ch, start, ch.length - 1);

        return new String(ch);
    }

    private void reverse(char[] ch, int left, int right){
        while(left < right){
            char temp = ch[left];
            ch[left] = ch[right];
            ch[right] = temp;
            left++;
            right--;
        }
    }
}