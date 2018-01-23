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
    public Serra f;

    public Connessione(Serra sf) {
        this.f = sf;
    }
	
	
	
	@Override
	public void run() {
		try {
			DatagramSocket scserver = new DatagramSocket(Integer.parseInt(f.getjTextField9().getText()));
			byte[] buffIN = new byte[2];
			short lum,stanza;
			
			while(true){
                            System.out.println("Attesa del pacchetto");
                            DatagramPacket dp = new DatagramPacket(buffIN, buffIN.length);
                            scserver.receive(dp); 
                            System.out.println("Pacchetto ricevuto");
                            stanza = (short) dp.getData()[0];
                            lum = (short) dp.getData()[1];

				ImpostaStanze(stanza, lum);				
			}
		} catch (SocketException e1) {e1.printStackTrace();} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	public void ImpostaStanze(short stanza,short lum){
		String df = null;
		int x;
		x = lum*255/100;
		df=this.descrizione(x);
                System.out.println("luminosita " + lum);
		for(int i=1,o=1;i<255;i<<=1,o++){
			if((stanza&i)==i){
				if(o==1){f.getjTextField1().setText(df);}
				if(o==2){f.getjTextField2().setText(df);}
				if(o==3){f.getjTextField3().setText(df);}
				if(o==4){f.getjTextField4().setText(df);}
				if(o==5){f.getjTextField5().setText(df);}
				if(o==6){f.getjTextField6().setText(df);}
				if(o==7){f.getjTextField7().setText(df);}
				if(o==8){f.getjTextField8().setText(df);}
			}
		}
	}
	public String descrizione(int lum){
		String print=null;
		print= "Luce: " + lum;
		return print;
	}
    
}
