import java.util.ArrayList;
public class Switch {
    public ArrayList <Interface> port ;
    public String nom;
    
    public Switch(String nom) {
        this.port = new ArrayList<Interface>();
        this.nom=nom;
    }
    
    public void ajouter(Interface interf){ //ajouter une interface a une machine
        port.add(interf);
        interf.setS(this);
    }
     public void debrancher(Interface interf){ //ajouter une interface a une machine
        port.remove(interf);
        
        interf.setS(new Switch("bah"));
    }
    public boolean estDansleSwitch(IP i1){
       // return port.contains(Interface.i1)&&port.contains(Interface.i2);
       boolean res=false;
       for(int i=0;i<port.size();i++){
           if(port.get(i).getAdresseIp().getAdr().equals(i1.getAdr())) res=true;
       }
       return res;
    }
    

}

