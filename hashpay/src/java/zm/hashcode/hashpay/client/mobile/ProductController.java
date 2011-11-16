/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.hashpay.client.mobile;

import java.math.BigDecimal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import zm.hashcode.hashpay.client.mobile.model.AccountBean;
import zm.hashcode.hashpay.client.mobile.model.ProductBean;
import zm.hashcode.hashpay.client.mobile.users.UserInformation;
import zm.hashcode.hashpay.infrastructure.exceptions.InsufficientBalanceException;
import zm.hashcode.hashpay.infrastructure.exceptions.InvalidVoucherException;
import zm.hashcode.hashpay.model.accounts.Account;
import zm.hashcode.hashpay.model.market.EnumProductStatus;
import zm.hashcode.hashpay.model.market.EnumTokenType;
import zm.hashcode.hashpay.model.market.Product;
import zm.hashcode.hashpay.model.vouchers.CurrencyType;
import zm.hashcode.hashpay.services.AccountService;
import zm.hashcode.hashpay.services.ProductService;

/**
 *
 * @author Thozamile.Sikwata
 */
@Controller
@RequestMapping(value = "/product/*")
public class ProductController {
    @Autowired
    private ProductService productService;
     
    @Autowired
    private AccountService accountService;
    private String username;

    
    @RequestMapping(value = "createproduct.html", method = RequestMethod.GET, params = "new")
    public String createProduct(Model model) {
       ProductBean product = new ProductBean();
       model.addAttribute(product);
       productService.createProduct(product.getProductSerialNumber(), product.getDescription(), BigDecimal.ZERO, EnumProductStatus.SOLD, EnumTokenType.STATIC, CurrencyType.ZMK);
       return "product";
    }
    
    @RequestMapping(value ="productList.html", method = RequestMethod.GET)
    public ModelAndView test(@RequestParam("id")String id,Model model) {
       //ProductBean product = new ProductBean();
       //model.addAttribute(product);
       //productService.createProduct(product.getProductSerialNumber(), product.getDescription(), BigDecimal.ZERO, EnumProductStatus.SOLD, EnumTokenType.STATIC, CurrencyType.ZMK);
        List<Product> test =  productService.allproductbyDescr(id);
        ModelAndView mv = new ModelAndView();
        mv.addObject("list", test);
        mv.setViewName("productList");
       return mv;
    }
    
    
    
    
    @RequestMapping(value = "createproducts.html", method = RequestMethod.GET, params = "new")
    public String createProducts(Model model) {
       ProductBean product = new ProductBean();
       model.addAttribute(product);
       productService.createProducts(product.getProductSerialNumber(), product.getDescription(), BigDecimal.ZERO, EnumProductStatus.SOLD, EnumTokenType.STATIC, CurrencyType.ZMK,product.getNumber());
       return "product";
    }
       
    
    @RequestMapping(value = "buyProduct.html", method = RequestMethod.GET)
    public String buyProduct(@RequestParam("id")String id,Model model) throws InsufficientBalanceException {
        UserInformation name = new UserInformation();
        username = name.credentials();
        Account account = accountService.userAccount(username);
        Product product = productService.findProduct(id);
        Product prod = productService.buyProduct(account,product);
        model.addAttribute("message", "Product has been purchased" + prod.getTokenNumber().toString());
        return "message";
    }
    
    
       @RequestMapping(value = "claimProduct.html", method = RequestMethod.GET)
        public String claimProduct(Model model) throws InvalidVoucherException {
         AccountBean account = new AccountBean();
         ProductBean product = new ProductBean();
         model.addAttribute(account);  
         model.addAttribute(product);
         productService.validatedProduct(product.getTokenNumber(),product.getTokenNumber(), accountService.findAccount(account.getAccountNumber()));
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
    
    
    
    
}
