import java.util.List;

public class UserMain {
    public static void main(String[] args) {
        UserUI userUI = new UserUI();
        UserDao userDao = new UserDao("/tmp/users.dat");
//        List<User> users = userDao.getUsers();
        UserService userService = new UserServiceInMemory(userDao.getUsers());

        while (true){
            int menuId = userUI.menu();
            if(menuId == 5) {
                System.out.println("종료");
                userDao.saveUser(userService.getUsers());
                break;
            } else if(menuId == 1){
                User user = userUI.regMenu();
                userService.addUser(user);
                System.out.println("등록");
            } else if(menuId == 2) {
                userUI.printUserList(userService.getUsers());
            } else if (menuId == 3) {
                String email = userUI.inputEmail();
                boolean isFindEmail = userService.exists(email);
                if(isFindEmail){
                    User updateUser = userUI.inputUser(email);
                    userService.updateUser(updateUser);
                    System.out.println("수정완료");
                }else {
                    System.out.println("회원 없음");
                }
            } else if (menuId == 4) {
                String email = userUI.inputEmail();
                boolean isFindEmail = userService.exists(email);
                if(isFindEmail){
                    userService.deleteUser(email);
                    System.out.println("삭제완료");
                }else {
                    System.out.println("회원 없음");
                }
            }
        }

    }
}
