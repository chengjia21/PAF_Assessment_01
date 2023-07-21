package vttp2023.batch3.assessment.paf.bookings.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import vttp2023.batch3.assessment.paf.bookings.models.Listings;
import vttp2023.batch3.assessment.paf.bookings.repositories.ListingsRepository;
import vttp2023.batch3.assessment.paf.bookings.services.ListingsService;

@Controller
@RequestMapping
public class ListingsController {

	@Autowired
	private ListingsRepository listingsRepo;

	@Autowired
	private ListingsService listingsService;

	// TODO: Task 2
	@GetMapping(path = { "/", "/index.html" })
	public ModelAndView getView1() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("view1");
		mav.addObject("countries", listingsService.getCountries());
		mav.setStatus(HttpStatusCode.valueOf(200));

		// System.out.println(listingsService.getCountries().toString());
		// System.out.println(listingsService.getCountries());
		// System.out.println(listingsService.getCountries2().toString());

		return mav;
	}

	// TODO: Task 3
	@GetMapping(path = { "/search" })
	public ModelAndView getView2(@RequestParam String country, @RequestParam double numPersons,
			@RequestParam double minPrice, @RequestParam double maxPrice) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("view2");
		mav.addObject("searchAccomodations",
				listingsService.searchAccomodations(country, minPrice, maxPrice, numPersons));

		mav.setStatus(HttpStatusCode.valueOf(200));

		return mav;
	}

	// TODO: Task 4

	// TODO: Task 5

}
