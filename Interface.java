
class Interface{
        public IP adresseIp;
        private Mac adresseMac;
        public int mask;
        public IP gateWay;
        public Switch s;
        public Machine m;

        private int mm(IP adr){
            String[] parties = adr.getAdr().split("\\."); 
            // if(Integer.parseInt(parties[0])== )
            return switch (Integer.parseInt(parties[0])) {
                case 10 -> 8;
                case 172 -> 16;
                case 192 -> 24;
                default -> 0;
            };  
        }

    public Interface(String adrIP) {
        this.adresseIp = new IP(adrIP);
        this.adresseMac = new Mac();
        this.mask = mm(this.adresseIp);
        this.gateWay = new IP("0.0.0.0"); 
        
    }

    public Machine getM() {
        return m;
    }

    public void setM(Machine M) {
        this.m = M;
    }
        
        public void setAdresseIp(IP adresseIp) {
           this.adresseIp = adresseIp;

        }
        public void setAdresseMac(Mac adresseMac) {
            this.adresseMac = adresseMac;
        }
        public void setMask(int mask) {
            this.mask = mask;
        }
        public IP getAdresseIp() {
            return this.adresseIp;
        }
        public Mac getAdresseMac() {
            return adresseMac;
        }
        public int getMask() {
            return mask;
        }
        public IP getGateWay() {
            return gateWay;
        }
        public void setGateWay(IP gateWay) {
            this.gateWay = gateWay;
        }

    public void setS(Switch s) {
        this.s = s;
    }
        

    @Override
    public String toString() {
        return "Interface{" + "AdresseIp=" + adresseIp.getAdr() + ", AdresseMac=" + adresseMac.getMAC() + ", mask=" + mask + ", GateWay=" + gateWay.getAdr() + '}';
    }
    
        public  boolean verifier(IP adresseIP1){
            boolean rep=true;
            String[] parties1 = adresseIP1.getAdr().split("\\.");
            String[] parties2 = this.adresseIp.getAdr().split("\\.");
            //verifier si adrIP2 existe dans le switch 
            if(this.getMask()==24){
            for(int i=0;i<3;i++){
                if(Integer.parseInt(parties1[i])!= Integer.parseInt(parties2[i])){
                    rep=false;
                }
            }
             }
            if(this.getMask()==16){
            for(int i=0;i<2;i++){
                if(Integer.parseInt(parties1[i])!= Integer.parseInt(parties2[i])){
                    rep=false;
                }
            }
             }
            if(this.getMask()==8){

            for(int i=0;i<1;i++){
                if(Integer.parseInt(parties1[i])!= Integer.parseInt(parties2[i])){
                    rep=false;
                }
            }
             }

return rep;
}
    

}
