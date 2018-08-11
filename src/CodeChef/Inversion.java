package CodeChef;

import java.util.ArrayList;

public class Inversion {

    public int countInversions(ArrayList<Integer> A) {

        int count = 0;

        for(int i=0; i<A.size(); i++){

            for(int j = i+1;j<A.size();j++){

                if(A.get(j) < A.get(i)){
                    count++;
                }

            }

        }
        return count;
    }


}
