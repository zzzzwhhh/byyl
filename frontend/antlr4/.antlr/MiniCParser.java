// Generated from /home/code/exp04-minic-expr/frontend/antlr4/MiniC.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class MiniCParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T_L_PAREN=1, T_R_PAREN=2, T_SEMICOLON=3, T_L_BRACE=4, T_R_BRACE=5, T_ASSIGN=6, 
		T_COMMA=7, T_ADD=8, T_SUB=9, T_MUL=10, T_DIV=11, T_MOD=12, T_RETURN=13, 
		T_INT=14, T_VOID=15, T_ID=16, T_DIGIT=17, T_OCTAL=18, T_HEX=19, WS=20;
	public static final int
		RULE_compileUnit = 0, RULE_funcDef = 1, RULE_block = 2, RULE_blockItemList = 3, 
		RULE_blockItem = 4, RULE_varDecl = 5, RULE_basicType = 6, RULE_varDef = 7, 
		RULE_statement = 8, RULE_expr = 9, RULE_mulExp = 10, RULE_addExp = 11, 
		RULE_mulOp = 12, RULE_addOp = 13, RULE_unaryExp = 14, RULE_primaryExp = 15, 
		RULE_realParamList = 16, RULE_lVal = 17;
	private static String[] makeRuleNames() {
		return new String[] {
			"compileUnit", "funcDef", "block", "blockItemList", "blockItem", "varDecl", 
			"basicType", "varDef", "statement", "expr", "mulExp", "addExp", "mulOp", 
			"addOp", "unaryExp", "primaryExp", "realParamList", "lVal"
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

	@Override
	public String getGrammarFileName() { return "MiniC.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public MiniCParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CompileUnitContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(MiniCParser.EOF, 0); }
		public List<FuncDefContext> funcDef() {
			return getRuleContexts(FuncDefContext.class);
		}
		public FuncDefContext funcDef(int i) {
			return getRuleContext(FuncDefContext.class,i);
		}
		public List<VarDeclContext> varDecl() {
			return getRuleContexts(VarDeclContext.class);
		}
		public VarDeclContext varDecl(int i) {
			return getRuleContext(VarDeclContext.class,i);
		}
		public CompileUnitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compileUnit; }
	}

	public final CompileUnitContext compileUnit() throws RecognitionException {
		CompileUnitContext _localctx = new CompileUnitContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_compileUnit);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(40);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T_INT) {
				{
				setState(38);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
				case 1:
					{
					setState(36);
					funcDef();
					}
					break;
				case 2:
					{
					setState(37);
					varDecl();
					}
					break;
				}
				}
				setState(42);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(43);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FuncDefContext extends ParserRuleContext {
		public TerminalNode T_INT() { return getToken(MiniCParser.T_INT, 0); }
		public TerminalNode T_ID() { return getToken(MiniCParser.T_ID, 0); }
		public TerminalNode T_L_PAREN() { return getToken(MiniCParser.T_L_PAREN, 0); }
		public TerminalNode T_R_PAREN() { return getToken(MiniCParser.T_R_PAREN, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public FuncDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcDef; }
	}

	public final FuncDefContext funcDef() throws RecognitionException {
		FuncDefContext _localctx = new FuncDefContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_funcDef);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(45);
			match(T_INT);
			setState(46);
			match(T_ID);
			setState(47);
			match(T_L_PAREN);
			setState(48);
			match(T_R_PAREN);
			setState(49);
			block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BlockContext extends ParserRuleContext {
		public TerminalNode T_L_BRACE() { return getToken(MiniCParser.T_L_BRACE, 0); }
		public TerminalNode T_R_BRACE() { return getToken(MiniCParser.T_R_BRACE, 0); }
		public BlockItemListContext blockItemList() {
			return getRuleContext(BlockItemListContext.class,0);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(51);
			match(T_L_BRACE);
			setState(53);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1008154L) != 0)) {
				{
				setState(52);
				blockItemList();
				}
			}

			setState(55);
			match(T_R_BRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BlockItemListContext extends ParserRuleContext {
		public List<BlockItemContext> blockItem() {
			return getRuleContexts(BlockItemContext.class);
		}
		public BlockItemContext blockItem(int i) {
			return getRuleContext(BlockItemContext.class,i);
		}
		public BlockItemListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_blockItemList; }
	}

	public final BlockItemListContext blockItemList() throws RecognitionException {
		BlockItemListContext _localctx = new BlockItemListContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_blockItemList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(58); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(57);
				blockItem();
				}
				}
				setState(60); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 1008154L) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BlockItemContext extends ParserRuleContext {
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public VarDeclContext varDecl() {
			return getRuleContext(VarDeclContext.class,0);
		}
		public BlockItemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_blockItem; }
	}

	public final BlockItemContext blockItem() throws RecognitionException {
		BlockItemContext _localctx = new BlockItemContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_blockItem);
		try {
			setState(64);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T_L_PAREN:
			case T_SEMICOLON:
			case T_L_BRACE:
			case T_SUB:
			case T_RETURN:
			case T_ID:
			case T_DIGIT:
			case T_OCTAL:
			case T_HEX:
				enterOuterAlt(_localctx, 1);
				{
				setState(62);
				statement();
				}
				break;
			case T_INT:
				enterOuterAlt(_localctx, 2);
				{
				setState(63);
				varDecl();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class VarDeclContext extends ParserRuleContext {
		public BasicTypeContext basicType() {
			return getRuleContext(BasicTypeContext.class,0);
		}
		public List<VarDefContext> varDef() {
			return getRuleContexts(VarDefContext.class);
		}
		public VarDefContext varDef(int i) {
			return getRuleContext(VarDefContext.class,i);
		}
		public TerminalNode T_SEMICOLON() { return getToken(MiniCParser.T_SEMICOLON, 0); }
		public List<TerminalNode> T_COMMA() { return getTokens(MiniCParser.T_COMMA); }
		public TerminalNode T_COMMA(int i) {
			return getToken(MiniCParser.T_COMMA, i);
		}
		public VarDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDecl; }
	}

	public final VarDeclContext varDecl() throws RecognitionException {
		VarDeclContext _localctx = new VarDeclContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_varDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(66);
			basicType();
			setState(67);
			varDef();
			setState(72);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T_COMMA) {
				{
				{
				setState(68);
				match(T_COMMA);
				setState(69);
				varDef();
				}
				}
				setState(74);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(75);
			match(T_SEMICOLON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BasicTypeContext extends ParserRuleContext {
		public TerminalNode T_INT() { return getToken(MiniCParser.T_INT, 0); }
		public BasicTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_basicType; }
	}

	public final BasicTypeContext basicType() throws RecognitionException {
		BasicTypeContext _localctx = new BasicTypeContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_basicType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(77);
			match(T_INT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class VarDefContext extends ParserRuleContext {
		public TerminalNode T_ID() { return getToken(MiniCParser.T_ID, 0); }
		public VarDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDef; }
	}

	public final VarDefContext varDef() throws RecognitionException {
		VarDefContext _localctx = new VarDefContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_varDef);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(79);
			match(T_ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StatementContext extends ParserRuleContext {
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
	 
		public StatementContext() { }
		public void copyFrom(StatementContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BlockStatementContext extends StatementContext {
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public BlockStatementContext(StatementContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AssignStatementContext extends StatementContext {
		public LValContext lVal() {
			return getRuleContext(LValContext.class,0);
		}
		public TerminalNode T_ASSIGN() { return getToken(MiniCParser.T_ASSIGN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode T_SEMICOLON() { return getToken(MiniCParser.T_SEMICOLON, 0); }
		public AssignStatementContext(StatementContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionStatementContext extends StatementContext {
		public TerminalNode T_SEMICOLON() { return getToken(MiniCParser.T_SEMICOLON, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ExpressionStatementContext(StatementContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ReturnStatementContext extends StatementContext {
		public TerminalNode T_RETURN() { return getToken(MiniCParser.T_RETURN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode T_SEMICOLON() { return getToken(MiniCParser.T_SEMICOLON, 0); }
		public ReturnStatementContext(StatementContext ctx) { copyFrom(ctx); }
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_statement);
		int _la;
		try {
			setState(95);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				_localctx = new ReturnStatementContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(81);
				match(T_RETURN);
				setState(82);
				expr();
				setState(83);
				match(T_SEMICOLON);
				}
				break;
			case 2:
				_localctx = new AssignStatementContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(85);
				lVal();
				setState(86);
				match(T_ASSIGN);
				setState(87);
				expr();
				setState(88);
				match(T_SEMICOLON);
				}
				break;
			case 3:
				_localctx = new BlockStatementContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(90);
				block();
				}
				break;
			case 4:
				_localctx = new ExpressionStatementContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(92);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 983554L) != 0)) {
					{
					setState(91);
					expr();
					}
				}

				setState(94);
				match(T_SEMICOLON);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExprContext extends ParserRuleContext {
		public AddExpContext addExp() {
			return getRuleContext(AddExpContext.class,0);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(97);
			addExp();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MulExpContext extends ParserRuleContext {
		public List<UnaryExpContext> unaryExp() {
			return getRuleContexts(UnaryExpContext.class);
		}
		public UnaryExpContext unaryExp(int i) {
			return getRuleContext(UnaryExpContext.class,i);
		}
		public List<MulOpContext> mulOp() {
			return getRuleContexts(MulOpContext.class);
		}
		public MulOpContext mulOp(int i) {
			return getRuleContext(MulOpContext.class,i);
		}
		public MulExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mulExp; }
	}

	public final MulExpContext mulExp() throws RecognitionException {
		MulExpContext _localctx = new MulExpContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_mulExp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(99);
			unaryExp();
			setState(105);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 7168L) != 0)) {
				{
				{
				setState(100);
				mulOp();
				setState(101);
				unaryExp();
				}
				}
				setState(107);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AddExpContext extends ParserRuleContext {
		public List<MulExpContext> mulExp() {
			return getRuleContexts(MulExpContext.class);
		}
		public MulExpContext mulExp(int i) {
			return getRuleContext(MulExpContext.class,i);
		}
		public List<AddOpContext> addOp() {
			return getRuleContexts(AddOpContext.class);
		}
		public AddOpContext addOp(int i) {
			return getRuleContext(AddOpContext.class,i);
		}
		public AddExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_addExp; }
	}

	public final AddExpContext addExp() throws RecognitionException {
		AddExpContext _localctx = new AddExpContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_addExp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(108);
			mulExp();
			setState(114);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T_ADD || _la==T_SUB) {
				{
				{
				setState(109);
				addOp();
				setState(110);
				mulExp();
				}
				}
				setState(116);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MulOpContext extends ParserRuleContext {
		public TerminalNode T_MUL() { return getToken(MiniCParser.T_MUL, 0); }
		public TerminalNode T_DIV() { return getToken(MiniCParser.T_DIV, 0); }
		public TerminalNode T_MOD() { return getToken(MiniCParser.T_MOD, 0); }
		public MulOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mulOp; }
	}

	public final MulOpContext mulOp() throws RecognitionException {
		MulOpContext _localctx = new MulOpContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_mulOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(117);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 7168L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AddOpContext extends ParserRuleContext {
		public TerminalNode T_ADD() { return getToken(MiniCParser.T_ADD, 0); }
		public TerminalNode T_SUB() { return getToken(MiniCParser.T_SUB, 0); }
		public AddOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_addOp; }
	}

	public final AddOpContext addOp() throws RecognitionException {
		AddOpContext _localctx = new AddOpContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_addOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(119);
			_la = _input.LA(1);
			if ( !(_la==T_ADD || _la==T_SUB) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class UnaryExpContext extends ParserRuleContext {
		public UnaryExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unaryExp; }
	 
		public UnaryExpContext() { }
		public void copyFrom(UnaryExpContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PrimaryExpRuleContext extends UnaryExpContext {
		public PrimaryExpContext primaryExp() {
			return getRuleContext(PrimaryExpContext.class,0);
		}
		public PrimaryExpRuleContext(UnaryExpContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NegExpContext extends UnaryExpContext {
		public TerminalNode T_SUB() { return getToken(MiniCParser.T_SUB, 0); }
		public UnaryExpContext unaryExp() {
			return getRuleContext(UnaryExpContext.class,0);
		}
		public NegExpContext(UnaryExpContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FuncCallRuleContext extends UnaryExpContext {
		public TerminalNode T_ID() { return getToken(MiniCParser.T_ID, 0); }
		public TerminalNode T_L_PAREN() { return getToken(MiniCParser.T_L_PAREN, 0); }
		public TerminalNode T_R_PAREN() { return getToken(MiniCParser.T_R_PAREN, 0); }
		public RealParamListContext realParamList() {
			return getRuleContext(RealParamListContext.class,0);
		}
		public FuncCallRuleContext(UnaryExpContext ctx) { copyFrom(ctx); }
	}

	public final UnaryExpContext unaryExp() throws RecognitionException {
		UnaryExpContext _localctx = new UnaryExpContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_unaryExp);
		int _la;
		try {
			setState(130);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				_localctx = new PrimaryExpRuleContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(121);
				primaryExp();
				}
				break;
			case 2:
				_localctx = new NegExpContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(122);
				match(T_SUB);
				setState(123);
				unaryExp();
				}
				break;
			case 3:
				_localctx = new FuncCallRuleContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(124);
				match(T_ID);
				setState(125);
				match(T_L_PAREN);
				setState(127);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 983554L) != 0)) {
					{
					setState(126);
					realParamList();
					}
				}

				setState(129);
				match(T_R_PAREN);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PrimaryExpContext extends ParserRuleContext {
		public TerminalNode T_L_PAREN() { return getToken(MiniCParser.T_L_PAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode T_R_PAREN() { return getToken(MiniCParser.T_R_PAREN, 0); }
		public TerminalNode T_DIGIT() { return getToken(MiniCParser.T_DIGIT, 0); }
		public TerminalNode T_OCTAL() { return getToken(MiniCParser.T_OCTAL, 0); }
		public TerminalNode T_HEX() { return getToken(MiniCParser.T_HEX, 0); }
		public LValContext lVal() {
			return getRuleContext(LValContext.class,0);
		}
		public PrimaryExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primaryExp; }
	}

	public final PrimaryExpContext primaryExp() throws RecognitionException {
		PrimaryExpContext _localctx = new PrimaryExpContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_primaryExp);
		try {
			setState(140);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T_L_PAREN:
				enterOuterAlt(_localctx, 1);
				{
				setState(132);
				match(T_L_PAREN);
				setState(133);
				expr();
				setState(134);
				match(T_R_PAREN);
				}
				break;
			case T_DIGIT:
				enterOuterAlt(_localctx, 2);
				{
				setState(136);
				match(T_DIGIT);
				}
				break;
			case T_OCTAL:
				enterOuterAlt(_localctx, 3);
				{
				setState(137);
				match(T_OCTAL);
				}
				break;
			case T_HEX:
				enterOuterAlt(_localctx, 4);
				{
				setState(138);
				match(T_HEX);
				}
				break;
			case T_ID:
				enterOuterAlt(_localctx, 5);
				{
				setState(139);
				lVal();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class RealParamListContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> T_COMMA() { return getTokens(MiniCParser.T_COMMA); }
		public TerminalNode T_COMMA(int i) {
			return getToken(MiniCParser.T_COMMA, i);
		}
		public RealParamListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_realParamList; }
	}

	public final RealParamListContext realParamList() throws RecognitionException {
		RealParamListContext _localctx = new RealParamListContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_realParamList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(142);
			expr();
			setState(147);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T_COMMA) {
				{
				{
				setState(143);
				match(T_COMMA);
				setState(144);
				expr();
				}
				}
				setState(149);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LValContext extends ParserRuleContext {
		public TerminalNode T_ID() { return getToken(MiniCParser.T_ID, 0); }
		public LValContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lVal; }
	}

	public final LValContext lVal() throws RecognitionException {
		LValContext _localctx = new LValContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_lVal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(150);
			match(T_ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\u0004\u0001\u0014\u0099\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004"+
		"\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007"+
		"\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b"+
		"\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007"+
		"\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0001\u0000\u0001"+
		"\u0000\u0005\u0000\'\b\u0000\n\u0000\f\u0000*\t\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0002\u0001\u0002\u0003\u00026\b\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0003\u0004\u0003;\b\u0003\u000b\u0003\f\u0003<\u0001\u0004"+
		"\u0001\u0004\u0003\u0004A\b\u0004\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0005\u0005G\b\u0005\n\u0005\f\u0005J\t\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0003\b]\b\b\u0001\b\u0003\b`\b\b\u0001\t\u0001\t\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0005\nh\b\n\n\n\f\nk\t\n\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0005\u000bq\b\u000b\n\u000b\f\u000bt\t\u000b\u0001\f\u0001"+
		"\f\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0003\u000e\u0080\b\u000e\u0001\u000e\u0003\u000e\u0083"+
		"\b\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0003\u000f\u008d\b\u000f\u0001\u0010\u0001"+
		"\u0010\u0001\u0010\u0005\u0010\u0092\b\u0010\n\u0010\f\u0010\u0095\t\u0010"+
		"\u0001\u0011\u0001\u0011\u0001\u0011\u0000\u0000\u0012\u0000\u0002\u0004"+
		"\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e \""+
		"\u0000\u0002\u0001\u0000\n\f\u0001\u0000\b\t\u009a\u0000(\u0001\u0000"+
		"\u0000\u0000\u0002-\u0001\u0000\u0000\u0000\u00043\u0001\u0000\u0000\u0000"+
		"\u0006:\u0001\u0000\u0000\u0000\b@\u0001\u0000\u0000\u0000\nB\u0001\u0000"+
		"\u0000\u0000\fM\u0001\u0000\u0000\u0000\u000eO\u0001\u0000\u0000\u0000"+
		"\u0010_\u0001\u0000\u0000\u0000\u0012a\u0001\u0000\u0000\u0000\u0014c"+
		"\u0001\u0000\u0000\u0000\u0016l\u0001\u0000\u0000\u0000\u0018u\u0001\u0000"+
		"\u0000\u0000\u001aw\u0001\u0000\u0000\u0000\u001c\u0082\u0001\u0000\u0000"+
		"\u0000\u001e\u008c\u0001\u0000\u0000\u0000 \u008e\u0001\u0000\u0000\u0000"+
		"\"\u0096\u0001\u0000\u0000\u0000$\'\u0003\u0002\u0001\u0000%\'\u0003\n"+
		"\u0005\u0000&$\u0001\u0000\u0000\u0000&%\u0001\u0000\u0000\u0000\'*\u0001"+
		"\u0000\u0000\u0000(&\u0001\u0000\u0000\u0000()\u0001\u0000\u0000\u0000"+
		")+\u0001\u0000\u0000\u0000*(\u0001\u0000\u0000\u0000+,\u0005\u0000\u0000"+
		"\u0001,\u0001\u0001\u0000\u0000\u0000-.\u0005\u000e\u0000\u0000./\u0005"+
		"\u0010\u0000\u0000/0\u0005\u0001\u0000\u000001\u0005\u0002\u0000\u0000"+
		"12\u0003\u0004\u0002\u00002\u0003\u0001\u0000\u0000\u000035\u0005\u0004"+
		"\u0000\u000046\u0003\u0006\u0003\u000054\u0001\u0000\u0000\u000056\u0001"+
		"\u0000\u0000\u000067\u0001\u0000\u0000\u000078\u0005\u0005\u0000\u0000"+
		"8\u0005\u0001\u0000\u0000\u00009;\u0003\b\u0004\u0000:9\u0001\u0000\u0000"+
		"\u0000;<\u0001\u0000\u0000\u0000<:\u0001\u0000\u0000\u0000<=\u0001\u0000"+
		"\u0000\u0000=\u0007\u0001\u0000\u0000\u0000>A\u0003\u0010\b\u0000?A\u0003"+
		"\n\u0005\u0000@>\u0001\u0000\u0000\u0000@?\u0001\u0000\u0000\u0000A\t"+
		"\u0001\u0000\u0000\u0000BC\u0003\f\u0006\u0000CH\u0003\u000e\u0007\u0000"+
		"DE\u0005\u0007\u0000\u0000EG\u0003\u000e\u0007\u0000FD\u0001\u0000\u0000"+
		"\u0000GJ\u0001\u0000\u0000\u0000HF\u0001\u0000\u0000\u0000HI\u0001\u0000"+
		"\u0000\u0000IK\u0001\u0000\u0000\u0000JH\u0001\u0000\u0000\u0000KL\u0005"+
		"\u0003\u0000\u0000L\u000b\u0001\u0000\u0000\u0000MN\u0005\u000e\u0000"+
		"\u0000N\r\u0001\u0000\u0000\u0000OP\u0005\u0010\u0000\u0000P\u000f\u0001"+
		"\u0000\u0000\u0000QR\u0005\r\u0000\u0000RS\u0003\u0012\t\u0000ST\u0005"+
		"\u0003\u0000\u0000T`\u0001\u0000\u0000\u0000UV\u0003\"\u0011\u0000VW\u0005"+
		"\u0006\u0000\u0000WX\u0003\u0012\t\u0000XY\u0005\u0003\u0000\u0000Y`\u0001"+
		"\u0000\u0000\u0000Z`\u0003\u0004\u0002\u0000[]\u0003\u0012\t\u0000\\["+
		"\u0001\u0000\u0000\u0000\\]\u0001\u0000\u0000\u0000]^\u0001\u0000\u0000"+
		"\u0000^`\u0005\u0003\u0000\u0000_Q\u0001\u0000\u0000\u0000_U\u0001\u0000"+
		"\u0000\u0000_Z\u0001\u0000\u0000\u0000_\\\u0001\u0000\u0000\u0000`\u0011"+
		"\u0001\u0000\u0000\u0000ab\u0003\u0016\u000b\u0000b\u0013\u0001\u0000"+
		"\u0000\u0000ci\u0003\u001c\u000e\u0000de\u0003\u0018\f\u0000ef\u0003\u001c"+
		"\u000e\u0000fh\u0001\u0000\u0000\u0000gd\u0001\u0000\u0000\u0000hk\u0001"+
		"\u0000\u0000\u0000ig\u0001\u0000\u0000\u0000ij\u0001\u0000\u0000\u0000"+
		"j\u0015\u0001\u0000\u0000\u0000ki\u0001\u0000\u0000\u0000lr\u0003\u0014"+
		"\n\u0000mn\u0003\u001a\r\u0000no\u0003\u0014\n\u0000oq\u0001\u0000\u0000"+
		"\u0000pm\u0001\u0000\u0000\u0000qt\u0001\u0000\u0000\u0000rp\u0001\u0000"+
		"\u0000\u0000rs\u0001\u0000\u0000\u0000s\u0017\u0001\u0000\u0000\u0000"+
		"tr\u0001\u0000\u0000\u0000uv\u0007\u0000\u0000\u0000v\u0019\u0001\u0000"+
		"\u0000\u0000wx\u0007\u0001\u0000\u0000x\u001b\u0001\u0000\u0000\u0000"+
		"y\u0083\u0003\u001e\u000f\u0000z{\u0005\t\u0000\u0000{\u0083\u0003\u001c"+
		"\u000e\u0000|}\u0005\u0010\u0000\u0000}\u007f\u0005\u0001\u0000\u0000"+
		"~\u0080\u0003 \u0010\u0000\u007f~\u0001\u0000\u0000\u0000\u007f\u0080"+
		"\u0001\u0000\u0000\u0000\u0080\u0081\u0001\u0000\u0000\u0000\u0081\u0083"+
		"\u0005\u0002\u0000\u0000\u0082y\u0001\u0000\u0000\u0000\u0082z\u0001\u0000"+
		"\u0000\u0000\u0082|\u0001\u0000\u0000\u0000\u0083\u001d\u0001\u0000\u0000"+
		"\u0000\u0084\u0085\u0005\u0001\u0000\u0000\u0085\u0086\u0003\u0012\t\u0000"+
		"\u0086\u0087\u0005\u0002\u0000\u0000\u0087\u008d\u0001\u0000\u0000\u0000"+
		"\u0088\u008d\u0005\u0011\u0000\u0000\u0089\u008d\u0005\u0012\u0000\u0000"+
		"\u008a\u008d\u0005\u0013\u0000\u0000\u008b\u008d\u0003\"\u0011\u0000\u008c"+
		"\u0084\u0001\u0000\u0000\u0000\u008c\u0088\u0001\u0000\u0000\u0000\u008c"+
		"\u0089\u0001\u0000\u0000\u0000\u008c\u008a\u0001\u0000\u0000\u0000\u008c"+
		"\u008b\u0001\u0000\u0000\u0000\u008d\u001f\u0001\u0000\u0000\u0000\u008e"+
		"\u0093\u0003\u0012\t\u0000\u008f\u0090\u0005\u0007\u0000\u0000\u0090\u0092"+
		"\u0003\u0012\t\u0000\u0091\u008f\u0001\u0000\u0000\u0000\u0092\u0095\u0001"+
		"\u0000\u0000\u0000\u0093\u0091\u0001\u0000\u0000\u0000\u0093\u0094\u0001"+
		"\u0000\u0000\u0000\u0094!\u0001\u0000\u0000\u0000\u0095\u0093\u0001\u0000"+
		"\u0000\u0000\u0096\u0097\u0005\u0010\u0000\u0000\u0097#\u0001\u0000\u0000"+
		"\u0000\u000e&(5<@H\\_ir\u007f\u0082\u008c\u0093";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}