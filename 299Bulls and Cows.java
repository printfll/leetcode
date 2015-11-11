package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;

public class Solution {
	static int count=0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s =new Solution();
		
		System.out.println(s.getHint("1807","7810"));
	}
	
	
	public String getHint(String secret, String guess) {
		 int bull=0;
	        int cow=0;
	        int len=secret.length();
	        ArrayList<Integer> indices=new ArrayList<Integer>();
	        if(len==0){
	            return "0A0B";
	        }
	        HashMap<Integer,ArrayList<Integer> > map=new HashMap<Integer,ArrayList<Integer>>();
	        for(int i=0;i<len;i++){
	            int tmp=secret.charAt(i)-'0';
	            if(map.get(tmp)!=null){
	                ArrayList<Integer> arr=map.get(tmp);
	                arr.add(i);
	                map.remove(tmp);
	                map.put(tmp,arr);
	            }else{
	            	ArrayList<Integer>arr= new ArrayList<Integer>();
	            	arr.add(i);
	                map.put(tmp,arr);
	            }
	        }
	        
	        //first find bull
	        int i=0;
	        for(i=0;i<len;i++){
	            int tmp=guess.charAt(i)-'0';
	           
	            if(map.get(tmp)!=null){
	                ArrayList<Integer> arr=map.get(tmp);
	                if(arr.contains(i)){
	                	
	                	int index=arr.indexOf(i);
	                //	 System.out.println(tmp+","+i);
	                    bull++;
	                    arr.remove(index);
	                    map.remove(tmp);
	                    indices.add(i);
	                    if(arr.size()!=0){
	                        map.put(tmp,arr);
	                    }
	                   
	                }
	            }
	           
	        }
	        
	       for(i=0;i<indices.size();i++){
	    	   int index=indices.get(i);
	    	   secret=secret.substring(0, index)+" " + secret.substring(index+1);
	    	   guess=guess.substring(0, index)+" " + guess.substring(index+1);
	       }
	       secret=secret.replaceAll("\\s+","");
	       guess=guess.replaceAll("\\s+","");
	        len-=bull;
	       // System.out.println("str:"+secret+",guess:"+guess);
	        //then find cow
	        for(i=0;i<len;i++){
	            int tmp=guess.charAt(i)-'0';
	        //    System.out.println(tmp);
	            if(map.get(tmp)!=null){
	                ArrayList<Integer> arr=map.get(tmp);
	                cow++;
	                arr.remove(0);
	                map.remove(tmp);
	                if(arr.size()!=0){
	                    map.put(tmp,arr);
	                }
	            }
	        }
	        
	        return bull+"A"+cow+"B";
    }
}


/*
a better solution
		int bull = 0, cow = 0;

        int[] sarr = new int[10];
        int[] garr = new int[10];

        for(int i = 0; i < secret.length(); i++){
            if(secret.charAt(i) != guess.charAt(i)){
                sarr[secret.charAt(i)-'0']++;
                garr[guess.charAt(i)-'0']++;
            }else{
                bull++;
            }
        }

        for(int i = 0; i <= 9; i++){
            cow += Math.min(sarr[i], garr[i]);
        }

        return (bull + "A" + cow + "B");
*/
	   
