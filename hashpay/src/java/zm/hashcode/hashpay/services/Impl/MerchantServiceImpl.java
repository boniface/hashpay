/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.hashpay.services.Impl;

import java.math.BigDecimal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import zm.hashcode.hashpay.infrastructure.factories.market.MarketFactory;
import zm.hashcode.hashpay.model.market.Merchant;
import zm.hashcode.hashpay.model.market.Product;
import zm.hashcode.hashpay.repository.jpa.MerchantDAO;
import zm.hashcode.hashpay.repository.jpa.ProductDAO;
import zm.hashcode.hashpay.services.MerchantService;

/**
 *
 * @author Franky
 */
public class MerchantServiceImpl  implements MerchantService{

    @Autowired
    private MerchantDAO merchantDAO;
    private ProductDAO  productDAO;
    
    
    
    @Override
    public void requestToRegister(String userName, String emailAddres) {
        
    }
    // method to create product for the merchant
    @Override
    public void addProduct(String productDescrption, BigDecimal productPrice, String qty, String token) {
        MarketFactory product = new MarketFactory(); 
        product.createProduct(productDescrption, productPrice, qty, token);
     }

    @Override
    public List<Merchant> listallProductsPublished() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

     @Override
    public Merchant validateProductInventory(String productDescription) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    
    
    /**
     * @return the merchantDAO
     */
    public MerchantDAO getMerchantDAO() {
        return merchantDAO;
    }

    /**
     * @param merchantDAO the merchantDAO to set
     */
    public void setMerchantDAO(MerchantDAO merchantDAO) {
        this.merchantDAO = merchantDAO;
    }

   
}