/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import View.Serra;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import javax.swing.DefaultListModel;

/**
 *
 * @author filippocecconato
 */
public class Connessione implements Runnable{
    public Serra s;

    public Connessione(Serra s) {
        this.s = s;
    }
	
	
	
	@Override
	public void run() {
		try {
			DatagramSocket scserver = new DatagramSocket(Integer.parseInt(s.getjTextField9().getText()));
			byte[] buffIN = new byte[4];
			short lum,stanza,temp,um;
			
			while(true){
                            System.out.println("Attesa del pacchetto");
                            DatagramPacket dp = new DatagramPacket(buffIN, buffIN.length);
                            scserver.receive(dp); 
                            System.out.println("Pacchetto ricevuto");
                            stanza = (short) dp.getData()[0];
                            lum = (short) dp.getData()[1];
                            temp = (short) dp.getData()[2];
                            um = (short) dp.getData()[3];
                            Impostazione(stanza, lum, temp, um);				
			}
		} catch (SocketException e1) {e1.printStackTrace();} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	public void Impostazione(short stanza,short lum, short temp, short um){
		String df = null;
		int x;
		x = lum*255/100;
		df=this.descrizione(x,temp,um);
                System.out.println("luminosita " + lum);
		for(int i=1,o=1;i<255;i<<=1,o++){
			if((stanza&i)==i){
				if(o==1){s.getjTextField1().setText(df);}
				if(o==2){s.getjTextField2().setText(df);}
				if(o==3){s.getjTextField3().setText(df);}
				if(o==4){s.getjTextField4().setText(df);}
				if(o==5){s.getjTextField5().setText(df);}
				if(o==6){s.getjTextField6().setText(df);}
				if(o==7){s.getjTextField7().setText(df);}
				if(o==8){s.getjTextField8().setText(df);}
			}
		}
	}
	public String descrizione(int lum,short temp,short um){
		String print=null;
		print= "L:" + lum +"\nT:" + temp + "\nU:" + um;
		return print;
	}
    
}
