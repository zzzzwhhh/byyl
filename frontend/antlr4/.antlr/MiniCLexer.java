// Generated from /home/code/exp04-minic-expr/frontend/antlr4/MiniC.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class MiniCLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T_L_PAREN=1, T_R_PAREN=2, T_SEMICOLON=3, T_L_BRACE=4, T_R_BRACE=5, T_ASSIGN=6, 
		T_COMMA=7, T_ADD=8, T_SUB=9, T_MUL=10, T_DIV=11, T_MOD=12, T_RETURN=13, 
		T_INT=14, T_VOID=15, T_ID=16, T_DIGIT=17, T_OCTAL=18, T_HEX=19, WS=20;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T_L_PAREN", "T_R_PAREN", "T_SEMICOLON", "T_L_BRACE", "T_R_BRACE", "T_ASSIGN", 
			"T_COMMA", "T_ADD", "T_SUB", "T_MUL", "T_DIV", "T_MOD", "T_RETURN", "T_INT", 
			"T_VOID", "T_ID", "T_DIGIT", "T_OCTAL", "T_HEX", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "')'", "';'", "'{'", "'}'", "'='", "','", "'+'", "'-'", 
			"'*'", "'/'", "'%'", "'return'", "'int'", "'void'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "T_L_PAREN", "T_R_PAREN", "T_SEMICOLON", "T_L_BRACE", "T_R_BRACE", 
			"T_ASSIGN", "T_COMMA", "T_ADD", "T_SUB", "T_MUL", "T_DIV", "T_MOD", "T_RETURN", 
			"T_INT", "T_VOID", "T_ID", "T_DIGIT", "T_OCTAL", "T_HEX", "WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public MiniCLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "MiniC.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\u0004\u0000\u0014v\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b"+
		"\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002"+
		"\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002"+
		"\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0001\u0000\u0001\u0000\u0001"+
		"\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001"+
		"\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001"+
		"\u0007\u0001\u0007\u0001\b\u0001\b\u0001\t\u0001\t\u0001\n\u0001\n\u0001"+
		"\u000b\u0001\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0005\u000fT\b\u000f"+
		"\n\u000f\f\u000fW\t\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0005\u0010"+
		"\\\b\u0010\n\u0010\f\u0010_\t\u0010\u0003\u0010a\b\u0010\u0001\u0011\u0001"+
		"\u0011\u0004\u0011e\b\u0011\u000b\u0011\f\u0011f\u0001\u0012\u0001\u0012"+
		"\u0001\u0012\u0004\u0012l\b\u0012\u000b\u0012\f\u0012m\u0001\u0013\u0004"+
		"\u0013q\b\u0013\u000b\u0013\f\u0013r\u0001\u0013\u0001\u0013\u0000\u0000"+
		"\u0014\u0001\u0001\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006"+
		"\r\u0007\u000f\b\u0011\t\u0013\n\u0015\u000b\u0017\f\u0019\r\u001b\u000e"+
		"\u001d\u000f\u001f\u0010!\u0011#\u0012%\u0013\'\u0014\u0001\u0000\b\u0003"+
		"\u0000AZ__az\u0004\u000009AZ__az\u0001\u000019\u0001\u000009\u0001\u0000"+
		"07\u0002\u0000XXxx\u0003\u000009AFaf\u0003\u0000\t\n\r\r  {\u0000\u0001"+
		"\u0001\u0000\u0000\u0000\u0000\u0003\u0001\u0000\u0000\u0000\u0000\u0005"+
		"\u0001\u0000\u0000\u0000\u0000\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001"+
		"\u0000\u0000\u0000\u0000\u000b\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000"+
		"\u0000\u0000\u0000\u000f\u0001\u0000\u0000\u0000\u0000\u0011\u0001\u0000"+
		"\u0000\u0000\u0000\u0013\u0001\u0000\u0000\u0000\u0000\u0015\u0001\u0000"+
		"\u0000\u0000\u0000\u0017\u0001\u0000\u0000\u0000\u0000\u0019\u0001\u0000"+
		"\u0000\u0000\u0000\u001b\u0001\u0000\u0000\u0000\u0000\u001d\u0001\u0000"+
		"\u0000\u0000\u0000\u001f\u0001\u0000\u0000\u0000\u0000!\u0001\u0000\u0000"+
		"\u0000\u0000#\u0001\u0000\u0000\u0000\u0000%\u0001\u0000\u0000\u0000\u0000"+
		"\'\u0001\u0000\u0000\u0000\u0001)\u0001\u0000\u0000\u0000\u0003+\u0001"+
		"\u0000\u0000\u0000\u0005-\u0001\u0000\u0000\u0000\u0007/\u0001\u0000\u0000"+
		"\u0000\t1\u0001\u0000\u0000\u0000\u000b3\u0001\u0000\u0000\u0000\r5\u0001"+
		"\u0000\u0000\u0000\u000f7\u0001\u0000\u0000\u0000\u00119\u0001\u0000\u0000"+
		"\u0000\u0013;\u0001\u0000\u0000\u0000\u0015=\u0001\u0000\u0000\u0000\u0017"+
		"?\u0001\u0000\u0000\u0000\u0019A\u0001\u0000\u0000\u0000\u001bH\u0001"+
		"\u0000\u0000\u0000\u001dL\u0001\u0000\u0000\u0000\u001fQ\u0001\u0000\u0000"+
		"\u0000!`\u0001\u0000\u0000\u0000#b\u0001\u0000\u0000\u0000%h\u0001\u0000"+
		"\u0000\u0000\'p\u0001\u0000\u0000\u0000)*\u0005(\u0000\u0000*\u0002\u0001"+
		"\u0000\u0000\u0000+,\u0005)\u0000\u0000,\u0004\u0001\u0000\u0000\u0000"+
		"-.\u0005;\u0000\u0000.\u0006\u0001\u0000\u0000\u0000/0\u0005{\u0000\u0000"+
		"0\b\u0001\u0000\u0000\u000012\u0005}\u0000\u00002\n\u0001\u0000\u0000"+
		"\u000034\u0005=\u0000\u00004\f\u0001\u0000\u0000\u000056\u0005,\u0000"+
		"\u00006\u000e\u0001\u0000\u0000\u000078\u0005+\u0000\u00008\u0010\u0001"+
		"\u0000\u0000\u00009:\u0005-\u0000\u0000:\u0012\u0001\u0000\u0000\u0000"+
		";<\u0005*\u0000\u0000<\u0014\u0001\u0000\u0000\u0000=>\u0005/\u0000\u0000"+
		">\u0016\u0001\u0000\u0000\u0000?@\u0005%\u0000\u0000@\u0018\u0001\u0000"+
		"\u0000\u0000AB\u0005r\u0000\u0000BC\u0005e\u0000\u0000CD\u0005t\u0000"+
		"\u0000DE\u0005u\u0000\u0000EF\u0005r\u0000\u0000FG\u0005n\u0000\u0000"+
		"G\u001a\u0001\u0000\u0000\u0000HI\u0005i\u0000\u0000IJ\u0005n\u0000\u0000"+
		"JK\u0005t\u0000\u0000K\u001c\u0001\u0000\u0000\u0000LM\u0005v\u0000\u0000"+
		"MN\u0005o\u0000\u0000NO\u0005i\u0000\u0000OP\u0005d\u0000\u0000P\u001e"+
		"\u0001\u0000\u0000\u0000QU\u0007\u0000\u0000\u0000RT\u0007\u0001\u0000"+
		"\u0000SR\u0001\u0000\u0000\u0000TW\u0001\u0000\u0000\u0000US\u0001\u0000"+
		"\u0000\u0000UV\u0001\u0000\u0000\u0000V \u0001\u0000\u0000\u0000WU\u0001"+
		"\u0000\u0000\u0000Xa\u00050\u0000\u0000Y]\u0007\u0002\u0000\u0000Z\\\u0007"+
		"\u0003\u0000\u0000[Z\u0001\u0000\u0000\u0000\\_\u0001\u0000\u0000\u0000"+
		"][\u0001\u0000\u0000\u0000]^\u0001\u0000\u0000\u0000^a\u0001\u0000\u0000"+
		"\u0000_]\u0001\u0000\u0000\u0000`X\u0001\u0000\u0000\u0000`Y\u0001\u0000"+
		"\u0000\u0000a\"\u0001\u0000\u0000\u0000bd\u00050\u0000\u0000ce\u0007\u0004"+
		"\u0000\u0000dc\u0001\u0000\u0000\u0000ef\u0001\u0000\u0000\u0000fd\u0001"+
		"\u0000\u0000\u0000fg\u0001\u0000\u0000\u0000g$\u0001\u0000\u0000\u0000"+
		"hi\u00050\u0000\u0000ik\u0007\u0005\u0000\u0000jl\u0007\u0006\u0000\u0000"+
		"kj\u0001\u0000\u0000\u0000lm\u0001\u0000\u0000\u0000mk\u0001\u0000\u0000"+
		"\u0000mn\u0001\u0000\u0000\u0000n&\u0001\u0000\u0000\u0000oq\u0007\u0007"+
		"\u0000\u0000po\u0001\u0000\u0000\u0000qr\u0001\u0000\u0000\u0000rp\u0001"+
		"\u0000\u0000\u0000rs\u0001\u0000\u0000\u0000st\u0001\u0000\u0000\u0000"+
		"tu\u0006\u0013\u0000\u0000u(\u0001\u0000\u0000\u0000\u0007\u0000U]`fm"+
		"r\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}