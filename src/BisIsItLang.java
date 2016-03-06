import java.io.IOException;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
 
public class BisIsItLang
{

    /**
     * @param args the command line arguments
     * @throws IOException 
     */
    public static void main(String[] args) throws IOException
    {
    	ExpCalculatorLexer lexer = new ExpCalculatorLexer(new ANTLRFileStream(args[0]));
        lexer.removeErrorListeners();
        lexer.addErrorListener(new ExpLexerErrorListener());
    	CommonTokenStream tokens = new CommonTokenStream(lexer);
        ExpCalculatorParser p = new ExpCalculatorParser(tokens);
      
        p.setBuildParseTree(true);
        p.addParseListener(new ExpListener());
        ParserRuleContext t = p.start();
    }
    
}