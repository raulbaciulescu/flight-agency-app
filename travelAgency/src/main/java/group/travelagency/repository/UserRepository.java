package group.travelagency.repository;

import group.travelagency.domain.User;
import group.travelagency.repository.database.Table;
import group.travelagency.repository.database.UserTable;
import group.travelagency.utils.Constants;
import group.travelagency.utils.Resources;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class UserRepository implements Repository<Long, User>{
    private final Table<Long, User> table;

    public UserRepository() throws SQLException {
        table = (UserTable) Resources.getTableFactory().getTable(Constants.Db.Tables.USER);
    }

    @Override
    public void add(User entity) {
        table.add(entity);
    }

    @Override
    public void update(User entity) {
        //TODO
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

    public Table<Long, User> getTable() {
        return table;
    }
}
