package entities;

public class Result {
    public int SernarioId;
    public int StepId;
    public int ExcepctedId;
    public String ExcepctedContent;
    public String ActualContent;
    public int Id;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        this.Id = id;
    }


    public String getMatchNumber() {
        return MatchNumber;
    }

    public void setMatchNumber(String matchNumber) {
        MatchNumber = matchNumber;
    }

    public String MatchNumber;

    public int getSernarioId() {
        return SernarioId;
    }

    public void setSernarioId(int sernarioId) {
        SernarioId = sernarioId;
    }

    public int getStepId() {
        return StepId;
    }

    public void setStepId(int stepId) {
        StepId = stepId;
    }

    public int getExcepctedId() {
        return ExcepctedId;
    }

    public void setExcepctedId(int excepctedId) {
        ExcepctedId = excepctedId;
    }

    public String getExcepctedContent() {
        return ExcepctedContent;
    }

    public void setExcepctedContent(String excepctedContent) {
        ExcepctedContent = excepctedContent;
    }

    public String getActualContent() {
        return ActualContent;
    }

    public void setActualContent(String actualContent) {
        ActualContent = actualContent;
    }


}
