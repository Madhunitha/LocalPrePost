package ca.pfv.spmf.test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;

import ca.pfv.spmf.algorithms.associationrules.agrawal94_association_rules.AlgoAgrawalFaster94;
import ca.pfv.spmf.algorithms.frequentpatterns.fin_prepost.PrePost;
import ca.pfv.spmf.patterns.itemset_array_integers_with_count.Itemsets;

public class MainTestAllAssociationRules_Prepost {

	public static void main(String [] arg) throws IOException{
		String input = fileToPath("contextIGB.txt");
		String output = "C:/Users/owner/Documents/output.txt";
//		String output = "C:\\patterns\\association_rules.txt";


		
		// STEP 1: Applying the FP-GROWTH algorithm to find frequent itemsets
		double minsupp = 0.8;
		PrePost prepost = new PrePost();
		Itemsets patterns = prepost.runAlgorithm(input,minsupp,null);
//		patterns.printItemsets(database.size());
		prepost.printStats();
		int databaseSize = prepost.getDatabaseSize();
		
		// STEP 2: Generating all rules from the set of frequent itemsets (based on Agrawal & Srikant, 94)
		double  minconf = 0.80;
		AlgoAgrawalFaster94 algoAgrawal = new AlgoAgrawalFaster94();
		algoAgrawal.runAlgorithm(patterns, output, databaseSize, minconf);
		algoAgrawal.printStats();
	}
	
	public static String fileToPath(String filename) throws UnsupportedEncodingException{
		URL url = MainTestAllAssociationRules_FPGrowth_saveToFile.class.getResource(filename);
		 return java.net.URLDecoder.decode(url.getPath(),"UTF-8");
	}
}

