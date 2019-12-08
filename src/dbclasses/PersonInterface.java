package dbclasses;

import java.util.List;

public interface PersonInterface {

    void createPersonTable();
    void insert (Person person);
    Person selectById(int id);
    List<Person>  selectAll();
    void delete(int id);
    void update(Person person, int id);

}
