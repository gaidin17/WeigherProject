package app.dao;

import java.sql.ResultSet;
import java.util.List;

/**
 * Created by Evgeny_Akulenko on 11/15/2017.
 */
public interface EntityBuilder<T> {
	T buildSingleEntity(ResultSet resultSet);
	List<T> buildEntities(ResultSet resultSet);
}
