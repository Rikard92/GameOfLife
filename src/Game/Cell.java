package Game;

public class Cell {
    private boolean GenerationState;
    private boolean NextGeneration;

    public Cell() {
        GenerationState = false;
        NextGeneration= false;
    }

    public Cell(boolean state) {

        GenerationState = state;
        NextGeneration= false;
    }

    public void SetNextGeneration(boolean state) {

        NextGeneration = state;
    }

    public void UpdateGenerationState() {

        GenerationState = NextGeneration;
    }

    public boolean GetGenerationState() {
        return GenerationState;
    }

    public void ImmediateChangeState(){
        GenerationState = !GenerationState;
    }
    
}
