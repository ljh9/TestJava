import java.util.List;

public interface UserService {
    public void addUser(User user);

    public void updateUser(User user);

    public void deleteUser(String email);

    public List<User> getUsers();
}
