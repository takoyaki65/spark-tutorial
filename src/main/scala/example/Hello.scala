package example
import org.apache.spark.sql.SparkSession

case class Person(name: String, age: Long)

object SimpleApp {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession
      .builder.appName("Simple Application").master("local[4]").getOrCreate()
    // val df = spark.read.json("src/main/resource/people.jsonl")
    // df.show()

    import spark.implicits._

    // Encoders are created for case classes
    val caseClassDS = Seq(Person("Andy", 32)).toDS()
    caseClassDS.show()

    // Encoders for most common types are automatically provided by importing spark.implicits._
    val primitiveDS = Seq(1, 2, 3).toDS()
    val res = primitiveDS.map(_ + 1).collect() // Returns: Array(2, 3, 4)
    println(res.mkString(","))
    // DataFrames can be converted to a Dataset by providing a class. Mapping will be done by name
    val path = "src/main/resource/people.jsonl"
    val peopleDS = spark.read.json(path).as[Person]
    peopleDS.show()

    spark.stop()
  }
}
