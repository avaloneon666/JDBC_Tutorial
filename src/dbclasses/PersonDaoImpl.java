package dbclasses;

import java.sql.*;
import java.util.List;

public class PersonDaoImpl implements PersonDao {

    @Override
    public void createPersonTable() {
        Connection connection = null;
        Statement statement = null;
        try {
            connection = ConnectionWorker.getConnection();
            statement = connection.createStatement();
            statement.execute("CREATE TABLE IF NOT EXISTS person (id int primary key unique auto_increment," +
                    "first_name varchar (55) , last_name varchar (55))");


        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }


            }
            if(connection != null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }

        }
    }

    @Override
    public void insert(PersonWorker person) {
        Connection connection=null;
        PreparedStatement preparedStatement = null;
        try {
        connection = ConnectionWorker.getConnection();
        preparedStatement= connection.prepareStatement("INSERT INTO person (first_name,last_name) VALUES" +
                "(?,?)");
        preparedStatement.setString(1,person.getFirstName());
        preparedStatement.setString(2,person.getLastName());
        preparedStatement.executeUpdate();
        System.out.println("INSERT INTO person (first_name,last_name) VALUES" +
                "(?,?)");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally
        {
                if (preparedStatement!=null)
                {
                    try {
                        preparedStatement.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }

                }
                if(connection!=null)
                {
                    try {
                        connection.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }

                }
        }


    }

    @Override
    public PersonWorker selectById(int id) {
        PersonWorker person = new PersonWorker();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try{
            connection = ConnectionWorker.getConnection();
            preparedStatement = connection.prepareStatement("SELECT * FROM person WHERE id= ?");
            preparedStatement.setInt(1,id);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                person.setId(resultSet.getInt("id"));
                person.setFirstName(resultSet.getString("first_name"));
                person.setLastName(resultSet.getString("last_name"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if(resultSet !=null)
            {
                try{
                    resultSet.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if(preparedStatement != null)
            {
                try{
                    preparedStatement.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
            if(connection!=null)
            {
                try{
                    connection.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return person;
    }

    @Override
    public List<PersonWorker> selectAll() {
        return null;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void update(PersonWorker person, int id) {

    }
}
