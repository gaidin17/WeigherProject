package app.dao;

import java.util.List;

/**
 * Created by Evgeny_Akulenko on 11/15/2017.
 */
public interface DaoInterface<K, V>  {
	boolean create(K k);
	boolean update(K v);
	K getEntityById(V v);
	List<K> getAll();
	boolean remove(V v);
}
