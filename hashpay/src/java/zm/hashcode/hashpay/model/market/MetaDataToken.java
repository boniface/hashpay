/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.hashpay.model.market;

import java.io.Serializable;
import javax.persistence.Embeddable;
import javax.persistence.Entity;

/**
 *
 * @author Peter Phillip
 */
@Embeddable
public class MetaDataToken implements Serializable {
  private static final long serialVersionUID = 1L;
  private String browser;
  private String clientDevice;
  private String location;
  private String ip;
  private String isp;
  private String timeStamp;

    public String getBrowser() {
        return browser;
    }

    public void setBrowser(String browser) {
        this.browser = browser;
    }

    public String getClientDevice() {
        return clientDevice;
    }

    public void setClientDevice(String clientDevice) {
        this.clientDevice = clientDevice;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getIsp() {
        return isp;
    }

    public void setIsp(String isp) {
        this.isp = isp;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }
     
  
}
