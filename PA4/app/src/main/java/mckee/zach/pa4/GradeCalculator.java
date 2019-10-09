package mckee.zach.pa4;

public class GradeCalculator {
    private float minAvg;
    private float curAvg;
    private float finalPercent;

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
        float nonFinalPercent = (100 - finalPercent)/100;
        return ((minAvg - curAvg * nonFinalPercent) / (finalPercent/100));
    }
}
