package vttp2023.batch3.assessment.paf.bookings.services;

import java.util.List;

import org.bson.Document;
import org.jcp.xml.dsig.internal.dom.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vttp2023.batch3.assessment.paf.bookings.models.Listings;
import vttp2023.batch3.assessment.paf.bookings.repositories.ListingsRepository;

@Service
public class ListingsService {

	@Autowired
	private ListingsRepository listingsRepo;


	// TODO: Task 2

	public List<String> getCountries() {
		List<String> countries = listingsRepo.getCountries();
		return countries;
	}

	public List<Document> getCountries2() {
		return listingsRepo.getCountries2();
	}


	// TODO: Task 3

		public List<Document> searchAccomodations(String countryToSearch, double minPrice, double maxPrice, double numPersons) {
		return listingsRepo.searchAccomodations(countryToSearch, minPrice, maxPrice, numPersons);
	
	}

	

	// TODO: Task 4

	// TODO: Task 5

}
