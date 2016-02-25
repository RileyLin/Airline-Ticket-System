import java.util.Date;

/**
 * Created by dongsoo on 1/7/2016.
 */
public class Passenger {
    private String first;
    private String last;
    private boolean male;
    private int age;
    private String bookdate;

    @Override
    public String toString() {
        return "Passenger{" +
                "first='" + first + '\'' +
                ", last='" + last + '\'' +
                ", male=" + male +
                ", age=" + age +
                ", bookdate=" + bookdate +
                ", confirmationNumber=" + confirmationNumber +
                '}';
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public boolean isMale() {
        return male;
    }

    public void setMale(boolean male) {
        this.male = male;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getBookdate() {
        return bookdate;
    }

    public void setBookdate(String bookdate) {
        this.bookdate = bookdate;
    }

    public int getConfirmationNumber() {
        return confirmationNumber;
    }

    public void setConfirmationNumber(int confirmationNumber) {
        this.confirmationNumber = confirmationNumber;
    }

    public Passenger(String first, String last, boolean male, int age, String bookdate, int confirmationNumber) {

        this.first = first;
        this.last = last;
        this.male = male;
        this.age = age;
        this.bookdate = bookdate;
        this.confirmationNumber = confirmationNumber;
    }

    private int confirmationNumber;


}
