package mappers;

import java.sql.SQLException;

public interface PersonMapper<E> extends Mapper <E> {
    public E findByCPF(String cpf)  throws SQLException;
}
