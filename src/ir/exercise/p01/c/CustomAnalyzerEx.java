package ir.exercise.p01.c;

import org.apache.lucene.analysis.*;
import org.apache.lucene.analysis.en.PorterStemFilter;
import org.apache.lucene.analysis.standard.StandardTokenizer;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;

import java.io.IOException;
import java.io.StringReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CustomAnalyzerEx {

    private static Analyzer createCustomAnalyzer() {
        Set<String> stopwordSet = new HashSet<>(Arrays.asList(new String[]{"was", "is", "in", "to", "be"}));
        return new StopwordAnalyzerBase(CharArraySet.copy(stopwordSet)) {
            @Override
            protected TokenStreamComponents createComponents(String fieldName) {
                StandardTokenizer tokenizer = new StandardTokenizer();
                TokenStream tokenStream = new LowerCaseFilter(tokenizer);
                tokenStream = new StopFilter(tokenStream, stopwords);
                tokenStream = new PorterStemFilter(tokenStream);
                return new TokenStreamComponents(tokenizer, tokenStream);
            }
        };
    }

    public static void printTokens(String text) {
        Analyzer analyzer = createCustomAnalyzer();
        try (TokenStream tokenStream = analyzer.tokenStream(null, new StringReader(text))) {
            tokenStream.reset();
            while (tokenStream.incrementToken()) {
                System.out.println(tokenStream.getAttribute(CharTermAttribute.class).toString());
            }
            tokenStream.end();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}