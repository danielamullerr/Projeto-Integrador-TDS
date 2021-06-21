package mappers;

import java.sql.SQLException;
import java.util.List;

public interface Mapper<E> {
    public E findByID(int id);
    public void insert(E entity) throws SQLException;
    public void update(E entity) throws SQLException;
    public void delete(E entity) throws SQLException;
}
