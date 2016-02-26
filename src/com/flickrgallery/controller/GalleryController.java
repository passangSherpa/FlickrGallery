/*
 * Index page controller.
 * 
 */


package com.flickrgallery.controller;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.flickrgallery.beans.Item;
import com.flickrgallery.service.PhotoService;


@Controller
public class GalleryController {
	
//	private static final Logger LOG = Logger.getRootLogger();
	
	@Autowired
	PhotoService photoService;
	
	@Autowired(required=false)
	ServletContext servletContext;
	
	
	@RequestMapping(value = "/", method = {RequestMethod.GET, RequestMethod.POST})	
	public String gotoGallery(Model model, HttpServletRequest request, HttpServletResponse response) {
		List<Item> photoItems = photoService.listAll();
		model.addAttribute("photoItems", photoItems);
		return "flickrGalleryHome";
	}
	
	
	@RequestMapping(value = "/tags/{tag}", method = {RequestMethod.GET, RequestMethod.POST}, produces="application/json")
	public @ResponseBody List<String> findPhotosByTag(@PathVariable(value="tag") String tag, Model model, HttpServletRequest request, HttpServletResponse response) {
		List<Item> photoItems = photoService.findByTag(tag);
		
		ObjectMapper mapper = new ObjectMapper();
		List<String> photoItemsJSON = new ArrayList<String>(photoItems.size());
		try {
			for(Item item:photoItems){
				photoItemsJSON.add(mapper.writeValueAsString(item));
			}
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		response.setContentType("application/json");
		return photoItemsJSON;
	}
	
	@RequestMapping(value = "/error", method = {RequestMethod.GET, RequestMethod.POST})	
	public String gotoErrorPage(Model model, HttpServletRequest request, HttpServletResponse response) {
		System.err.println("Error.");
		return "flickrGalleryHome";
	}

}
