public class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        if(m==n){
            
            return m;
        }
        int count=0;
       while(m!=n){
           m>>=1;
           n>>=1;
           count++;
       }
       n=n<<count;
       return n;
    }
}