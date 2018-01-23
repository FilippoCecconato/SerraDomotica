/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import View.Manovali;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import javax.swing.JOptionPane;

/**
 *
 * @author filippocecconato
 */
public class Controllore implements ActionListener{
    Manovali x;
    DatagramSocket ds;

    public Controllore(Manovali x) {
        this.x = x;
        this.x.getjButton1().addActionListener(this);
        this.x.getjButton2().addActionListener(this);
        this.x.getjButton3().addActionListener(this);
    }
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==x.getjButton2()){ //Bottone seleziona tutto
            System.out.println("Sono nella selezione");
            x.getjCheckBox1().setSelected(true);
            x.getjCheckBox2().setSelected(true);
            x.getjCheckBox3().setSelected(true);
            x.getjCheckBox4().setSelected(true);
            x.getjCheckBox5().setSelected(true);
            x.getjCheckBox6().setSelected(true);
            x.getjCheckBox7().setSelected(true);
            x.getjCheckBox8().setSelected(true);
        }
        if(e.getSource()==x.getjButton3()){ //Bottone deseleziona tutto
            System.out.println("Sono nella deselezione");
            x.getjCheckBox1().setSelected(false);
            x.getjCheckBox2().setSelected(false);
            x.getjCheckBox3().setSelected(false);
            x.getjCheckBox4().setSelected(false);
            x.getjCheckBox5().setSelected(false);
            x.getjCheckBox6().setSelected(false);
            x.getjCheckBox7().setSelected(false);
            x.getjCheckBox8().setSelected(false);
        }
        
        if(e.getSource()==x.getjButton1()){ //Bottone per l'invio
            
            if(!x.getjTextField1().getText().equals("")&& !x.getjTextField2().getText().equals("")){
                
		try {
                    ds = new DatagramSocket();          
                    byte[] bufferOut = new byte[2];
                    Integer cont = 0;
                    Integer lum = 0;
			
                    if(x.getjCheckBox1().isSelected())
			cont += 1;
                    if(x.getjCheckBox2().isSelected())
			cont += 2;
                    if(x.getjCheckBox3().isSelected())
			cont += 4;
                    if(x.getjCheckBox4().isSelected())
			cont += 8;
                    if(x.getjCheckBox5().isSelected())
			cont += 16;
                    if(x.getjCheckBox6().isSelected())
			cont += 32;
                    if(x.getjCheckBox7().isSelected())
			cont += 64;
                    if(x.getjCheckBox8().isSelected())
			cont += 128;
                    
                    lum = x.getjSlider1().getValue();
                    bufferOut[0] = cont.byteValue();
                    bufferOut[1] = lum.byteValue();
                    System.out.println("ip "+ x.getjTextField1().getText()+" porta " + x.getjTextField2().getText());
                    try {
                        System.out.println("ip "+ x.getjTextField1().getText()+" porta " + x.getjTextField2().getText());
                        DatagramPacket dp = new DatagramPacket(bufferOut, bufferOut.length, InetAddress.getByName(x.getjTextField1().getText()), Integer.parseInt(x.getjTextField2().getText()));
                        ds.send(dp);
                    } catch (NumberFormatException | IOException e1) {
                    }

		} catch (NumberFormatException | SocketException e1) {}
            }
            else{
                JOptionPane.showMessageDialog(x, "IP o PORTA MANCANTI", "ATTENZIONE", 2);
            }
        }
		
        
    }
    
}
