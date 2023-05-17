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

    }

    @Override
    public void updateUser(User user) {

    }

    @Override
    public void deleteUser(String email) {

    }

    @Override
    public List<User> getUsers() {
        return null;
    }
}
