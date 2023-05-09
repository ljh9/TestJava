import java.util.List;

public class UserMain {
    public static void main(String[] args) {
        UserUI userUI = new UserUI();
        UserDao userDao = new UserDao("/tmp/users.dat");
        List<User> users = userDao.getUsers();

        while (true){
            int menuId = userUI.menu();
            if(menuId == 5) {
                System.out.println("종료");
                userDao.saveUser(users);
                break;
            }
        }

    }
}
