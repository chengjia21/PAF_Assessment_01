package vttp2023.batch3.assessment.paf.bookings.repositories;

import java.lang.annotation.Native;
import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

@Repository
public class ListingsRepository {
	@Autowired
	private MongoTemplate template;



	// TODO: Task 2


	// Native MongoDB query to find all the countries: db.getCollection("listingsTEST").distinct("address.country")

public List<String> getCountries() {

		return template.findDistinct(new Query(), Constants.A_ADDRESS, Constants.C_LISTINGS, String.class);
		
		// template.executeCommand(null)
	}


		public List<Document> getCountries2() {
			Criteria criteria = Criteria.where(Constants.A_OBJECTID).exists(true);
			Query query = Query.query(criteria);
			
			query.fields()
			.include(Constants.A_ADDRESS)
			.include(Constants.A_COUNTRY);

			return template.find(query, Document.class, Constants.C_LISTINGS);

		// 	.limit(limit)
		// 	.skip(offset)
		// 	.with(Sort.by(Sort.Direction.ASC, "name"));
		// return template.executeCommand(getCollection("listingsTEST").distinct("address.country"));

	}



	// TODO: Task 3

	// Native MongoDB Query : db.getCollection("listingsTEST").find({"address.country" : 'Australia'}, {"address.street":1, price:1, "images.picture_url":1}).sort({ price : -1 })

		public List<Document> searchAccomodations(String countryToSearch, double minPrice, double maxPrice, double numPersons) {
		Criteria criteria = Criteria.where(Constants.A_COUNTRY)
				.exists(true);

		Query query = Query.query(criteria)
			.with(Sort.by(Direction.DESC, Constants.A_PRICE));
		query.fields()
			.include(Constants.A_ADDRESS, Constants.A_PRICE, Constants.A_IMAGES)
			.exclude(Constants.A_OBJECTID);

		return template.find(query, Document.class, Constants.C_LISTINGS);
	}


	// TODO: Task 4

	// TODO: Task 5

}
