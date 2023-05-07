import java.io.BufferedReader;
import java.io.InputStreamReader;

public class UserUI {
    private BufferedReader br;
    public UserUI() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    public int menu(){
        System.out.println("1. 회원등록");
        System.out.println("2. 회원목록보기");
        System.out.println("3. 종료");
        int menuId = -1;
        try {
            String line = br.readLine();
            menuId = Integer.parseInt(line);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return menuId;
    }

    public User regMenu() {
        try {
            System.out.println("email을 입력");
            String email = br.readLine();
            System.out.println("이름 임력");
            String name = br.readLine();
            System.out.println("생년 임력");
            String strBirthYear = br.readLine();
            int birthYear = Integer.parseInt(strBirthYear);

            User user = new User(email, name, birthYear);
            return user;
        } catch (Exception ex){
            ex.printStackTrace();
            return  null;
        }
    }
}
