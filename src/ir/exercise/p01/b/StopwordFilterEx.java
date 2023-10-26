package ir.exercise.p01.b;

import org.apache.lucene.analysis.CharArraySet;
import org.apache.lucene.analysis.standard.StandardTokenizer;
import org.apache.lucene.analysis.StopFilter;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;

import java.io.IOException;
import java.io.StringReader;
import java.util.Arrays;

public class StopwordFilterEx {
    public String printTokens(String text) throws IOException {
        // Using StandardTokenizer
        StandardTokenizer standardTokenizer = new StandardTokenizer();
        standardTokenizer.setReader(new StringReader(text));
        standardTokenizer.reset();

        // Using StopwordFilter
        StopFilter stopwordFilter = new StopFilter(standardTokenizer, new CharArraySet(Arrays.asList("was", "is", "in", "to", "be"), true));
        CharTermAttribute termAttribute = stopwordFilter.addAttribute(CharTermAttribute.class);

        while (stopwordFilter.incrementToken()) {
            System.out.println(termAttribute.toString());
        }
        return null;
    }
}