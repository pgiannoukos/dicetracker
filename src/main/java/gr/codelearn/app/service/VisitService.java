package gr.codelearn.app.service;

import gr.codelearn.app.model.Visit;
import gr.codelearn.app.repository.VisitRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Class that contains the basic business logic of our application. Simply calls the repository/database communication
 * class and returns results to our controller.
 */
@Service
@Slf4j
public class VisitService {

    private VisitRepository visitRepository;

    public VisitService() {
        visitRepository = new VisitRepository();
    }

    public List<Visit> getAllVisitResults() {
        return visitRepository.getAllVisitResults();
    }

    public void visit(String type) {
        visitRepository.saveVisit(type);
    }

    public void resetStatistics() {
        visitRepository.resetStatistics();
    }
}
