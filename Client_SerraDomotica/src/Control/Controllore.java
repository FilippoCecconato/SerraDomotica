/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import View.Manovali;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.DatagramSocket;

/**
 *
 * @author filippocecconato
 */
public class Controllore implements ActionListener{
    Manovali x;
    DatagramSocket ds;

    public Controllore(Manovali x, DatagramSocket ds) {
        this.x = x;
        this.ds = ds;
        x.getjButton1().addActionListener(this);
        x.getjButton2().addActionListener(this);
        x.getjButton3().addActionListener(this);
    }
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==x.getjButton2()){ //Bottone seleziona tutto
            x.getjCheckBox1().setSelected(true);
            x.getjCheckBox2().setSelected(true);
            x.getjCheckBox3().setSelected(true);
            x.getjCheckBox4().setSelected(true);
            x.getjCheckBox5().setSelected(true);
            x.getjCheckBox6().setSelected(true);
            x.getjCheckBox7().setSelected(true);
            x.getjCheckBox8().setSelected(true);
        }
        else if(e.getSource()==x.getjButton3()){ //Bottone deseleziona tutto
            x.getjCheckBox1().setSelected(false);
            x.getjCheckBox2().setSelected(false);
            x.getjCheckBox3().setSelected(false);
            x.getjCheckBox4().setSelected(false);
            x.getjCheckBox5().setSelected(false);
            x.getjCheckBox6().setSelected(false);
            x.getjCheckBox7().setSelected(false);
            x.getjCheckBox8().setSelected(false);
        }    
        
    }
    
}
