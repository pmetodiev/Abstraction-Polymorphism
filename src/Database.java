public class Database {

    private IUser[] users;
    private boolean isThereFreePlace;
    private boolean isTheUsernameAlreadyInUse;
    private boolean areThereUsersInTheDatabase;

    public Database(int maxUsersLimit) {
        this.users = new IUser[maxUsersLimit];
    }

    public IUser[] getUsers() {
        return this.users;
    }

    public boolean checkIfThereAreFreePlaces() {

        this.isThereFreePlace = false;

        for (int i = 0; i < users.length; i++) {
            if (users[i] == null) {
                this.isThereFreePlace = true;
                break;
            }
        }
        return this.isThereFreePlace;
    }

    public boolean checkIfTheUsernameIsAlreadyInUse(String username) {

        this.isTheUsernameAlreadyInUse = false;

        for (int i = 0; i < users.length; i++) {
            if (users[i] != null) {
                if (users[i].getUsername().equals(username)) {
                    this.isTheUsernameAlreadyInUse = true;
                }
            }
        }
        return this.isTheUsernameAlreadyInUse;
    }

    public boolean checkIfThereAreUsersInTheDatabase() {

        this.areThereUsersInTheDatabase = false;

        for (int i = 0; i < users.length; i++) {
            if (users[i] != null) {
                this.areThereUsersInTheDatabase = true;
                break;
            }
        }
        return this.areThereUsersInTheDatabase;
    }
}
