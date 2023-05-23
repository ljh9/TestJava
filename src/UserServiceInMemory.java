import java.util.ArrayList;
import java.util.Iterator;
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
        boolean deleteFlag = deleteUser(user.getEmail());
        if(deleteFlag){
            users.add(user);
            return true;
        } else {
          return false;
        }
    }

    @Override
    public boolean exists(String email) {
        if(findIndex(email) > 0)
            return true;
        else
            return false;
    }

    private int findIndex(String email){
        int findIndex = -1;
        for(int i=0; i<users.size(); i++){
            if(users.get(i).getEmail().equals(email)){
                findIndex = i;
                break;
            }
        }
        return findIndex;
    }

    @Override
    public boolean deleteUser(String email) {
        int findIndex = exists(email);
        if(findIndex > -1){
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Iterator<User> getUsers() {
        return users.iterator();
    }
}
