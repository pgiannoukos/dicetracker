package gr.codelearn.app.repository;

import gr.codelearn.app.model.Visit;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Class that contains all the logic that is needed for Java to communicate with the database. Pay extra notice to how
 * the queries are formed, as you will be called to "adapt" them for your coursework. For this example, there are two
 * methods:
 *
 * 1) The getAllDieResults() method selects all rows from the DiceTracker table and returns a list of Dice. A ResultSet
 * is practically the set of rows that is returned after the query is executed. After receiving the result set, a
 * die is created from the data that was returned, and added to a list, which is finally returned. The data that are
 * returned come in exactly the same order as they are seen in the database server. In this example, getLong(1) refers
 * to the position (index) 1 of the row, and is expected to be "collected" as a long. If we see in the database, for each
 * row in the DiceTracker table, the first column is an id, which happens to be an int(db)/long(java).
 *
 * 2) The saveResult() method saves each result from a die that the user requested to throw. Pay extra attention to the
 * so-called "prepared statement/query".  The query requests specifically to insert data into the result and throw_date
 * columns of our DiceTracker table, omitting the ID, which is auto-generated. So for each new entry, the ID is auto-
 * generated and the rest of the columns are inserted manually. Similarly to the other method, we need to set the
 * position of each "?" value, manually with result being the first position (index), and throw_date the second one. We
 * do not care about a result, as we simply want to execute the insertion and that's it.
 */
@Component
@Slf4j
public class VisitRepository {

    public List<Visit> getAllVisitResults() {
        List<Visit> allVisitResults = new ArrayList<>();
        try {
            String query = "SELECT `type`, count(id) as amount FROM VISIT GROUP BY `type`";
            Connection connection = DataSource.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                String type = resultSet.getString(1);
                Integer amount = resultSet.getInt(2);
                allVisitResults.add(new Visit(type, amount));
            }
        } catch (SQLException e) {
            log.error("For some reason, a connection could not be obtained", e);
        }
        return allVisitResults;
    }

    public void saveVisit(String type) {
        try {
            String query = "INSERT INTO VISIT(type, throw_date) VALUES(?, ?)";
            Connection connection = DataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, type);
            // created a date (current date) and sets it as SQL's timestamp instance, which is required
            preparedStatement.setTimestamp(2, new Timestamp(new Date().getTime()));
            preparedStatement.execute();
        } catch (SQLException e) {
            log.error("For some reason, a connection could not be obtained", e);
        }
    }

     public void resetStatistics() {
        try {
            String query = "DELETE FROM VISIT";
            Connection connection = DataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.execute();
        } catch (SQLException e) {
            log.error("For some reason, a connection could not be obtained", e);
        }
    }
}
