
import Control.Controllore;
import View.Manovali;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alunno
 */
public class Client {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Manovali a = new Manovali();
        Controllore b= new Controllore(a);
        a.setVisible(true);
    }
    
}
