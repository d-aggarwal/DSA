class Solution {
    public boolean hasMatch(String s, String p) {


        int i =0;

        while(i<p.length() && p.charAt(i)!='*') {
            i++;
        }

        String left ="";
        String right = "";
        if(i<p.length()) {
             left = p.substring(0,i);
            right = p.substring(i+1);
        } else {
            return false;
        }

        

        if(left.length()>0 && right.length()>0 && s.contains(left)&&s.contains(right)) {
            int indl = s.indexOf(left);
            int indr = s.lastIndexOf(right);

            if(indr >=  indl + left.length()) return true;
            // System.out.println(left +" " +right+""+indr+""+indl);
            
        } else if (left.length()<=0 && s.contains(right)) {
            return true;
        } else if (right.length()<=0 && s.contains(left)) {
            return true;
        } else if(right.length() <= 0 && left.length()<=0) {
            return true;
        }

        return false;
    }
}