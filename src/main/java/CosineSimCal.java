import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

/**
 * Created by sruthipotluri on 11/18/17.
 */
public class CosineSimCal {
    TreeMap<String, Movie> utilityMatrix = new TreeMap<String, Movie>();
  //  double[][] cosineSim = new double[7][7];
  //  double[][] cosineSim = new double[3953][3953];
    Movie movie1 = null, movie2 = null;




    public CosineSimCal(TreeMap<String, Movie> utilityMatrix) {
        this.utilityMatrix = utilityMatrix;
    }

    public void calculate() throws IOException {
        System.out.println("the size is " + utilityMatrix.size());
       //for (int i = 1; i <= 6; i++) {

              for (int i = 1; i <= 3952; i++) {


            if (utilityMatrix.containsKey(String.valueOf(i))) {
                movie1 = utilityMatrix.get(String.valueOf(i));

                //System.out.println(movie1);

                //System.out.println(movie1.getUserlist());

                TreeMap<String, Double> userList1 = movie1.getUserlist();
                TreeMap<String, Double> movieSim1 = movie1.getMovieSimilarity();

                double sum1 = 0;

                for (Double a : userList1.values()) {
                    sum1 += a;
                }

                double normalise1 = sum1 / userList1.size();
                double firstVector = 0.0;

                TreeMap<String, Double> normalizeduserList1 = new TreeMap<String, Double>();

                for (String a : userList1.keySet()) {
                    Double value = userList1.get(a);
                    double value1 = Double.parseDouble(new DecimalFormat("#.##").format(value - normalise1));
                    normalizeduserList1.put(a, value1);
                    firstVector += value1 * value1;
                }

                Set<String> keyOfMov1 = userList1.keySet();

                 for (int j = i + 1; j <= 3952; j++) {
                //for (int j = i; j <= 6; j++) {

                    if (utilityMatrix.containsKey(String.valueOf(j))) {
                        movie2 = utilityMatrix.get(String.valueOf(j));

                       // System.out.println("Movie "+ j + movie2);
                        TreeMap<String, Double> userList2 = movie2.getUserlist();
                        TreeMap<String, Double> movieSim2 = movie2.getMovieSimilarity();

                        double sum2 = 0;

                        for (Double b : userList2.values()) {
                            sum2 += b;
                        }


                        double normalise2 = sum2 / userList2.size();


                        TreeMap<String, Double> normalizeduserList2 = new TreeMap<String, Double>();

                        double secondVector = 0.0;

                        for (String a : userList2.keySet()) {
                            Double value = userList2.get(a);
                            double value2 = Double.parseDouble(new DecimalFormat("#.##").format(value - normalise2));
                            normalizeduserList2.put(a, value2);
                            secondVector += value2 * value2;
                        }


               /* System.out.println("for movie " +i +" and movie "+j);
                System.out.println(keyOfMov1); */
                        Set<String> requiredKeys = new HashSet<String> (userList2.keySet());
                        // System.out.println(requiredKeys);
                      //  System.out.println("Befor");
                      //  System.out.println(userList2);
                        requiredKeys.retainAll(keyOfMov1);
                     //   System.out.println("afet");
                      //  System.out.println(userList2);


                        // System.out.println(requiredKeys);
                       //  System.out.println("for movie"+ i +" and "+ j);
                      //  System.out.println(userList1);
                       //  System.out.println(normalizeduserList1);
                      //  System.out.println(userList2);
                       //  System.out.println(normalizeduserList2);
                        // System.out.println(requiredKeys);
                        double cosSim = 0.0, dotProduct = 0.0;
                        //Calculating CosineSimilarity;
                        Iterator it = requiredKeys.iterator();

                        while (it.hasNext()) {
                            String key = (String) it.next();
                            dotProduct += normalizeduserList1.get(key) * normalizeduserList2.get(key);
                            // firstVector+= normalizeduserList1.get(key) * normalizeduserList1.get(key);
                            //  secondVector+= normalizeduserList2.get(key) * normalizeduserList2.get(key);

                        }


                        double value = 0.0;
                        if(dotProduct!=0)
                        value = Double.parseDouble(new DecimalFormat("##.##").format(dotProduct / ((Math.sqrt(firstVector)) * (Math.sqrt(secondVector)))));
                        //System.out.println(value);


                       // cosineSim[i][j] = Double.parseDouble(new DecimalFormat("##.##").format(value));
                      //  cosineSim[j][i] = cosineSim[i][j];
                        movieSim1.put(String.valueOf(j),value);
                        movieSim2.put(String.valueOf(i),value);
                        movie1.setMovieSimilarity(movieSim1);
                        movie2.setMovieSimilarity(movieSim2);



                    }

                }
                Driver d = new Driver ();
                d.save(movie1);
               // System.out.println(movie1);
            }
        }

       // BufferedWriter br = new BufferedWriter(new FileWriter(new File("/Users/sruthipotluri/Desktop/matrix6.txt")));


      /* for (int i = 1; i <= 6; i++) {
            for (int j = 1; j <= 6; j++) {
                System.out.print(cosineSim[i][j] + " | ");
            }
            System.out.println(" ");
        } */


    }
}
