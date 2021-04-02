package com.ecommerce.pricing.controller;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.pricing.events.PricingEvent;
import com.ecommerce.pricing.model.Pricing;
import com.ecommerce.pricing.service.PricingService;

@RestController
@RequestMapping(value="/account")
public class PricingController extends AbstractController
{
 
   private PricingService  pricingService;
   
   public PricingController(PricingService pricingService)
   {
	   this.pricingService = pricingService;
   }

   @PostMapping("/pricing")
   public ResponseEntity<?> createPricing(@RequestBody Pricing Pricing)
   {
      Pricing savedPricing = pricingService.save(Pricing);
      PricingEvent PricingCreatedEvent = new PricingEvent(this, "PricingCreatedEvent", savedPricing);
      eventPublisher.publishEvent(PricingCreatedEvent);
      return ResponseEntity.ok().body("New Pricing has been saved with ID:" + savedPricing.getId());
   }

   @GetMapping("/pricing/{id}")
   @ResponseBody
   public Pricing getPricing(@PathVariable("id") long id)
   {
	  Optional<Pricing> returnedPricing = pricingService.get(id);
	  Pricing Pricing  = returnedPricing.get(); 
	  
	  PricingEvent PricingCreatedEvent = new PricingEvent(this, "PricingRetrievedEvent", Pricing);
      eventPublisher.publishEvent(PricingCreatedEvent);
      return Pricing;
   }
   
 

   @GetMapping("/pricing")
   public @ResponseBody Page<Pricing> getCategoriesByPage(
		   @RequestParam(value="pagenumber", required=true, defaultValue="0") Integer pageNumber,
		   @RequestParam(value="pagesize", required=true, defaultValue="20") Integer pageSize)
   {
      Page<Pricing> pagedPricings = pricingService.getPricingsByPage(pageNumber, pageSize);
      return pagedPricings;
   }

   @PutMapping("/pricing/{id}")
   public ResponseEntity<?> updatePricing(@PathVariable("id") long id, @RequestBody Pricing pricing)
   {
	  checkResourceFound(this.pricingService.get(id));
	  pricingService.update(id, pricing);
      return ResponseEntity.ok().body("Pricing has been updated successfully.");
   }

   @DeleteMapping("/pricing/{id}")
   public ResponseEntity<?> deletePricing(@PathVariable("id") long id)
   {
	  checkResourceFound(this.pricingService.get(id));
	  pricingService.delete(id);
      return ResponseEntity.ok().body("Pricing has been deleted successfully.");
   }
}
