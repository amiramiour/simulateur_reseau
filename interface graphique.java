
/**
 *
 * @author rkichou
 */
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.event.*;
import java.awt.event.KeyEvent;
import java.awt.geom.Line2D;
import java.io.File;
import java.util.ArrayList;
public class Graphique {
   //on stock les machines cree
    static  ArrayList <Machine> Machines=new ArrayList<Machine>();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
 //creation des fenetre et composant a utiliser 
    JFrame f = new JFrame("simulateur reseaux");//fentre principale
    JFrame f1 = new JFrame();//config du PC1
    JFrame f2 = new JFrame();//config du PC2
   
    Switch S1 = new Switch("Switch");
    Icon icon = new ImageIcon("pc2.png");
    Icon icon2 = new ImageIcon("switch2.png");
    JButton b2 = new JButton(icon);//PC1
    JButton b4 = new JButton(icon);//PC2
    JButton b5 = new JButton(icon2);//switch
    JButton b3 = new JButton("ajouter une nouvelle machine");
//configuration de la fentre Principale
    f.setVisible(true);
    f.setSize(800,800);
    f.setLayout(null);
    f.getContentPane().setBackground(Color.white);
    JLabel l0 = new JLabel(" NOM MACHINE * ");
    l0.setBounds(40,40,200,30);
    f.add(l0);
    JTextField t0 = new JTextField(15);
    t0.setBounds(160,40,200,30);
    f.add(t0);
    JButton b = new JButton("configurer la machine");
    b.setBounds(380,40,200,30);
    f.add(b);
    JLabel l6= new JLabel("veuiller bien  entrer les champs obligatoire  ");
    f.add(l6);
    b.addActionListener( new ActionListener() {
       public void actionPerformed(ActionEvent e) {
              if(t0.getText().length()==0){
                JOptionPane.showMessageDialog(null,"veuiller saisir le nom de la machine* ");
                }else{
//config de la premiere machine 
        f1.setTitle("Machine : ".concat(t0.getText()));
        f1.setSize(400, 400);
        f1.setLocationRelativeTo(null);
        f1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        f1.setVisible(true);
        f1.setLayout(null);
        f1.getContentPane().setBackground(Color.white);
        JLabel l1 = new JLabel("ADRESSE IP*");
        l1.setBounds(40,50,100,30);
        f1.add(l1);
        JTextField t1 = new JTextField(12);
        t1.setBounds(140, 50, 200, 30);
        f1.add(t1);
        JLabel l2 = new JLabel("MAC ");
        l2.setBounds(40,95,100,30);
        f1.add(l2);
        MAC m1=new MAC();   
        JTextField t2 = new JTextField(20);
        t2.setText(m1.getMAC());
        t2.setBounds(140,95, 200, 30);
        t2.setEditable(false);
        f1.add(t2);
        JLabel l3 = new JLabel("gateway ");
        l3.setBounds(40,140,100,30);
        f1.add(l3);
        JTextField t3 = new JTextField("0.0.0.0");
        t3.setBounds(140,140, 200, 30);
        f1.add(t3);
        JLabel l4 = new JLabel("activer le routage ");
        l4.setBounds(40,185,200,30);
        f1.add(l4);
        JCheckBox J1 = new JCheckBox("");
        J1.setBounds(170,185, 30, 30);
        J1.setBackground(Color.white);
        f1.add(J1);
        JButton l = new JButton("Ajouter la machine");
        l.setBounds(40,230, 200, 30);
        f1.add(l);
//ajout de la machine 1        
        l.addActionListener( new ActionListener() {
        public void actionPerformed(ActionEvent p) {
                Boolean bool=false;
                //ajout d'un switch par defaut 
                b5.setBorderPainted(false);
                b5.setBounds(700,300,120,120);
                JLabel iu = new JLabel("Switch ");
                iu.setBounds(700,360,200,30);
                f.add(iu);
                f.add(b5);
//verification d'une contrainte et creation de la machine               
                if(t1.getText().length()==0||t3.getText().length()==0){
                JOptionPane.showMessageDialog(null,"veuiller saisir les champs obligatoire* ");
                }
                
                 IP Ip = new IP(t1.getText());
                 for(int j=0;j<Graphique.Machines.size();j++){
                 if(Ip.getAdr().equals(Graphique.Machines.get(j).getInt(0).getAdresseIp().getAdr())){ JOptionPane.showMessageDialog(null,"adresse IP deja utiliser ");}}
                 if(Ip.getAdr()==null){ JOptionPane.showMessageDialog(null,"adresse IP incorrrect ");} 
                 Machine i = new Machine(Ip.getAdr());
                 S1.ajouter(i.getInt(0));
                 i.getInt(0).setAdresseMac(m1);
                 i.getInt(0).setGateWay(new IP(t3.getText()));
                 if(i.getInt(0).getGateWay().getAdr()=="0"){ JOptionPane.showMessageDialog(null,"Passrelle incorrrect ");}else{
                 bool=true;}
                 if(bool){f1.hide();}
                   f.remove(b);
//config de la deuxiemme machine                   
                   b3.setBounds(380,40,205,35);
                  f.add(b3);
                   b3.addActionListener( new ActionListener() {
                public void actionPerformed(ActionEvent bi) {
               
//intialization de la fentre du pc 2    
              if(t0.getText().length()==0){
                JOptionPane.showMessageDialog(null,"veuiller saisir le nom de la machine* ");
                }else{
              
        f2.setTitle("Machine :".concat(t0.getText()));
        f2.setSize(400, 400);
        f2.setLocationRelativeTo(null);
        f2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        f2.setVisible(true);
        f2.setLayout(null);
        f2.getContentPane().setBackground(Color.white);
        JLabel l1 = new JLabel("ADRESSE IP*");
        l1.setBounds(40,50,100,30);
        f2.add(l1);
        JTextField t1ip = new JTextField(12);
        t1ip.setBounds(140, 50, 200, 30);
        f2.add(t1ip);
        JLabel l2 = new JLabel("MAC ");
        l2.setBounds(40,95,100,30);
        f2.add(l2);
        MAC m1=new MAC();   
        JTextField t2 = new JTextField(20);
        t2.setText(m1.getMAC());
        t2.setBounds(140,95, 200, 30);
        t2.setEditable(false);
        f2.add(t2);
        JLabel l3 = new JLabel("gateway ");
        l3.setBounds(40,140,100,30);
        f2.add(l3);
        JTextField t3 = new JTextField("0.0.0.0");
        t3.setBounds(140,140, 200, 30);
        f2.add(t3);
        JLabel l4 = new JLabel("activer le routage ");
        l4.setBounds(40,185,200,30);
        f2.add(l4);
        JCheckBox J1 = new JCheckBox("");
        J1.setBounds(170,185, 30, 30);
        J1.setBackground(Color.white);
        if(!J1.isSelected()){
          //  System.out.print("n'est preser");
        }
        f2.add(J1);
        JButton l = new JButton("Ajouter la machine");
        l.setBounds(40,230, 200, 30);
         f2.add(l);
                
        l.addActionListener( new ActionListener() {
        public void actionPerformed(ActionEvent p) {
//verification des contrainte et creation de la machine
                Boolean bool=true;
                if(t1.getText().length()==0||t3.getText().length()==0){bool=false;
                JOptionPane.showMessageDialog(null,"veuiller saisir les champs obligatoire* ");
                }for(int j=0;j<Graphique.Machines.size();j++){
                 if(t1ip.getText().equals(Graphique.Machines.get(j).getInt(0).getAdresseIp().getAdr())){JOptionPane.showMessageDialog(null,"adresse IP deja utiliser ");bool=false; }}
                 
                 IP Ip2 = new IP(t1ip.getText());
                 if(Ip2.getAdr()=="0"){ bool=false;JOptionPane.showMessageDialog(null,"adresse IP incorrrect ");}
                 
                 Machine k = new Machine(Ip2.getAdr());
                 S1.ajouter(k.getInt(0));
                 k.getInt(0).setAdresseMac(m1);
                 k.getInt(0).setGateWay(new IP(t3.getText()));
                 if(k.getInt(0).getGateWay().getAdr()=="0"){ bool=false;JOptionPane.showMessageDialog(null,"Passrelle incorrrect ");}
                 b4.setBorderPainted(false);
                 b4.setBounds(1000,550,60,60);
                 JLabel R1 = new JLabel(f2.getTitle());
                 R1.setBounds(975, 600, 200, 30);
                 if(bool){f2.hide();f.add(b4);f.add(R1); f.remove(t0);
                    f.remove(l0);f.remove(b3);} 
                 b4.addActionListener( new ActionListener() {
                  public void actionPerformed(ActionEvent p) {
//l'ajout de la possibiliter de ping et brancccher ou debrancher pour la fenetre de la machine 2                    
                     t1ip.setEditable(false);
                     f2.remove(l);
                     JButton p0 = new JButton("pinger");
                     p0.setBounds(40,230, 80, 30);
                     f2.add(p0);
                     JTextField TP = new JTextField(12);
                     TP.setBounds(140, 230, 200, 30);
                     f2.add(TP);
                      p0.addActionListener( new ActionListener() {
                      public void actionPerformed(ActionEvent p) {
                           if(TP.getText().length()==0){
                          JOptionPane.showMessageDialog(null,"veuiller enter une adresse a pinger  ");
                           }else{
                               IP ipd = new IP(TP.getText());
                              if(i.envoie2(ipd)){JOptionPane.showMessageDialog(null,"ping envoyer");}else{JOptionPane.showMessageDialog(null,"ping non envoyer");}
                             }                           
                      }});
                        JButton D1 = new JButton("brancher");
                      D1.setBounds(40,300, 100, 30);
                      f2.add(D1);
                      D1.addActionListener( new ActionListener() {
                      public void actionPerformed(ActionEvent p) {
                          
                         if(S1.estDansleSwitch(new IP(t1.getText()))){
                             JOptionPane.showMessageDialog(null,"deja brancher");
                         }else{
                         S1.ajouter(k.getInt(0));
                         }
                      }});
                      JButton D3 = new JButton("débrancher");
                      D3.setBounds(150,300, 130, 30);
                      f2.add(D3);
                      D3.addActionListener( new ActionListener() {
                      public void actionPerformed(ActionEvent p) {
                          
                         if(!S1.estDansleSwitch(new IP(t1.getText()))){
                             JOptionPane.showMessageDialog(null,"n'est pas brancher");
                         }else{
                         S1.debrancher(k.getInt(0));
                         }
                      }});
                      f.remove(t0);
                      f.remove(l0);
                      f2.show();
                     }});
        }});
        }
        }});
////l'ajout de la possibiliter de ping et brancccher ou debrancher   fenetre de la machine 1                  

                   b2.setBorderPainted(false);
                  b2.setBounds(380,550,60,60);
                  JLabel R = new JLabel(f1.getTitle());
                  R.setBounds(355, 600, 200, 30);
                  f.add(R);
                  f.add(b2);
                  b2.addActionListener( new ActionListener() {
                  public void actionPerformed(ActionEvent p) {       
                      f1.remove(l);
                      t1.setEditable(false);
                      JButton p0 = new JButton("pinger");
                      p0.setBounds(40,230, 80, 30);
                      f1.add(p0);
                       JTextField TPU = new JTextField(12);
                             TPU.setBounds(140, 230, 200, 30);
                             f1.add(TPU);
                      p0.addActionListener( new ActionListener() {
                      public void actionPerformed(ActionEvent p) {
                           if(TPU.getText().length()==0){
                          JOptionPane.showMessageDialog(null,"veuiller enter une adresse a pinger  ");
                           }else{
                               IP ipd = new IP(TPU.getText());
                               System.out.print(i.getInt(0).s.nom);
                               if(i.envoie2(ipd)){JOptionPane.showMessageDialog(null,"ping envoyer");}else{JOptionPane.showMessageDialog(null,"ping non envoyer");}
                              
                             }
                          
                          
                      }});
                        JButton D = new JButton("brancher");
                      D.setBounds(40,300, 100, 30);
                      f1.add(D);
                      D.addActionListener( new ActionListener() {
                      public void actionPerformed(ActionEvent p) {
                          
                         if(S1.estDansleSwitch(new IP(t1.getText()))){
                             JOptionPane.showMessageDialog(null,"deja brancher");
                         }else{
                         S1.ajouter(i.getInt(0));
                         }
                      }});
                      JButton D2 = new JButton("débrancher");
                      D2.setBounds(150,300, 130, 30);
                      f1.add(D2);
                      D2.addActionListener( new ActionListener() {
                      public void actionPerformed(ActionEvent p) {
                          
                         if(!S1.estDansleSwitch(new IP(t1.getText()))){
                             JOptionPane.showMessageDialog(null,"n'est pas brancher");
                         }else{
                         S1.debrancher(i.getInt(0));
                         }
                      }});
                      f1.show();
                     }});
                 }});}
       }});
    }//main
}
