import java.util.Date;

public class MovieSession {
    private long id;
    private int ticketsCount;
    private int ticketsOrdered;
    private Date date;
    private int price;
    private String movieName;


    private String address;

    public MovieSession(long id, int ticketsCount, String movieName, Date date, int price, String address) {
        this.id = id;
        this.ticketsCount = ticketsCount;
        this.movieName = movieName;
        this.date = date;
        this.price = price;
        this.address = address;
    }

    public int getTicketsOrdered() {
        return ticketsOrdered;
    }

    public void setTicketsOrdered(int ticketsOrdered) {
        this.ticketsOrdered = ticketsOrdered;
    }

    public String getMovieName() {
        return movieName;
    }

    public int getTicketsCount() {
        return ticketsCount;
    }

    public Date getDate() {
        return date;
    }

    public int getPrice() {
        return price;
    }

    public String getAddress() {
        return address;
    }

    public long getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MovieSession that = (MovieSession) o;

        if (date != null ? !date.equals(that.date) : that.date != null) return false;
        if (movieName != null ? !movieName.equals(that.movieName) : that.movieName != null) return false;
        return address != null ? address.equals(that.address) : that.address == null;
    }

    @Override
    public int hashCode() {
        int result = date != null ? date.hashCode() : 0;
        result = 31 * result + (movieName != null ? movieName.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        return result;
    }
}
