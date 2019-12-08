import dbclasses.PersonWorker;
import dbclasses.Person;

import java.util.List;

public class JDBCPractice {
    public static void main(String[] args) {
        PersonWorker pdi = new PersonWorker();
        //pdi.createPersonTable();
        Person newPerson = new Person("Bobby","Hill");
        //pdi.insert(newPerson);
        //Person person = pdi.selectById(1);
        //System.out.println(person.getId()+","+person.getFirstName()+","+person.getLastName());
        //pdi.delete(2);
        //pdi.update(newPerson,1);
        
        List<Person> Persons = pdi.selectAll();
        for (Person person : Persons) {
            System.out.println(person.getId() + "," + person.getFirstName() + "," + person.getLastName());
        }
    }
}
