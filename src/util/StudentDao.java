package util;

import java.util.Collection;

public interface StudentDao<T, K> {
	Collection<T> getAll();
	
	T getOne(K Key);
	void add(T t);
	void update(T t);
	void delete(K key);

	void delete(Student key);

	
	
}
