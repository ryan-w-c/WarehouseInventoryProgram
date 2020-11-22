
import Entity.Salesperson;
import boundary.Login;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

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
        
        EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("WarehouseInventoryProgramPU");
      
        EntityManager entitymanager = emfactory.createEntityManager();
        entitymanager.getTransaction().begin();
        Salesperson employee = new Salesperson( ); 
        employee.setFristname("Ryan");
        employee.setLastname( "C" );
        employee.setAddress("12345 street");
        employee.setCity("city");
        employee.setEmail("myemail");
        employee.setState("CA");
        employee.setCommissionrate(.5);
        employee.setPhone("phone");
        employee.setSalespersonid(1);
        employee.setZip(90000);
        employee.setTotalsales(0.0);
        employee.setTotalcommission(0.0);
        
//        employee.setDeg( "Technical Manager" );

        entitymanager.persist(employee);
        entitymanager.getTransaction().commit();

        entitymanager.close();
        emfactory.close();
        
//        Entity.Product test = new Entity.Product(new Entity.ProductPK("p1", "warehouse"), 32);
    }
    
}
