package ca.pfv.spmf.test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;

import ca.pfv.spmf.algorithms.frequentpatterns.fin_prepost.PrePost;
import ca.pfv.spmf.patterns.itemset_array_integers_with_count.Itemsets;

/**
 * Example of how to use PrePost algorithm from the source code.
 * @author Philippe Fournier-Viger (Copyright 2014)
 */
public class MainTestPrePost_savetomem {

	public static void main(String [] arg) throws IOException{

		String input = fileToPath("contextPasquier99.txt");
		//String output = "C:/Users/owner/Documents/output.txt";  // the path for saving the frequent itemsets found
		
		double minsup = 0.8; // means a minsup of 2 transaction (we used a relative support)
		// Applying the algorithm
		PrePost prepost = new PrePost();
		Itemsets patterns =prepost.runAlgorithm(input, minsup, null);
		prepost.printStats();
		patterns.printItemsets(prepost.getDatabaseSize());
	}
	
	public static String fileToPath(String filename) throws UnsupportedEncodingException{
		URL url = MainTestPrePost_savetomem.class.getResource(filename);
		 return java.net.URLDecoder.decode(url.getPath(),"UTF-8");
	}
}
