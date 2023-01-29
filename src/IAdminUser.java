public interface IAdminUser extends IUser{
    void deleteUser(String username);
    IUser createUser(String username, boolean isAdmin);
    void printAllUsersInfo();
}

