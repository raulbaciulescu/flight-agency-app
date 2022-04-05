package impl;

import api.Constants;
import api.Table;
import api.UserRepository;
import domain.User;
import impl.database.TableFactory;
import impl.database.UserTable;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class UserRepositoryImpl implements UserRepository {
    private final UserTable table;

    public UserRepositoryImpl(TableFactory factory) throws SQLException {
        //table = (UserTable) Resources.getTableFactory().getTable(Constants.Db.Tables.USER);
        table = (UserTable) factory.getTable(Constants.Db.Tables.USER);
    }

    @Override
    public void add(User entity) {
        table.add(entity);
    }

    @Override
    public void update(User entity, User newEntity) {

    }


    @Override
    public Optional<User> findByID(Long id) {
        return table.findById(id);
    }

    @Override
    public void delete(Long id) {
        table.delete(id);
    }

    @Override
    public List<User> getAll() {
        return table.getAll();
    }

    @Override
    public Optional<User> findUser(String username, String password) {
        return table.findUser(username, password);
    }
}
