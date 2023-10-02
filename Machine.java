import java.util.ArrayList;
class Machine {
    protected boolean routage;
    public ArrayList<Interface> cartes ; // arrayliste des cartes réseau
    
    public Interface getInt(int i) {
        return cartes.get(i);
    }
    
    public Machine(String adr) {
       cartes= new ArrayList<Interface>();
       ajouter(new Interface(adr));
       Main.Machines.add(this);
    }
    
    public void ajouter(Interface inter){ //ajouter une interface a une machine
        cartes.add(inter);
    }
    public boolean envoie(IP IPd){
       boolean est=false,vef=false;
       
      for(int i=0;i<this.cartes.size();i++){

        if(this.getInt(i).s != null && this.getInt(i).s.estDansleSwitch(IPd) && this.getInt(i).s.estDansleSwitch(this.getInt(i).adresseIp) )
        {
            est=true;
            if(this.getInt(i).verifier(IPd)==true){ 
                vef=true; 
            }
            
        }
      }
            
                if(!est){
                    
                    return false;
                }else{  
                    if(!vef){   
                                          System.out.println("nest pas dans le meme reseau");
                                        return false;

                    }else return true;

                    } 
               
            }

            
       
    public void activerRoutage(){
        if(this.cartes.size()>=2){ 
            System.out.println("routage activé");
            this.routage=true; 
        }
        else{
            System.out.println("routage non activé ajouter une interface pour l'activer");
            this.routage=false;
        }
            
    }
    public void DesactiverRoutage(){
            System.out.println("routage désactivé");
            this.routage=false;
    }
    public void router(){
        if(this.routage==true){
            
        }
    }
    
    public boolean ping(IP IPd){
        Machine m1 = null;
                 for(int i=0;i<Main.Machines.size();i++){
                    for(int j=0;j<Main.Machines.get(i).cartes.size();j++){
                        if(IPd==Main.Machines.get(i).cartes.get(j).getAdresseIp()) {
                            m1=Main.Machines.get(i);
                        }
                    }
                 }
                 if(m1==null){
                    System.out.println("ping non envoyé, impossible de trouver l'adresse");
                    return false;
                 }else{
         if(this.getInt(0).verifier(IPd)){
             if(this.envoie(IPd)&& m1.envoie(this.getInt(0).getAdresseIp())){
                 System.out.println("ping envoyé");
                 return this.envoie(IPd);
             }else{
                System.out.println("ping non envoyé, nest pas dans le meme switch");
                 
                 return this.envoie(IPd);
             }
         }
         else{
             if(envoie(this.getInt(0).gateWay)){
                 Machine m = null;
                 for(int i=0;i<Main.Machines.size();i++){
                    for(int j=0;j<Main.Machines.get(i).cartes.size();j++){
                        if(this.getInt(0).gateWay==Main.Machines.get(i).cartes.get(j).getAdresseIp()) {
                            m=Main.Machines.get(i);
                        }
                    }
                 }
                    if(m.routage==true){
                        if(m.envoie(IPd)){
                                
                                if(m1.envoie(m1.getInt(0).gateWay)){
                                            if(m.envoie(this.getInt(0).getAdresseIp())){
                                                    System.out.println("ping envoyé");
                                                    return true;
                                            }else{
                                                System.out.println("ping non envoyé erreur sue le renvoie");
                                                  return false;
                                            }
                                }else{  System.out.println("ping non envoyé, l'autre machine ne peux pas le renvoyé car elle est mal configuré");
                                        return false;}
                        }else{
                                 System.out.println("ping non envoyé le routeur ne pas pas cominiquer avec la machine");
                return false;
                        }
                    
                }else{
                    System.out.println("ping non envoyé , le routage nest pas activé ");
                 return false;
                            }
             }
             else{
                 System.out.println("ping non envoyé , la machine n'est pas connecté au routeur ");
                 return false;
                 
             }
             
         }
    }
}
    }
