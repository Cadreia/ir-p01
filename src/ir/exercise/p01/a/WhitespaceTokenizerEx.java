package ir.exercise.p01.a;

import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.apache.lucene.analysis.tokenattributes.OffsetAttribute;
import org.apache.lucene.analysis.tokenattributes.PositionIncrementAttribute;
import org.apache.lucene.analysis.tokenattributes.TypeAttribute;
import org.apache.lucene.analysis.core.WhitespaceTokenizer;

import java.io.IOException;
import java.io.StringReader;

public class WhitespaceTokenizerEx {

    public String printTokens(String text) throws IOException {
        // WhitespaceTokenizer example
        WhitespaceTokenizer whitespaceTokenizer = new WhitespaceTokenizer();
        whitespaceTokenizer.setReader(new StringReader(text));
        whitespaceTokenizer.reset();

        System.out.println("WhitespaceTokenizer:");
        while (whitespaceTokenizer.incrementToken()) {
            CharTermAttribute charTermAttribute = whitespaceTokenizer.getAttribute(CharTermAttribute.class);
            OffsetAttribute offsetAttribute = whitespaceTokenizer.getAttribute(OffsetAttribute.class);
            PositionIncrementAttribute positionIncrementAttribute = whitespaceTokenizer.getAttribute(PositionIncrementAttribute.class);
            TypeAttribute typeAttribute = whitespaceTokenizer.getAttribute(TypeAttribute.class);

            System.out.println("Token: " + charTermAttribute.toString() +
                    ", Start Offset: " + offsetAttribute.startOffset() +
                    ", End Offset: " + offsetAttribute.endOffset() +
                    ", Position Increment: " + positionIncrementAttribute.getPositionIncrement() +
                    ", Type: " + typeAttribute.type());
        }
        return null;
    }
}