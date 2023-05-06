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
}
