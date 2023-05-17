import java.util.ArrayList;
import java.util.List;

public class UserServiceInMemory implements UserService{
    private List<User> users;

    public UserServiceInMemory() {
        this.users = new ArrayList<>();
    }

    public UserServiceInMemory(List<User> users){
        this.users = users;
    }

    @Override
    public void addUser(User user) {
        users.add(user);
    }

    @Override
    public boolean updateUser(User user) {
        int findIndex = -1;
        for(int i=0; i<users.size(); i++){
            if(users.get(i).getEmail().equals(user.getEmail())){
                findIndex = i;
                users.remove(i);
                break;
            }
        }
        if(findIndex > -1){
            users.add(user);
            return true;
        } else {
          return false;
        }
    }

    @Override
    public boolean deleteUser(String email) {

    }

    @Override
    public List<User> getUsers() {
        return null;
    }
}
