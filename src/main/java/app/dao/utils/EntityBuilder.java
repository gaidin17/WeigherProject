package app.dao.utils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Evgeny_Akulenko on 11/15/2017.
 */
public interface EntityBuilder<T> {
	T buildSingleEntity(ResultSet resultSet) throws SQLException;
	List<T> buildEntities(ResultSet resultSet) throws SQLException;
}
