package movieTicketExample.theater.repository;

import movieTicketExample.theater.TheaterServiceImpl;

import java.util.ArrayList;
import java.util.List;

public record TheaterRepositoryImpl(List<TheaterServiceImpl> theaterServiceImpls) implements TheaterRepository {
    public TheaterRepositoryImpl(List<TheaterServiceImpl> theaterServiceImpls) {
        validate(theaterServiceImpls);
        this.theaterServiceImpls = new ArrayList<>(theaterServiceImpls);
    }

    @Override
    public List<TheaterServiceImpl> getAllTeaters() {
        return theaterServiceImpls;
    }

    @Override
    public TheaterServiceImpl findById(long id) {
        return theaterServiceImpls.stream()
                .filter(theaterServiceImpl -> theaterServiceImpl.sameId(id))
                .findFirst()
                .orElse(null);
    }

    private void validate(List<TheaterServiceImpl> theaterServiceImpls) {
        if (theaterServiceImpls.isEmpty()) {
            throw new IllegalArgumentException("리스트가 비어있습니다.");
        }
    }
}