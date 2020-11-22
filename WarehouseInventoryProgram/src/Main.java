
import boundary.Login;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ryancavanagh
 */
public class Main {
    
    public static void main(String[] args) {
        new Login().setVisible(true);
        
        Entity.Product test = new Entity.Product(new Entity.ProductPK("p1", "warehouse"), 32);
    }
    
}
