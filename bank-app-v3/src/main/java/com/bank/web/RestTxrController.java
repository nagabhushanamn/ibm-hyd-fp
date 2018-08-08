package com.bank.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bank.service.TxrService;

@RestController
public class RestTxrController {

	@Autowired
	private TxrService txrService;

	@RequestMapping(value = "/api/txr", method = RequestMethod.POST)
	public TxrResponse doTxr(@RequestBody TxrRequest request, Model model) {
		txrService.txr(request.getAmount(), request.getFromAccNum(), request.getToAccNum());
		TxrResponse response = new TxrResponse();
		response.setMessage("Txr success");
		//model.addAttribute("status", response);
		//return "txr-status";
		return response;
	}

}
