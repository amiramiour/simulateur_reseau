import java.io.*;
public class IP {
    private String adr;

    public String getAdr() {
        return adr;
    }
    

       public IP(String adr) {
       if(estCorrecte(adr)) {this.adr = adr;}else{
       this.adr=null;}
    }


    
    static boolean estCorrecte(String adr){
            String[] parties = adr.split("\\.");
            //La plage d'un nombre est entre 0 et 255
            for(int i = 0 ; i < 4; i++){
            //Convertir en entier et tester 
            if( Integer.parseInt(parties[i])<0 || Integer.parseInt(parties[i])>255)
            //retroune false
            return false;
            }
            //retourne true par défaut 
            return true;
            }
     public static boolean verifier(IP adresseIP,IP adresseIP2){
            boolean rep=true;
            String[] parties1 = adresseIP.getAdr().split("\\.");
            String[] parties2 = adresseIP2.getAdr().split("\\.");
            //verifier si adrIP2 existe dans le switch 
            for(int i=0;i<3;i++){
                if(Integer.parseInt(parties1[i])!= Integer.parseInt(parties2[i])){
                    rep=false;
                }
            }
            
            return rep;

}
     
  
    
}
