class Solution {
    public boolean isVowel(char c){
        return (c=='a'||c=='A'||c=='e'||c=='E'||c=='o'||c=='O'||c=='i'||c=='I'||c=='u'||c=='U');
    }
    public String reverseVowels(String s) {
        int left=0,right=s.length()-1;
        char[] c=s.toCharArray();
        while(left<right){
            if(!isVowel(c[left])) left++;
            else if(!isVowel(c[right])) right--;
            else{
                char a=c[left];
                c[left]=c[right];
                c[right]=a;
                left++;
                right--;
            }
        }
        return new String(c);
    }
}