package ir.exercise.p01;

import ir.exercise.p01.a.StandardTokenizerEx;
import ir.exercise.p01.a.WhitespaceTokenizerEx;
import ir.exercise.p01.b.StopwordFilterEx;
import ir.exercise.p01.c.CustomAnalyzerEx;

public class AppMain {
    public static void main(String[] args) throws Exception {
        String text = LuceneConstants.text;

        System.out.println("======================Standard Tokenizer========================");
        // Print tokens from Standard Tokenizer
        StandardTokenizerEx standardTokenizer = new StandardTokenizerEx();
        standardTokenizer.printTokens(text);

        System.out.println("===================Whitespace Tokenizer=========================");
        // Print tokens from Whitespace Tokenizer
        WhitespaceTokenizerEx whitespaceTokenizer = new WhitespaceTokenizerEx();
        whitespaceTokenizer.printTokens(text);

        System.out.println("============Standard Tokenizer and Stopword Filter==============");
        // Print tokens after applying Standard Tokenizer and Stopword Filter
        StopwordFilterEx stopwordFilter = new StopwordFilterEx();
        stopwordFilter.printTokens(text);

        System.out.println("======================Custom Analyzer==========================");
        // Print tokens after applying Custom Analyzer
        CustomAnalyzerEx customAnalyzer = new CustomAnalyzerEx();
        customAnalyzer.printTokens(text);
    }
}
