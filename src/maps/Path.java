package maps;

import java.util.ArrayList;
import java.util.List;

public class Path {
    private List<int[]> cases=new ArrayList<int[]>();

    public Path(int[] posPerso, int[] posSouris){
        cases.add(posSouris);
    }

    public List<int[]> getCases() {
        return cases;
    }


    public void setCases(List<int[]> cases) {
        this.cases = cases;
    }
}
