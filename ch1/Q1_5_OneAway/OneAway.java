/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch1.Q1_5_OneAway;

/**
 *
 * @author hemil
 */
public class OneAway {
    
    public static boolean oneReplaceAway(String s1, String s2)
    {
        int check = 0;
        for(int i=0; i<s1.length() ; i++){
            if(s1.charAt(i) != s2.charAt(i)){
                check++;
                if(check > 1)
                    return false;
            }    
        }
        return true;
    }
    
    public static boolean oneInsertDeleteAway(String s1, String s2)
    {
        int check = 0, i=0, j=0;
        
        while(i < s1.length() && j < s2.length() ){
            
            if(s1.charAt(i) != s2.charAt(j)){
                i++;
                check++;
                if(check > 1)
                    return false;
            }
            else{
                i++;j++;
            }
        }
        return true;
    }
    
    public static boolean oneEditAway(String s1, String s2){
    
        if(s1.length() == s2.length()){
            return oneReplaceAway(s1,s2);
        }
        else{
            if(s1.length() > s2.length()){
                if(s1.length() > s2.length()+1)
                    return false;
                
                return oneInsertDeleteAway(s1,s2);
            }
            else if (s2.length() > s1.length()){
                if(s2.length() > s1.length()+1)
                    return false;
                
                return oneInsertDeleteAway(s2,s1);
            }
                
        }
        return true;
    }
    
    public static void main(String[] args) {
        String a = "pale";
        String b = "bake";
        boolean isOneEdit = oneEditAway(a, b);
        System.out.println(a + ", " + b + ": " + isOneEdit);
    }
}
