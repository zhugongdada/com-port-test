package entities;

public class Expected {
    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getScenarioId() {
        return ScenarioId;
    }

    public void setScenarioId(int scenarioId) {
        ScenarioId = scenarioId;
    }

    public int getStepId() {
        return StepId;
    }

    public void setStepId(int stepId) {
        StepId = stepId;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public String Name;
    public int ScenarioId;
    public int StepId;
    public String Content;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int Id;

}
