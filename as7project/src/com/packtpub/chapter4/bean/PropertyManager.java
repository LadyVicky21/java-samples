package com.packtpub.chapter4.bean;


import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import com.packtpub.chapter4.ejb.SingletonBean;

 

@ManagedBean(name="manager")
public class PropertyManager {
  
	@EJB
	SingletonBean ejb;

	ArrayList  cacheList  = new ArrayList ();

	private String key;
	private String value;

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public void save(ActionEvent e) {
		ejb.put(key, value);
	}

	public void clear(ActionEvent e) {
		System.out.println("Called clear");
		ejb.delete();

	}
	public List getCacheList() {
		return ejb.getCache();
	}


}
