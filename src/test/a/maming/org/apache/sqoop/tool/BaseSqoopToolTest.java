package a.maming.org.apache.sqoop.tool;

import java.util.Arrays;

public class BaseSqoopToolTest {

	  protected String [] getSubcommandArgs(String [] argv) {
		    if (null == argv) {
		      return null;
		    }

		    for (int i = 0; i < argv.length; i++) {
		      if (argv[i].equals("--")) {
		        return Arrays.copyOfRange(argv, i + 1, argv.length);
		      }
		    }

		    return null;
	 }
	  
	  public static void main(String[] args) {
		  BaseSqoopToolTest test = new BaseSqoopToolTest();
		  String[] arr = new String[]{"aa","--","cc","dd","ee"};
		  String[] values = test.getSubcommandArgs(arr);
		  for(String value:values){
			  System.out.println(value);
		  }
	  }
	  
}
