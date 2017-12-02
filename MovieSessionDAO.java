import java.util.ArrayList;
import java.util.List;

public class MovieSessionDAO {

    private static ArrayList<MovieSession> movieSessions = new ArrayList<>();

    private OrderMovieSessionDAO orderMovieSessionDAO = new OrderMovieSessionDAO();


    public MovieSession findByMovieNameAndAddress(String movieName, String address) {
        for (MovieSession movieSession : movieSessions) {
            if (movieSession.getAddress().equals(address) && movieSession.getMovieName().equals(movieName))
                return movieSession;
        }

        return null;
    }

    //bad solution
    public int findFreeTicketsByMovieNameAndAddress(String movieName, String address) {
        List<OrderMovieSession> ordersByMovieNameAndAddress = orderMovieSessionDAO.ordersByMovieNameAndAddress(movieName, address);

        MovieSession movieSession = findByMovieNameAndAddress(movieName, address);

        return movieSession.getTicketsCount() - ordersByMovieNameAndAddress.size();
    }


    //id 1, ticketsOrdered = 2
    //id 1, ticketsOrdered = 4

    public MovieSession update(MovieSession movieSession) {
        int index = 0;
        for (MovieSession ms : movieSessions) {
            if (ms.getId() == movieSession.getId()) {
                movieSessions.set(index, movieSession);
                return movieSession;
            }
            index++;
        }
        return null;
    }


    public MovieSession save(MovieSession movieSession) throws Exception {
        //check if not exist
        //add

        for (MovieSession ms : movieSessions) {
            if (ms.equals(movieSession)) {
                throw new Exception("Movie session " + movieSession + " already exists");
            }
        }

        movieSessions.add(movieSession);
        return movieSession;
    }

}
