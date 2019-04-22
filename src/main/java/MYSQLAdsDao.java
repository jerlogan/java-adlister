import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.mysql.cj.jdbc.Driver;

public class MYSQLAdsDao implements Ads{
    private Connection connection = null;


    public MYSQLAdsDao(Config config) {
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                    config.getUrl(),
                    config.ugetuser(),
                    config.getPassword()
            );
        } catch (SQLException e) {
            throw new RuntimeException("Oops! Can't connect to database.", e);
        }
    }

    private Ad getOneAd (ResultSet rs) throws SQLException {
        return new Ad (
            rs.getLong("id"),
            rs.getLong("user_id"),
            rs.getString("title"),
            rs.getString("description")
        );
    }

    private List<Ad> getAllAds (ResultSet rs) throws SQLException {
        List<Ad> allAdsArray = new ArrayList<>();
        if (rs.next()) {
            allAdsArray.add(getOneAd(rs));
        }
        return allAdsArray;
    }


    @Override
    public List<Ad> all() {
        try {
            Statement statement = connection.createStatement();
            String readAllAds = "SELECT * FROM ADS";
            ResultSet allAds = statement.executeQuery(readAllAds);
            return getAllAds(allAds);
        } catch (SQLException e) {
            throw new RuntimeException("Oops! Couldn't get all ads.", e);
        }
    }


    private String insertQueryString (Ad ad) {
        return "INSERT INTO ads(title, description) VALUES "
                + "('" + ad.getUserId() + "', '"
                + "('" + ad.getTitle() + "', '"
                + "('" + ad.getDescription() + "')'";
    }


    @Override
    public Long insert(Ad ad) {
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(insertQueryString(ad), Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = statement.getGeneratedKeys();
            rs.next();
            return rs.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException("Oops! Can't seem to insert an ad.", e);
        }
    }
}