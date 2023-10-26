package ir.exercise.p01;

import ir.exercise.p01.a.StandardTokenizerEx;
import ir.exercise.p01.a.WhitespaceTokenizerEx;
import ir.exercise.p01.b.StopwordFilterEx;
import ir.exercise.p01.c.CustomAnalyzerEx;
import ir.exercise.p01.c.CustomAnalyzerExtra;
import org.apache.lucene.analysis.Analyzer;

public class AppMain {
    public static void main(String[] args) throws Exception {
        String text = LuceneConstants.text;

        // Print tokens from Standard Tokenizer
        StandardTokenizerEx standardTokenizer = new StandardTokenizerEx();
        standardTokenizer.printTokens(text);

        System.out.println("1==============================================");


        // Print tokens from Whitespace Tokenizer
        WhitespaceTokenizerEx whitespaceTokenizer = new WhitespaceTokenizerEx();
        whitespaceTokenizer.printTokens(text);

        System.out.println("2==============================================");


        // Print tokens after applying Standard Tokenizer and Stopword Filter
        StopwordFilterEx stopwordFilter = new StopwordFilterEx();
        stopwordFilter.printTokens(text);

        System.out.println("3==============================================");


        // Print tokens after applying custom analyzer
        CustomAnalyzerEx customAnalyzer = new CustomAnalyzerEx();
        customAnalyzer.printTokens(text);

        System.out.println("4==============================================");


        // Print tokens after applying custom analyzer extra
        CustomAnalyzerExtra customAnalyzerExtra = new CustomAnalyzerExtra();
        customAnalyzerExtra.printTokens(text);
    }
}
