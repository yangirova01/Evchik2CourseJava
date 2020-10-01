package Third_homework;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        postgresDb db = new postgresDb();
        db.createConnection();
        List<User> userList = db.findAllByAge(19);
        for (User user : userList){
            System.out.println(user);
        }
    }
}
