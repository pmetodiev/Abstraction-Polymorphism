public class Demo {
    public static void main(String[] args) {
        AdminUserImpl ivan = new AdminUserImpl("Ivan");

        IUser mariya = ivan.createUser("Mariya", true);
        IUser ceco = ivan.createUser("Ceco", false);
        IUser boris = ivan.createUser("Boris", false);
        IUser georgi = ivan.createUser("Georgi", false);
        //Trying to create another user with username Georgi.
        IUser anotherGeorgi = ivan.createUser("Georgi", false);
        IUser ivana = ivan.createUser("Ivana", false);
        //Trying to create user when the 'Users' database is already full.
        IUser stoyana = ivan.createUser("Stoyana", false);

        System.out.println();

        ivan.printAllUsersInfo();

        System.out.println();

        ivan.deleteUser("Mariya");
        ivan.deleteUser("Ceco");
        ivan.deleteUser("Boris");
        ivan.deleteUser("Georgi");
        ivan.deleteUser("Ivana");
        //Trying to delete user when the 'Users' database is already empty.
        ivan.deleteUser("Ivana");

        System.out.println();
        //Trying to print users' info when the 'Users' database is empty.
        ivan.printAllUsersInfo();
    }
}
