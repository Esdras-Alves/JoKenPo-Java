public class Player {
    private String name;
    private Integer score;

    public Player(String name) {
        this.name = name;
        this.score = 0;
    }

    public void incrementScore() {
        setScore(getScore() + 1);
    }

    public String getName() {
        return name;
    }

    public void setNome(String name) {
        this.name = name;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}
