package ir.exercise.p01.a;

import org.apache.lucene.analysis.standard.StandardTokenizer;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.apache.lucene.analysis.tokenattributes.OffsetAttribute;
import org.apache.lucene.analysis.tokenattributes.PositionIncrementAttribute;
import org.apache.lucene.analysis.tokenattributes.TypeAttribute;

import java.io.IOException;
import java.io.StringReader;

public class StandardTokenizerEx {
    public String printTokens(String text) throws IOException {
        // StandardTokenizer
        StandardTokenizer standardTokenizer = new StandardTokenizer();
        standardTokenizer.setReader(new StringReader(text));
        standardTokenizer.reset();

        System.out.println("StandardTokenizer:");
        while (standardTokenizer.incrementToken()) {
            CharTermAttribute charTermAttribute = standardTokenizer.getAttribute(CharTermAttribute.class);
            OffsetAttribute offsetAttribute = standardTokenizer.getAttribute(OffsetAttribute.class);
            PositionIncrementAttribute positionIncrementAttribute = standardTokenizer.getAttribute(PositionIncrementAttribute.class);
            TypeAttribute typeAttribute = standardTokenizer.getAttribute(TypeAttribute.class);

            System.out.println("Token: " + charTermAttribute.toString() +
                    ", Start Offset: " + offsetAttribute.startOffset() +
                    ", End Offset: " + offsetAttribute.endOffset() +
                    ", Position Increment: " + positionIncrementAttribute.getPositionIncrement() +
                    ", Type: " + typeAttribute.type());
        }

        System.out.println();
        return null;
    }
}
