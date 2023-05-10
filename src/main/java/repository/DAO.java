package repository;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import database.MySQLConnecttion;

public abstract class DAO<T> {
	Connection conn = MySQLConnecttion.getConnection();
    public abstract ArrayList<T> getAll() throws SQLException;

    public abstract T get(int id) throws SQLException;

    public abstract void save(T t) throws SQLException;

    public abstract void update(T t) throws SQLException;

    public abstract void delete(T t) throws SQLException;

    public abstract void deleteById(int id) throws SQLException;
}
