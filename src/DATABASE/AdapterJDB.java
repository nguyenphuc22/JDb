package DATABASE;

import Entity.Table;

public class AdapterJDB implements Adapter {
    // annotation
    // reflection java
    // https://www.javatpoint.com/java-annotation
    // https://kipalog.com/posts/Lam-sao-de-xay-dung-thu-vien-ORM?fbclid=IwAR3nX26rvt4Ogm86hD8nATlM2_6DAJsi6BsD5Oncl4WvjlRTq7U74-shMPw
    @Override
    public String convertQuery(Object object) {
        // Insert
        String insert = "";
        // Update
        String update = "";
        // Delete
        String delete = "";
        return null;
    }

    @Override
    public <T> String convertTable(Class<T> Klass) {
//        CREATE TABLE Persons (
//                PersonID int,
//        LastName varchar(255),
//                FirstName varchar(255),
//                Address varchar(255),
//                City varchar(255)
//        );
        return null;
    }
}
