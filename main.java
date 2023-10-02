
import java.util.ArrayList;
public class Main {
    static  ArrayList <Machine> Machines=new ArrayList<Machine>();
    public static void main(String[]args){
        Machine m1=new Machine("172.168.1.1");
        Machine m2=new Machine("172.169.2.2");
        Interface i1=m1.getInt(0);
        Interface i2=m2.getInt(0);
        Switch s1=new Switch("banane");
        s1.ajouter(i1);
        s1.ajouter(i2);
        System.out.println(i1.toString());
        System.out.println(i2.toString());
        m1.envoie(i2.getAdresseIp());
        
              Machine routeur=new Machine("172.168.1.4");
        Interface i4= routeur.getInt(0);
        
      Interface i3=new Interface("172.169.2.3");
        routeur.ajouter(i3);
        routeur.activerRoutage();
        i1.setGateWay(i4.getAdresseIp());
         Switch s2=new Switch("banane1");
         s1.ajouter(i4);
         s2.ajouter(i2);
         s2.ajouter(i3);
          System.out.println(i1.toString());
            m1.envoie2(i2.getAdresseIp());
        
    }
}
