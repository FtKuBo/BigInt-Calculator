// except using the BigInt library we cannot add extremly big numbers

import java.math.BigInteger;

public class BigIntCalculator {
    public static String add(String a, String b) {   //Sum two very large numbers without using BigInt.


        Integer reste = 0 ;                                 // oui will do the sum method with carry
        String res = "" ;                                                                     
        String nbZero = "";
        int longueurDiff = a.length() - b.length();

        if (longueurDiff < 0) { longueurDiff*=-1; }
 
        for (int num = 0 ; num<longueurDiff ; num++ ) {nbZero += "0" ;}
        
        if (a.length()>b.length()){ b = nbZero + b; }

        if (b.length()>a.length()){ a = nbZero + a; }

        for(int i = a.length()-1 ; i>=0 ; i-- ){

            String miniSomme = String.                      // we will do the sum of the numbers at the index i
                valueOf(Integer.valueOf(a.substring(i,i+1))+Integer.valueOf(b.substring(i,i+1))+reste);
          

            if(miniSomme.length()>1)
            reste = Integer.                                // we store the carry of the sum of the two digits in reste
                valueOf(miniSomme.substring(0, miniSomme.length()-1));
            else
            reste = 0 ;
          

            res = miniSomme.                                // we add the unit of the sum to our value
            substring(miniSomme.length()-1,miniSomme.length())+res;
            
            
        }
        
        if (reste > 0) {res = String.valueOf(reste) + res;}
        
        res.replaceFirst("^0+","");     // we remove zeros at the lefthand side of the number

        return res;
    }
    
    public static void main(String[] args){
        try{
            String Value1 = "1893834934934930";
            String Value2 = "1734834734939934801";
            System.out.println(Value1+" + "+Value2+" = "+add(Value1, Value2));
        }
        catch(Exception e){
            System.out.println("not working : "+ e);
        }
    }
  }
