package Model;

import Query.DAO;
import Query.Delete;
import Query.Insert;
import Query.Update;

@DAO
public interface UserDao {

    @Insert
    void insert(User user);

    @Update
    void update(User user);

    @Delete
    void delete(User user);
}
