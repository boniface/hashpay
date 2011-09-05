/*Developer: Peter Phillip - Cubetec 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.hashcode.hashpay.infrastructure.factories.country;

import zm.hashcode.hashpay.model.country.*;

/**
 *
 * @author Peter Phillip
 */
public class CountryFactory {
    
      
      public class Builder{
        //city
        public String cityName;
        public String cityCode;
        public Suburb suburb; 
        //Country
        public String countryName;
        public String countryCode;
        public Province province;
        
        //District
        public String districtName;
        public String districtCode;
        public City city;
        //Province
        public String provinceName;
        public String provinceCode;
        public District district;
        
        //Suburb
        public String suburbName;
        public String suburbCode;

         public Builder(String cName, String cCode) {
            this.countryName = cName;
            this.countryCode = cCode;
        }
        
        public Builder CityName(String cityName) {
            this.cityName = cityName;
            return this;
        }

        public Builder CityCode(String cityCode) {
            this.cityCode = cityCode;
            return this;
        }

        public Builder CountryName(String countryName) {
            this.countryName = countryName;
            return this;
        }

        public Builder CountryCode(String countryCode) {
            this.countryCode = countryCode;
            return this;
        }

        public Builder DistrictName(String districtName) {
            this.districtName = districtName;
            return this;
        }

        public Builder DistrictCode(String districtCode) {
            this.districtCode = districtCode;
            return this;
        }

        public Builder ProvinceName(String provinceName) {
            this.provinceName = provinceName;
            return this;
        }

        public Builder ProvinceCode(String provinceCode) {
            this.provinceCode = provinceCode;
            return this;
        }

        public Builder SuburbName(String suburbName) {
            this.suburbName = suburbName;
            return this;
        }

        public Builder SuburbCode(String suburbCode) {
            this.suburbCode = suburbCode;
            return this;
        }
        
        public Country build(){
         return getCountry(this);
       }
     
      }
      
   
     private Country getCountry(Builder builder){
     
    
     //Country
     Country country = new Country();
     country.setName(builder.countryName);
     country.setCode(builder.countryCode);
     country.setProvince(builder.province);
    
     //city
     City city = new City();
     city.setName(builder.cityName);
     city.setCode(builder.cityCode);
     city.setDisrict(builder.district);
     
     //District
     District district = new District();
     district.setName(builder.districtName);
     district.setCode(builder.districtCode);
     district.setSuburb(builder.suburb);
     //Province   
     Province province = new Province();
     province.setCode(builder.provinceName);
     province.setName(builder.provinceCode);
     province.setCity(builder.city);
     
    //Suburb
     Suburb suburb = new Suburb();
     suburb.setName(builder.suburbName);
     suburb.setCode(builder.suburbCode);
       
     return country;
    }
    
}
