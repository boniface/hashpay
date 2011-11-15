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
import org.springframework.web.servlet.ModelAndView;
import zm.hashcode.hashpay.client.mobile.model.AccountBean;
import zm.hashcode.hashpay.client.mobile.model.ProductBean;
import zm.hashcode.hashpay.infrastructure.exceptions.InsufficientBalanceException;
import zm.hashcode.hashpay.infrastructure.exceptions.InvalidVoucherException;
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

    
    @RequestMapping(value = "createproduct.html", method = RequestMethod.GET, params = "new")
    public String createProduct(Model model) {
       ProductBean product = new ProductBean();
       model.addAttribute(product);
       productService.createProduct(product.getProductSerialNumber(), product.getDescription(), BigDecimal.ZERO, EnumProductStatus.SOLD, EnumTokenType.STATIC, CurrencyType.ZMK);
       return "product";
    }
    
    @RequestMapping(value ="productList.html", method = RequestMethod.GET)
    public ModelAndView test(Model model) {
       //ProductBean product = new ProductBean();
       //model.addAttribute(product);
       //productService.createProduct(product.getProductSerialNumber(), product.getDescription(), BigDecimal.ZERO, EnumProductStatus.SOLD, EnumTokenType.STATIC, CurrencyType.ZMK);
        List<Product> test =  productService.allproductbyDescr("");
        ModelAndView mv = new ModelAndView();
        mv.addObject("list", test);
        mv.setViewName("productList");
       return mv;
    }
    
    @RequestMapping(value ="productList.html", method = RequestMethod.GET)
    public ModelAndView listallbusTicket(Model model) {
        List<Product> product =  productService.allproductbyDescr("Bus-ticket");
        ModelAndView mv = new ModelAndView();
        mv.addObject("bustickets", product);
        mv.setViewName("productList");
       return mv;
    }
    
     @RequestMapping(value ="productList.html", method = RequestMethod.GET)
    public ModelAndView listallAirtime(Model model) {
        List<Product> product =  productService.allproductbyDescr("Air-time");
        ModelAndView mv = new ModelAndView();
        mv.addObject("airtime", product);
        mv.setViewName("productList");
       return mv;
    }
    
   @RequestMapping(value ="productList.html", method = RequestMethod.GET)
    public ModelAndView listallElectricty(Model model) {
        List<Product> product =  productService.allproductbyDescr("Electricity");
        ModelAndView mv = new ModelAndView();
        mv.addObject("Electricity", product);
        mv.setViewName("productList");
       return mv;
    }
    
   @RequestMapping(value ="productList.html", method = RequestMethod.GET)
    public ModelAndView listallMovieTicket(Model model) {
        List<Product> product =  productService.allproductbyDescr("Movie-Ticket");
        ModelAndView mv = new ModelAndView();
        mv.addObject("movie", product);
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
    public String buyProduct(Model model) throws InsufficientBalanceException {
        ProductBean product = new ProductBean();
        AccountBean account = new AccountBean();
        model.addAttribute(product);
        model.addAttribute(account);
        Product prod = productService.buyProduct(accountService.findAccount(account.getAccountNumber()),productService.findProduct(product.getId()));
        model.addAttribute("message", "Product has been purchased" + prod.getProductSerialNumber().toString());
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
