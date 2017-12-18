import java.text.DecimalFormat;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

/**
 * Created by sruthipotluri on 12/6/17.
 */
public class CosSimCal {

    TreeMap<String, Movie> utilityMatrix = new TreeMap<>();

    Movie movie1 = null, movie2 = null;

    TreeMap<String, Double> normalisedUserList1 = new TreeMap<>();

    TreeMap<String, Double> normalisedUserList2 = new TreeMap<>();

    TreeMap<String, Double> movieSim1 = new TreeMap<>();

    TreeMap<String, Double> movieSim2 = new TreeMap<>();

    Double firstVector = 0.0, secondVector = 0.0;

    Driver d = new Driver();


    public CosSimCal(TreeMap<String, Movie> utilityMatrix) {

        this.utilityMatrix = utilityMatrix;
    }

    public void calculate() {

        System.out.println("the size is " + utilityMatrix.size());

        for (int i = 1; i <= 3952; i++) {

            if (utilityMatrix.containsKey(String.valueOf(i))) {
                movie1 = utilityMatrix.get(String.valueOf(i));

                normalisedUserList1 = movie1.getNormaliseduserList();

                firstVector = movie1.getTotVector();

                movieSim1 = movie1.getMovieSimilarity();

                Set<String> keyOfMov1 = normalisedUserList1.keySet();

                for (int j = i + 1; j <= 3952; j++) {


                    if (utilityMatrix.containsKey(String.valueOf(j))) {

                        movie2 = utilityMatrix.get(String.valueOf(j));

                        normalisedUserList2 = movie2.getNormaliseduserList();

                        secondVector = movie2.getTotVector();

                        movieSim2 = movie2.getMovieSimilarity();

                        Set<String> requiredKeys = new HashSet<>(normalisedUserList2.keySet());

                        requiredKeys.retainAll(keyOfMov1);

                        double cosSim = 0.0, dotProduct = 0.0;

                        //Calculating CosineSimilarity;
                        Iterator it = requiredKeys.iterator();

                        while (it.hasNext()) {

                            String key = (String) it.next();

                            dotProduct += normalisedUserList1.get(key) * normalisedUserList2.get(key);

                        }


                        double value = 0.0;
                        if(dotProduct!=0)
                            value = Double.parseDouble(new DecimalFormat("##.##").format(dotProduct / ((Math.sqrt(firstVector)) * (Math.sqrt(secondVector)))));

                        movieSim1.put(String.valueOf(j),value);
                        movieSim2.put(String.valueOf(i),value);

                        movie1.setMovieSimilarity(movieSim1);
                        movie2.setMovieSimilarity(movieSim2);


                    }
                }
                d.save(movie1);
               // System.out.println(movie1);
            }

        }


    }
}
