package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String NATIONALITY = "Ukrainian";
    private static final int VALID_AGE = 35;
    private static final int YEARS_OF_LIVING = 10;

    @Override
    public boolean test(Candidate candidate) {
        String [] years = candidate.getPeriodsInUkr().split("-");
        int firstYear = Integer.parseInt(years[0]);
        int lastYear = Integer.parseInt(years[1]);
        int periodOfLivingInUkraine = lastYear - firstYear;
        return periodOfLivingInUkraine >= YEARS_OF_LIVING && candidate.getAge() >= VALID_AGE
                && candidate.getNationality().equals(NATIONALITY) && candidate.isAllowedToVote();
    }
}
