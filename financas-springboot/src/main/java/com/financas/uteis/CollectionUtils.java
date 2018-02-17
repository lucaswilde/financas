package com.financas.uteis;

import java.util.ArrayList;
import java.util.Collection;

public class CollectionUtils {

	public static <T> Collection<T> iterableToCollection(Iterable<T> iterable){
		Collection<T> collection = new ArrayList<T>();
		iterable.forEach(collection::add);
		return collection;
	}
}
