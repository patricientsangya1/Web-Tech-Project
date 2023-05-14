package com.patricien.webtech.accounts.controllers;

import com.patricien.webtech.accounts.models.InvoiceStatus;
import com.patricien.webtech.accounts.services.InvoiceStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class InvoiceStatusController {

	@Autowired private InvoiceStatusService invoiceStatusService;
	
	//Get All InvoiceStatuss
	@GetMapping("/accounts/invoiceStatuses")
	public String findAll(Model model){		
		model.addAttribute("invoiceStatuses", invoiceStatusService.findAll());
		return "/accounts/invoiceStatuses";
	}	
	
	@RequestMapping("/accounts/invoiceStatus/{id}")
	@ResponseBody
	public Optional<InvoiceStatus> findById(@PathVariable Integer id)
	{
		return invoiceStatusService.findById(id);
	}
	
	//Add InvoiceStatus
	@PostMapping(value="/accounts/invoiceStatuses")
	public String addNew(InvoiceStatus invoiceStatus) {
		invoiceStatusService.save(invoiceStatus);
		return "redirect:/accounts/invoiceStatuses";
	}	

	@RequestMapping(value="accounts/invoiceStatus/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
	public String delete(@PathVariable Integer id) {
		invoiceStatusService.delete(id);
		return "redirect:/invoiceStatuses";
	}
}
