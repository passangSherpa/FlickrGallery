package com.flickrgallery.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.flickrgallery.beans.Item;
import com.flickrgallery.beans.Photo;
import com.flickrgallery.util.RestTemplateJSON;


@Service
public class PhotoServiceImpl implements PhotoService{
	
	RestTemplateJSON restTemplateJSON = new RestTemplateJSON();
    ObjectMapper objectMapper = new ObjectMapper();
	
	@Value("${url.flickr.public.api.json}")
	String flickrPublicPhotosURL;
	
	@Cacheable(value="allPhotosCache")
	public List<Item> listAll()	{
		List<Item> photoItems = new ArrayList<Item>();
		
		//Create a list for the message converters
		List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
		MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
		mappingJackson2HttpMessageConverter.setPrettyPrint(true);

		//API doesn't respond with VALID json so reading the response body using StringHttpMessageConverter
		messageConverters.add(new StringHttpMessageConverter()); 
		//Add the message converters to the restTemplate
		restTemplateJSON.setMessageConverters(messageConverters);
		
		String msg = restTemplateJSON.getForObject("https://api.flickr.com/services/feeds/photos_public.gne?format=json", String.class);
		
		//the service above doesn't send valid json response so need to remove function declaration accordingly
		msg = StringUtils.removeStart(msg, "jsonFlickrFeed("); //remove the jsonFlickrFeed( string
        msg = StringUtils.removeEnd(msg, ")");//remove the end closing small bracket

		objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
		objectMapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
		
		Photo photo;
		DateTime photoModifiedTime;
		try {
			photo = objectMapper.readValue(msg, Photo.class);
			photoItems = photo.getItems();
			photoModifiedTime = DateTime.parse(photo.getModified());
			System.out.println("Title : " + photo.getTitle() + "Modified at : " + photoModifiedTime);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return photoItems;
	}
	
	@Cacheable(value="searchResultsCache", key="#tag")
	public List<Item> findByTag(String tag){
		List<Item> photoItems = new ArrayList<Item>();
		
		String msg = restTemplateJSON.getForObject("https://api.flickr.com/services/feeds/photos_public.gne?format=json&tags="+tag.trim(), String.class);
		
		//the service above doesn't send valid json response so need to remove function declaration accordingly
		msg = StringUtils.removeStart(msg, "jsonFlickrFeed("); //remove the jsonFlickrFeed( string
        msg = StringUtils.removeEnd(msg, ")");//remove the end closing small bracket

		Photo photo;
		DateTime photoModifiedTime;
		try {
			photo = objectMapper.readValue(msg, Photo.class);
			photoItems = photo.getItems();
			photoModifiedTime = DateTime.parse(photo.getModified());
			System.out.println("Title : " + photo.getTitle() + "Modified at : " + photoModifiedTime);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return photoItems;
	}
	
}