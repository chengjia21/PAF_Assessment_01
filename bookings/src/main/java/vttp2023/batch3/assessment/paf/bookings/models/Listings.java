package vttp2023.batch3.assessment.paf.bookings.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Listings {
    private int _id;
    private String country;
    private String address;
    private double price;
    private String imageURL;



// For the form input
    private String countryToSearch;
    private double minPrice;
    private double maxPrice;
    private double numPersons;

    
    public Listings(String countryToSearch, double minPrice, double maxPrice, double numPersons) {
        this.countryToSearch = countryToSearch;
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
        this.numPersons = numPersons;
    }


    
   


 



    
}
