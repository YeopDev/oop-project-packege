package bollingGame;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Frames {
    private final List<Frame> contents;

    public Frames() {
        this.contents = new ArrayList<>();
    }

    public void add(Frame frame) {
        this.contents.add(frame);
    }

    public Optional<Frame> last() {
        if (this.contents.isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(this.contents.get(this.contents.size() - 1));
    }

    public List<Frame> contents() {
        return this.contents;
    }

    public void reset() {
        this.contents.clear();
    }
}
