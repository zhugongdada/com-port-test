package entities;

public class Step {
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

    public String getFuncName() {
        return FuncName;
    }

    public void setFuncName(String funcName) {
        FuncName = funcName;
    }

    public String Name;
    public int ScenarioId;
    public String FuncName;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int Id;
}
