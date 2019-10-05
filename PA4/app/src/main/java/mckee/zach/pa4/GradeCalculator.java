package mckee.zach.pa4;

public class GradeCalculator {
    private float minAvg;
    private float curAvg;
    private float finalPercent;
    private float[] grades = {93.0f, 90.0f, 87.0f, 83.0f, 80.0f, 77.0f,
                              73.0f, 70.0f, 67.0f, 60.0f};

    public GradeCalculator(float minAvg, float curAvg, float finalPercent) {
        this.minAvg = minAvg;
        this.curAvg = curAvg;
        this.finalPercent = finalPercent;
    }

    public float getMinAvg() {
        return minAvg;
    }

    public void setMinAvg(float minAvg) {
        this.minAvg = minAvg;
    }

    public float getCurAvg() {
        return curAvg;
    }

    public void setCurAvg(float curAvg) {
        this.curAvg = curAvg;
    }

    public float getFinalPercent() {
        return finalPercent;
    }

    public void setFinalPercent(float finalPercent) {
        this.finalPercent = finalPercent;
    }

    public float calculateFinalGrade()
    {
        return 0.0f;
    }
}
