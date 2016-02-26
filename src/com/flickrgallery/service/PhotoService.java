package com.flickrgallery.service;

import java.util.List;

import com.flickrgallery.beans.Item;

public interface PhotoService {

	public List<Item> listAll();
	public List<Item> findByTag(String tag);
	
}
