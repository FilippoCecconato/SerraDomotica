package Control;


import Model.Connessione;
import View.Serra;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author filippocecconato
 */
public class Controllore implements ActionListener{
    Serra x;
    Thread t;

    public Controllore(Serra x) {
        this.x = x;
        this.x.getjButton1().addActionListener(this);
        t=new Thread(new Connessione(x));
    }
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==x.getjButton1()){
            if(!x.getjTextField9().getText().equals("")){
                System.out.println("Attendo dati");
                t.start();
                
            }else{
		JOptionPane.showMessageDialog(x, "PORTA MANCANTE", "ATTENZIONE", 2);
            }
            
            
        }
    }
    
    
}
