public class AdminUserImpl extends AbstractUser implements IAdminUser{

    private Database usersDatabase;
    private final static int MAX_USERS_LIMIT = 5;

    public AdminUserImpl(String username, boolean isAdmin) {
        super(username, isAdmin);
        this.usersDatabase = new Database(MAX_USERS_LIMIT);
    }

    public AdminUserImpl(String username) {
        this(username, true);
    }

    @Override
    public void deleteUser(String username) {
        if (usersDatabase.checkIfThereAreUsersInTheDatabase() == true) {
            for (int i = 0; i < usersDatabase.getUsers().length; i++) {
                if (usersDatabase.getUsers()[i] != null) {
                    if (usersDatabase.getUsers()[i].getUsername().equals(username)) {
                        usersDatabase.getUsers()[i] = null;
                    }
                }
            }
        } else {
            System.out.println("There are no users to be deleted. The 'Users' database is already empty.");
        }

    }

    @Override
    public IUser createUser(String username, boolean isAdmin) {

        IUser newUser = null;

        if (usersDatabase.checkIfThereAreFreePlaces() == true){

            if (usersDatabase.checkIfTheUsernameIsAlreadyInUse(username) == false) {

                if (isAdmin) {
                    newUser = new AdminUserImpl(username);
                } else {
                    newUser = new UserImpl(username);
                }

                addUserToUsersDatabase(newUser);

            } else {
                System.out.println("The username '" + username + "' is already in use.");
            }

        } else {
            System.out.println("There is no free place for new users. The user '" + username + "' can not be created and can not be added to the 'Users' database.");
        }

        return newUser;
    }

    @Override
    public void printAllUsersInfo() {
        if (usersDatabase.checkIfThereAreUsersInTheDatabase() == true) {

            for (int i = 0; i < usersDatabase.getUsers().length; i++) {

                if (usersDatabase.getUsers()[i] != null) {
                    System.out.println(usersDatabase.getUsers()[i]);
                }

            }

        } else {
            System.out.println("There are no users to be printed. The 'Users' database is empty.");
        }
    }

    private void addUserToUsersDatabase(IUser userToBeAdded) {
        for (int i = 0; i < usersDatabase.getUsers().length; i++) {

            if (usersDatabase.getUsers()[i] == null) {
                usersDatabase.getUsers()[i] = userToBeAdded;
                return;
            }
        }
    }
}
