package Package;
// Import the Scanner class to read text files
public class HelloMain{ 
  
/** Main class calls all 4 type of dataset 
 * 
 * @param args
 */
  public static void main(String []args){
    Runtime runtime = Runtime.getRuntime ();
     RealDataSet1 rds1 = new RealDataSet1();
     RealDataSet2 rds2 = new RealDataSet2();
     SyntheticDataSet1 sds1= new SyntheticDataSet1();
     SyntheticDataASet2 sds2= new SyntheticDataASet2();
     
    rds1.genertatingDataSet(runtime);
    rds2.genertatingDataSet(runtime);
    sds1.genertatingDataSet(runtime);
    sds2.genertatingDataSet(runtime);


}

  
}
