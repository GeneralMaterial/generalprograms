import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

public class SparkAppMain {

  public static void main(String[] args) {
    System.out.println("Hello World");

    // Uncomment this line when submitting to local
    // SparkConf sparkConf = new SparkConf().setAppName("Example Spark App").setMaster("local[*]");

    // Comment this line when running local
    SparkConf sparkConf = new SparkConf().setAppName("Example Spark App");

    JavaSparkContext sparkContext = new JavaSparkContext(sparkConf);
    JavaRDD<String> stringJavaRDD = sparkContext.textFile("/analytics_data/nationalparks.csv");
    System.out.println("Number of lines in file = " + stringJavaRDD.count());

    /**
     * ./bin/spark-submit \ --master local[*] --class SparkAppMain \
     * /softwares/apm/spark-getting-started/target/spark-getting-started-1.0-SNAPSHOT.jar
     *
     * <p>./sbin/start-master.sh
     *
     * <p>./sbin/start-slave.sh spark://SFO1212395738B:7077
     *
     * <p>./bin/spark-submit \ --master spark://SFO1212395738B:7077 \ --class SparkAppMain \
     * /Projects/sts_workspace/spark-getting-started/target/spark-getting-started-1.0-SNAPSHOT.jar
     */

    /** ******************************** */
    // sc is an existing SparkContext.
    // SQLContext sqlContext = new org.apache.spark.sql.hive.HiveContext(sparkContext);
    //
    // sqlContext.sql("CREATE TABLE IF NOT EXISTS src (key INT, value STRING)");
    // sqlContext.sql("LOAD DATA LOCAL INPATH '/tmp/nationalparks.csv' INTO TABLE src");
    //
    // // Queries are expressed in HiveQL
    // sqlContext.sql("FROM src SELECT key, value").collectAsList().forEach((n) ->
    // System.out.println(n));

    /** **************************** */
    sparkContext.close();
  }
}
