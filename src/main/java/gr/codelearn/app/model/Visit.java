package gr.codelearn.app.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

/**
 * Simple entity that groups together results from the database.
 */
@Data
@AllArgsConstructor
public class Visit {
    private String type;
    private Integer amount;
}
