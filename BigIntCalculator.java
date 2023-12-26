public class BigIntCalculator {
    public static String add(String a, String b) {  // fait la somme de deux nombre trés grand pas le droit à BigInt


        Integer reste = 0 ;                                 // on va faire la somme comme au primaire avec le reste
        String res = "" ;                                   // on va ensuite ajouter petit à petit le résultat                                    
        String nbZero = "";
      
        int longueurDiff = a.length() - b.length();
        if (longueurDiff < 0) {longueurDiff*=-1;}
 
        for (int num = 0 ; num<longueurDiff ; num++ ) {nbZero += "0" ;}
        
        if (a.length()>b.length()){
            b = nbZero + b;
        }
        if (b.length()>a.length()){
            a = nbZero + a;
        }

        for(int i = a.length()-1 ; i>=0 ; i-- ){

            String miniSomme = String.                      // on fait la somme des elements à l'index i
                valueOf(Integer.valueOf(a.substring(i,i+1))+Integer.valueOf(b.substring(i,i+1))+reste);
          

            if(miniSomme.length()>1)
            reste = Integer.                                // on récupére le reste soit tout les chiffres situé donc aprés le premier donc quand la somme > 10
                valueOf(miniSomme.substring(0, miniSomme.length()-1));
            else
            reste = 0 ;
          

            res = miniSomme.                                // on ajoute l'unité de la somme à notre minisomme
            substring(miniSomme.length()-1,miniSomme.length())+res;
            
            
        }
        
        if (reste > 0) {res = String.valueOf(reste) + res;}
        
        res .replaceFirst("^0+","");     // on enléve les zéros au début du avant le nombre

        System.out.println(a + " + "+ b +" = "+res);

        return res;
    }
    
    public static void main(String[] args){
        try{
        add("1893834934934930", "1734834734939934801");
        }
        catch(Exception e){
            System.out.println("not working : "+ e);
        }
    }
  }
