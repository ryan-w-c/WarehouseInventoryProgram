/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

/**
 *
 * @author zubin
 */
public class ControlFactory {
    CustomerControl Customer;
    InvoiceControl Invoice;
    LoginControl Login;
    ProductControl Product;
    SalespersonControl Salesperson;
    WarehouseControl Warehouse;
    OrderItemControl OrderItem;
    public ControlFactory (){
        Customer  = new CustomerControl();
        Invoice = new InvoiceControl();
        Login = new LoginControl();
        Product = new ProductControl();
        Salesperson = new SalespersonControl();
        Warehouse  = new WarehouseControl();
        OrderItem = new OrderItemControl();
    } 

    public CustomerControl getCustomer() {
        return Customer;
    }

    public InvoiceControl getInvoice() {
        return Invoice;
    }

    public LoginControl getLogin() {
        return Login;
    }

    public ProductControl getProduct() {
        return Product;
    }

    public SalespersonControl getSalesperson() {
        return Salesperson;
    }

    public WarehouseControl getWarehouse() {
        return Warehouse;
    }
    
    public OrderItemControl getOrderItem() {
        return OrderItem;
    }
    
    
}
