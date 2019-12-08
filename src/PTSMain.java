import dbclasses.ConnectionWorker;
import dbclasses.PersonDaoImpl;
import dbclasses.PersonWorker;

import java.sql.Connection;
import java.sql.SQLException;

public class PTSMain {
    public static void main(String [] args)
    {
        PersonDaoImpl pdi = new PersonDaoImpl();
        //pdi.createPersonTable();
        //PersonWorker person = new PersonWorker("Jane","Johnson");
        //PersonWorker person = pdi.selectById(1);
        //System.out.println(person.getId()+","+person.getFirstName()+","+person.getLastName());
    }
    }
