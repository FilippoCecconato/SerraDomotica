/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

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
    public ServerFrame sf;

    public Connessione(ServerFrame sf) {
        this.sf = sf;
    }
	
	
	
	@Override
	public void run() {
		try {
			DatagramSocket scserver = new DatagramSocket(Integer.parseInt(f.getTxtPortaServer().getText()));
			byte[] buffIN = new byte[2];
			short lum,stanza;
			
			while(true){
				DatagramPacket dp = new DatagramPacket(buffIN, buffIN.length);
				scserver.receive(dp); 
				
				stanza = (short) dp.getData()[0];
				lum = (short) dp.getData()[1];

				ImpostaStanze(stanza, lum);				
			}
		} catch (SocketException e1) {e1.printStackTrace();} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	public void ImpostaStanze(short stanza,short lum){
		DefaultListModel<String> df = null;
		int x;
		x = lum*255/100;
		df=this.descrizione(x);
		for(int i=1,o=1;i<255;i<<=1,o++){
			if((stanza&i)==i){
				if(o==1){f.getList1().setModel(df);}
				if(o==2){f.getList2().setModel(df);}
				if(o==3){f.getList3().setModel(df);}
				if(o==4){f.getList4().setModel(df);}
				if(o==5){f.getList5().setModel(df);}
				if(o==5){f.getList6().setModel(df);}
				if(o==7){f.getList7().setModel(df);}
				if(o==8){f.getList8().setModel(df);}
			}
		}
	}
	public DefaultListModel<String> descrizione(int lum){
		DefaultListModel<String> print=new DefaultListModel<String>();
		print.addElement("Luce: " + lum );
		return print;
	}
    
}
