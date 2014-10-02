package edu.fae.util;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.hibernate.proxy.HibernateProxyHelper;

import edu.fae.dao.hibernate.HibernateUtil;
import edu.fae.model.Model;

/**
 * 
 * @author Robson J. P.
 *
 */
@FacesConverter(forClass=Model.class)
public class ModelConverter implements Converter {
	
	public ModelConverter() {
	}
	
	
	public Object getAsObject(FacesContext ctx, UIComponent component, String pojo) {
		if(pojo!=null) {
			int index = pojo.indexOf(':');
			if(index!=-1) {
				String classeName = pojo.substring(0, index);
				String id = pojo.substring(index+1, pojo.length());
				try {
					return HibernateUtil.getSession().load(Class.forName(classeName), new Long(id));
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}

	public String getAsString(FacesContext ctx, UIComponent component, Object pojo) {
		if(pojo!=null && pojo instanceof Model) {
			return HibernateProxyHelper.getClassWithoutInitializingProxy(pojo).getName()+":"+((Model)pojo).getId();
		}
		return null;
	}
	
	

}
