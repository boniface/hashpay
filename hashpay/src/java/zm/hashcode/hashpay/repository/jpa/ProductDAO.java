/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.hashpay.repository.jpa;

import zm.hashcode.hashpay.model.market.Product;

import zm.hashcode.hashpay.repository.DAO;

/**
 *
 * @author Peter Phillip
 */
public interface ProductDAO  extends DAO<Product, Long> {

    public Product getByPropertyName(String string, Long valueOf);
    
}
