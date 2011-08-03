/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.hashpay.client.web;

import com.vaadin.Application;
import com.vaadin.terminal.gwt.server.HttpServletRequestListener;
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import zm.hashcode.hashpay.infrastructure.conf.GetContext;


/**
 *
 * @author boniface
 */
public class VaultMain extends Application implements HttpServletRequestListener {

    public HorizontalSplitPanel mainView = new HorizontalSplitPanel();
    private static ThreadLocal<VaultMain> threadLocal = new ThreadLocal<VaultMain>();
    final VerticalLayout rootLayout = new VerticalLayout();
    final Window root = new Window("Hash Pay Application", rootLayout);
    @Autowired
    private AuthenticationManager authenticationManager;
    private ApplicationContext ctx;
    private Authentication auth;

    @Override
    public void init() {
        setInstance(this);
        setTheme("reindeer");
        setMainWindow(new LoginWindow());
    }

    public static VaultMain getInstance() {
        return threadLocal.get();
    }

    // Set the current application instance 	
    public static void setInstance(VaultMain application) {
        if (getInstance() == null) {
            threadLocal.set(application);
        }
    }

    @Override
    public void onRequestStart(HttpServletRequest request, HttpServletResponse response) {
         VaultMain.setInstance(this);
    }

    @Override
    public void onRequestEnd(HttpServletRequest request, HttpServletResponse response) {
        threadLocal.remove();
    }
    
    public Authentication authenticate(String login, String password) throws Exception {

        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(login, password);
        ctx = GetContext.getApplicationContext();
        authenticationManager = (AuthenticationManager) ctx.getBean("authenticationManager");

        setAuth(authenticationManager.authenticate(token));

        if (getAuth() != null) {
            SecurityContextHolder.getContext().setAuthentication(getAuth());
            loadProtectedResources();
            return getAuth();
        }

        throw new Exception("failed to Login");
    }

    /**
     * @return the auth
     */
    public Authentication getAuth() {
        return auth;
    }

    /**
     * @param auth the auth to set
     */
    public void setAuth(Authentication auth) {
        this.auth = auth;
    }

    private void loadProtectedResources() {
         // Main window is the primary browser window
        final Window main = new Window("Hello window");
        setMainWindow(main);
        // "Hello world" text is added to window as a Label component
        main.addComponent(new Label("Hello World!"));
    }
}
