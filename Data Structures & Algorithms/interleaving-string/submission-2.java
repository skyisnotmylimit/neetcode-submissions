class Solution {
    private boolean solve(String s1,String s2,String s3,int i,int j,int k) {
        if(k >= s3.length()) return true;

        if(i >= s1.length()) {
            return s2.substring(j).equals(s3.substring(k));
        }

        if(j >= s2.length()) {
            return s1.substring(i).equals(s3.substring(k));
        }

        if(s1.charAt(i) == s3.charAt(k) && s2.charAt(j) == s3.charAt(k)) {
            return solve(s1,s2,s3,i+1,j,k+1) || solve(s1,s2,s3,i,j+1,k+1);
        }
        else if(s1.charAt(i) == s3.charAt(k)) {
            return solve(s1,s2,s3,i+1,j,k+1);
        }
        else if(s2.charAt(j) == s3.charAt(k)) {
            return solve(s1,s2,s3,i,j+1,k+1);
        }
        else return false;
    }
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length()+s2.length() > s3.length()) return false;
        return solve(s1,s2,s3,0,0,0);
    }
}
