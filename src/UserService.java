import java.util.List;

public interface UserService {
    public void addUser(User user);

    public boolean updateUser(User user);

    public boolean deleteUser(String email);

    public List<User> getUsers();
}
