import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract class AbstractUser implements IUser {
    private boolean isLoggedIn;
    private String username;
    private String registrationDate;
    private boolean isAdmin;

    public AbstractUser(String username, boolean isAdmin) {
        this.username = username;
        this.isAdmin = isAdmin;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/uuuu");
        LocalDate localDate = LocalDate.now();
        this.registrationDate = dtf.format(localDate);
    }

    @Override
    public void login() {
        this.isLoggedIn = true;
    }

    @Override
    public void logout() {
        this.isLoggedIn = false;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public String getRegistrationDate() {
        return this.registrationDate;
    }

    @Override
    public String toString() {
        return "The user " + this.username +
                " registered on " + this.registrationDate +
                " is admin: " + this.isAdmin;
    }
}
