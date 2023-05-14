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
            } else if(menuId == 1){
                User user = userUI.regMenu();
                users.add(user);
                System.out.println("등록");
            } else if(menuId == 2) {
                userUI.printUserList(users);
            } else if (menuId == 3) {
                String email = userUI.inputEmail();
                int findIndex = -1;
                for (int i = 0; i < users.size(); i++){
                    User u = users.get(i);
                    if(u.getEmail().equals(email)){
                        findIndex = i;
                        break;
                    }
                }
                if(findIndex != -1){
                    User updateUser = userUI.inputUser(email);
                    users.remove(findIndex);
                    users.add(updateUser);
                    System.out.println("수정완료");
                }else {
                    System.out.println("회원 없음");
                }
            }
        }

    }
}
