
import Control.Controllore;
import View.Serra;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alunno
 */
public class Server {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Serra a=new Serra();
        Controllore b = new Controllore(a);
        a.setVisible(true);
    }
    
}
