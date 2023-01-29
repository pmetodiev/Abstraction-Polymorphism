public class UserImpl extends AbstractUser{

    public UserImpl(String username, boolean isAdmin) {
        super(username, isAdmin);
    }

    public UserImpl(String username) {
        this(username, false);
    }
}