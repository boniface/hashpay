/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.hashpay.client.mobile;

import java.math.BigDecimal;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import zm.hashcode.hashpay.client.mobile.model.AccountBean;
import zm.hashcode.hashpay.client.mobile.model.ProductBean;
import zm.hashcode.hashpay.infrastructure.exceptions.InsufficientBalanceException;
import zm.hashcode.hashpay.infrastructure.exceptions.InvalidVoucherException;
import zm.hashcode.hashpay.model.market.EnumProductStatus;
import zm.hashcode.hashpay.model.market.EnumTokenType;
import zm.hashcode.hashpay.model.vouchers.CurrencyType;
import zm.hashcode.hashpay.repository.jpa.AccountDAO;
import zm.hashcode.hashpay.repository.jpa.ProductDAO;
import zm.hashcode.hashpay.services.ProductService;
import zm.hashcode.hashpay.services.VoucherService;

/**
 *
 * @author Franky
 */
@Controller
@RequestMapping(value = "/product/*")
public class ProductController {
    
    @Autowired
    private ProductService productService;
    private VoucherService vourcherService;
    private ProductDAO productDAO;
    private AccountDAO accountDAO;

    
    @RequestMapping(value = "createproduct.html", method = RequestMethod.GET, params = "new")
    public String createProduct(Model model) {
       ProductBean product = new ProductBean();
       model.addAttribute(product);
       productService.createProduct(product.getProductSerialNumber(), product.getDescription(), BigDecimal.ZERO, EnumProductStatus.SOLD, EnumTokenType.STATIC, CurrencyType.ZMK);
       return "product";
    }
    
    @RequestMapping(value = "createproducts.html", method = RequestMethod.GET, params = "new")
    public String createProducts(Model model) {
       ProductBean product = new ProductBean();
       model.addAttribute(product);
       productService.createProducts(product.getProductSerialNumber(), product.getDescription(), BigDecimal.ZERO, EnumProductStatus.SOLD, EnumTokenType.STATIC, CurrencyType.ZMK,product.getNumber());
       return "product";
    }
       
    
    @RequestMapping(value = "buyProduct.html", method = RequestMethod.GET)
    public String buyProduct(Model model) {
        ProductBean product = new ProductBean();
        AccountBean account = new AccountBean();
        model.addAttribute(product);
        model.addAttribute(account);
        
      try{
        productService.buyProduct(accountDAO.find(account.getId()), productDAO.find(product.getId()));
            
        } catch (InsufficientBalanceException ex) {
            Logger.getLogger(ProductController.class.getName()).log(Level.SEVERE, null, ex);
        }
        model.addAttribute("message", "Product has been purchased");
      
        return "message";
    }
    
    
       @RequestMapping(value = "claimProduct.html", method = RequestMethod.GET)
        public String claimProduct(Model model) {
         AccountBean account = new AccountBean();
         ProductBean product = new ProductBean();
         model.addAttribute(account);  
         model.addAttribute(product);
        try {
            productService.validatedProduct(product.getTokenNumber(),product.getTokenNumber(), accountDAO.find(account.getId()));
        } catch (InvalidVoucherException ex) {
            Logger.getLogger(ProductController.class.getName()).log(Level.SEVERE, null, ex);
        }
           model.addAttribute("message", "Product has been claimed");
           
          return "message";
       }
       
    /**
     * @return the productService
     */
    public ProductService getProductService() {
        return productService;
    }

    /**
     * @param productService the productService to set
     */
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    /**
     * @return the vourcherService
     */
    public VoucherService getVourcherService() {
        return vourcherService;
    }

    /**
     * @param vourcherService the vourcherService to set
     */
    public void setVourcherService(VoucherService vourcherService) {
        this.vourcherService = vourcherService;
    }
    
    
    
}
