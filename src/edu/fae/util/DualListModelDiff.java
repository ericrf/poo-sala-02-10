package edu.fae.util;

import java.util.LinkedList;
import java.util.List;

import org.primefaces.model.DualListModel;

/**
 * 
 * @author Robson J. P.
 *
 * @param <T>
 */
public class DualListModelDiff<T> extends DualListModel<T>{

	public DualListModelDiff(List<T> source, List<T> target) {
		List<T> newSource = new LinkedList<T>();
		for(T t: source) {
			
			if(!target.contains(t)) {
				newSource.add(t);
			}
		}
		setSource(newSource);
		setTarget(target);
	}
	
	
}
