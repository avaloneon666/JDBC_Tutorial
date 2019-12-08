package dbclasses;

import java.util.List;

public interface PersonDao {

    void createPersonTable();
    void insert (PersonWorker person);
    PersonWorker selectById(int id);
    List<PersonWorker>  selectAll();
    void delete(int id);
    void update(PersonWorker person,int id);

}
