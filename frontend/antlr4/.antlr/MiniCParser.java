// Generated from /home/code/byyl/byyl/frontend/antlr4/MiniC.g4 by ANTLR 4.13.1
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
		T_AND=1, T_OR=2, T_NOT=3, T_EQ=4, T_NE=5, T_GT=6, T_LT=7, T_GE=8, T_LE=9, 
		T_L_PAREN=10, T_R_PAREN=11, T_SEMICOLON=12, T_L_BRACE=13, T_R_BRACE=14, 
		T_ASSIGN=15, T_COMMA=16, T_ADD=17, T_SUB=18, T_MUL=19, T_DIV=20, T_MOD=21, 
		T_RETURN=22, T_INT=23, T_VOID=24, T_IF=25, T_ELSE=26, T_WHILE=27, T_BREAK=28, 
		T_ID=29, T_DIGIT=30, T_OCTAL=31, T_HEX=32, WS=33, LINE_COMMENT=34, BLOCK_COMMENT=35;
	public static final int
		RULE_compileUnit = 0, RULE_funcDef = 1, RULE_formalParamList = 2, RULE_formalParam = 3, 
		RULE_block = 4, RULE_blockItemList = 5, RULE_blockItem = 6, RULE_varDecl = 7, 
		RULE_basicType = 8, RULE_varDef = 9, RULE_statement = 10, RULE_expr = 11, 
		RULE_logicalOrExp = 12, RULE_logicalAndExp = 13, RULE_logicalNotExp = 14, 
		RULE_relationalExp = 15, RULE_relationalOp = 16, RULE_mulExp = 17, RULE_addExp = 18, 
		RULE_mulOp = 19, RULE_addOp = 20, RULE_unaryExp = 21, RULE_primaryExp = 22, 
		RULE_realParamList = 23, RULE_lVal = 24;
	private static String[] makeRuleNames() {
		return new String[] {
			"compileUnit", "funcDef", "formalParamList", "formalParam", "block", 
			"blockItemList", "blockItem", "varDecl", "basicType", "varDef", "statement", 
			"expr", "logicalOrExp", "logicalAndExp", "logicalNotExp", "relationalExp", 
			"relationalOp", "mulExp", "addExp", "mulOp", "addOp", "unaryExp", "primaryExp", 
			"realParamList", "lVal"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'&&'", "'||'", "'!'", "'=='", "'!='", "'>'", "'<'", "'>='", "'<='", 
			"'('", "')'", "';'", "'{'", "'}'", "'='", "','", "'+'", "'-'", "'*'", 
			"'/'", "'%'", "'return'", "'int'", "'void'", "'if'", "'else'", "'while'", 
			"'break'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "T_AND", "T_OR", "T_NOT", "T_EQ", "T_NE", "T_GT", "T_LT", "T_GE", 
			"T_LE", "T_L_PAREN", "T_R_PAREN", "T_SEMICOLON", "T_L_BRACE", "T_R_BRACE", 
			"T_ASSIGN", "T_COMMA", "T_ADD", "T_SUB", "T_MUL", "T_DIV", "T_MOD", "T_RETURN", 
			"T_INT", "T_VOID", "T_IF", "T_ELSE", "T_WHILE", "T_BREAK", "T_ID", "T_DIGIT", 
			"T_OCTAL", "T_HEX", "WS", "LINE_COMMENT", "BLOCK_COMMENT"
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
			setState(54);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T_INT || _la==T_VOID) {
				{
				setState(52);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
				case 1:
					{
					setState(50);
					funcDef();
					}
					break;
				case 2:
					{
					setState(51);
					varDecl();
					}
					break;
				}
				}
				setState(56);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(57);
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
		public TerminalNode T_ID() { return getToken(MiniCParser.T_ID, 0); }
		public TerminalNode T_L_PAREN() { return getToken(MiniCParser.T_L_PAREN, 0); }
		public TerminalNode T_R_PAREN() { return getToken(MiniCParser.T_R_PAREN, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public TerminalNode T_INT() { return getToken(MiniCParser.T_INT, 0); }
		public TerminalNode T_VOID() { return getToken(MiniCParser.T_VOID, 0); }
		public FormalParamListContext formalParamList() {
			return getRuleContext(FormalParamListContext.class,0);
		}
		public FuncDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcDef; }
	}

	public final FuncDefContext funcDef() throws RecognitionException {
		FuncDefContext _localctx = new FuncDefContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_funcDef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(59);
			_la = _input.LA(1);
			if ( !(_la==T_INT || _la==T_VOID) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(60);
			match(T_ID);
			setState(61);
			match(T_L_PAREN);
			setState(63);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T_INT) {
				{
				setState(62);
				formalParamList();
				}
			}

			setState(65);
			match(T_R_PAREN);
			setState(66);
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
	public static class FormalParamListContext extends ParserRuleContext {
		public List<FormalParamContext> formalParam() {
			return getRuleContexts(FormalParamContext.class);
		}
		public FormalParamContext formalParam(int i) {
			return getRuleContext(FormalParamContext.class,i);
		}
		public List<TerminalNode> T_COMMA() { return getTokens(MiniCParser.T_COMMA); }
		public TerminalNode T_COMMA(int i) {
			return getToken(MiniCParser.T_COMMA, i);
		}
		public FormalParamListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formalParamList; }
	}

	public final FormalParamListContext formalParamList() throws RecognitionException {
		FormalParamListContext _localctx = new FormalParamListContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_formalParamList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(68);
			formalParam();
			setState(73);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T_COMMA) {
				{
				{
				setState(69);
				match(T_COMMA);
				setState(70);
				formalParam();
				}
				}
				setState(75);
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
	public static class FormalParamContext extends ParserRuleContext {
		public BasicTypeContext basicType() {
			return getRuleContext(BasicTypeContext.class,0);
		}
		public TerminalNode T_ID() { return getToken(MiniCParser.T_ID, 0); }
		public FormalParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formalParam; }
	}

	public final FormalParamContext formalParam() throws RecognitionException {
		FormalParamContext _localctx = new FormalParamContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_formalParam);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(76);
			basicType();
			setState(77);
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
		enterRule(_localctx, 8, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(79);
			match(T_L_BRACE);
			setState(81);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 8502129672L) != 0)) {
				{
				setState(80);
				blockItemList();
				}
			}

			setState(83);
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
		enterRule(_localctx, 10, RULE_blockItemList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(86); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(85);
				blockItem();
				}
				}
				setState(88); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 8502129672L) != 0) );
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
		enterRule(_localctx, 12, RULE_blockItem);
		try {
			setState(92);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T_NOT:
			case T_L_PAREN:
			case T_SEMICOLON:
			case T_L_BRACE:
			case T_SUB:
			case T_RETURN:
			case T_IF:
			case T_WHILE:
			case T_BREAK:
			case T_ID:
			case T_DIGIT:
			case T_OCTAL:
			case T_HEX:
				enterOuterAlt(_localctx, 1);
				{
				setState(90);
				statement();
				}
				break;
			case T_INT:
				enterOuterAlt(_localctx, 2);
				{
				setState(91);
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
		enterRule(_localctx, 14, RULE_varDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(94);
			basicType();
			setState(95);
			varDef();
			setState(100);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T_COMMA) {
				{
				{
				setState(96);
				match(T_COMMA);
				setState(97);
				varDef();
				}
				}
				setState(102);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(103);
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
		enterRule(_localctx, 16, RULE_basicType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(105);
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
		public TerminalNode T_ASSIGN() { return getToken(MiniCParser.T_ASSIGN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public VarDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDef; }
	}

	public final VarDefContext varDef() throws RecognitionException {
		VarDefContext _localctx = new VarDefContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_varDef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(107);
			match(T_ID);
			setState(110);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T_ASSIGN) {
				{
				setState(108);
				match(T_ASSIGN);
				setState(109);
				expr();
				}
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
	public static class WhileStatementContext extends StatementContext {
		public TerminalNode T_WHILE() { return getToken(MiniCParser.T_WHILE, 0); }
		public TerminalNode T_L_PAREN() { return getToken(MiniCParser.T_L_PAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode T_R_PAREN() { return getToken(MiniCParser.T_R_PAREN, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public WhileStatementContext(StatementContext ctx) { copyFrom(ctx); }
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
	public static class BreakStatementContext extends StatementContext {
		public TerminalNode T_BREAK() { return getToken(MiniCParser.T_BREAK, 0); }
		public TerminalNode T_SEMICOLON() { return getToken(MiniCParser.T_SEMICOLON, 0); }
		public BreakStatementContext(StatementContext ctx) { copyFrom(ctx); }
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
	@SuppressWarnings("CheckReturnValue")
	public static class IfStatementContext extends StatementContext {
		public TerminalNode T_IF() { return getToken(MiniCParser.T_IF, 0); }
		public TerminalNode T_L_PAREN() { return getToken(MiniCParser.T_L_PAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode T_R_PAREN() { return getToken(MiniCParser.T_R_PAREN, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public TerminalNode T_ELSE() { return getToken(MiniCParser.T_ELSE, 0); }
		public IfStatementContext(StatementContext ctx) { copyFrom(ctx); }
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_statement);
		int _la;
		try {
			setState(143);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				_localctx = new ReturnStatementContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(112);
				match(T_RETURN);
				setState(113);
				expr();
				setState(114);
				match(T_SEMICOLON);
				}
				break;
			case 2:
				_localctx = new AssignStatementContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(116);
				lVal();
				setState(117);
				match(T_ASSIGN);
				setState(118);
				expr();
				setState(119);
				match(T_SEMICOLON);
				}
				break;
			case 3:
				_localctx = new BlockStatementContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(121);
				block();
				}
				break;
			case 4:
				_localctx = new ExpressionStatementContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(123);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 8053326856L) != 0)) {
					{
					setState(122);
					expr();
					}
				}

				setState(125);
				match(T_SEMICOLON);
				}
				break;
			case 5:
				_localctx = new IfStatementContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(126);
				match(T_IF);
				setState(127);
				match(T_L_PAREN);
				setState(128);
				expr();
				setState(129);
				match(T_R_PAREN);
				setState(130);
				statement();
				setState(133);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
				case 1:
					{
					setState(131);
					match(T_ELSE);
					setState(132);
					statement();
					}
					break;
				}
				}
				break;
			case 6:
				_localctx = new WhileStatementContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(135);
				match(T_WHILE);
				setState(136);
				match(T_L_PAREN);
				setState(137);
				expr();
				setState(138);
				match(T_R_PAREN);
				setState(139);
				statement();
				}
				break;
			case 7:
				_localctx = new BreakStatementContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(141);
				match(T_BREAK);
				setState(142);
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
		public LogicalOrExpContext logicalOrExp() {
			return getRuleContext(LogicalOrExpContext.class,0);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(145);
			logicalOrExp();
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
	public static class LogicalOrExpContext extends ParserRuleContext {
		public List<LogicalAndExpContext> logicalAndExp() {
			return getRuleContexts(LogicalAndExpContext.class);
		}
		public LogicalAndExpContext logicalAndExp(int i) {
			return getRuleContext(LogicalAndExpContext.class,i);
		}
		public List<TerminalNode> T_OR() { return getTokens(MiniCParser.T_OR); }
		public TerminalNode T_OR(int i) {
			return getToken(MiniCParser.T_OR, i);
		}
		public LogicalOrExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logicalOrExp; }
	}

	public final LogicalOrExpContext logicalOrExp() throws RecognitionException {
		LogicalOrExpContext _localctx = new LogicalOrExpContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_logicalOrExp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(147);
			logicalAndExp();
			setState(152);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T_OR) {
				{
				{
				setState(148);
				match(T_OR);
				setState(149);
				logicalAndExp();
				}
				}
				setState(154);
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
	public static class LogicalAndExpContext extends ParserRuleContext {
		public List<LogicalNotExpContext> logicalNotExp() {
			return getRuleContexts(LogicalNotExpContext.class);
		}
		public LogicalNotExpContext logicalNotExp(int i) {
			return getRuleContext(LogicalNotExpContext.class,i);
		}
		public List<TerminalNode> T_AND() { return getTokens(MiniCParser.T_AND); }
		public TerminalNode T_AND(int i) {
			return getToken(MiniCParser.T_AND, i);
		}
		public LogicalAndExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logicalAndExp; }
	}

	public final LogicalAndExpContext logicalAndExp() throws RecognitionException {
		LogicalAndExpContext _localctx = new LogicalAndExpContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_logicalAndExp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(155);
			logicalNotExp();
			setState(160);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T_AND) {
				{
				{
				setState(156);
				match(T_AND);
				setState(157);
				logicalNotExp();
				}
				}
				setState(162);
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
	public static class LogicalNotExpContext extends ParserRuleContext {
		public TerminalNode T_NOT() { return getToken(MiniCParser.T_NOT, 0); }
		public RelationalExpContext relationalExp() {
			return getRuleContext(RelationalExpContext.class,0);
		}
		public LogicalNotExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logicalNotExp; }
	}

	public final LogicalNotExpContext logicalNotExp() throws RecognitionException {
		LogicalNotExpContext _localctx = new LogicalNotExpContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_logicalNotExp);
		try {
			setState(166);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(163);
				match(T_NOT);
				setState(164);
				relationalExp();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(165);
				relationalExp();
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
	public static class RelationalExpContext extends ParserRuleContext {
		public List<AddExpContext> addExp() {
			return getRuleContexts(AddExpContext.class);
		}
		public AddExpContext addExp(int i) {
			return getRuleContext(AddExpContext.class,i);
		}
		public List<RelationalOpContext> relationalOp() {
			return getRuleContexts(RelationalOpContext.class);
		}
		public RelationalOpContext relationalOp(int i) {
			return getRuleContext(RelationalOpContext.class,i);
		}
		public RelationalExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relationalExp; }
	}

	public final RelationalExpContext relationalExp() throws RecognitionException {
		RelationalExpContext _localctx = new RelationalExpContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_relationalExp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(168);
			addExp();
			setState(174);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1008L) != 0)) {
				{
				{
				setState(169);
				relationalOp();
				setState(170);
				addExp();
				}
				}
				setState(176);
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
	public static class RelationalOpContext extends ParserRuleContext {
		public TerminalNode T_EQ() { return getToken(MiniCParser.T_EQ, 0); }
		public TerminalNode T_NE() { return getToken(MiniCParser.T_NE, 0); }
		public TerminalNode T_GT() { return getToken(MiniCParser.T_GT, 0); }
		public TerminalNode T_LT() { return getToken(MiniCParser.T_LT, 0); }
		public TerminalNode T_GE() { return getToken(MiniCParser.T_GE, 0); }
		public TerminalNode T_LE() { return getToken(MiniCParser.T_LE, 0); }
		public RelationalOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relationalOp; }
	}

	public final RelationalOpContext relationalOp() throws RecognitionException {
		RelationalOpContext _localctx = new RelationalOpContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_relationalOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(177);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 1008L) != 0)) ) {
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
		enterRule(_localctx, 34, RULE_mulExp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(179);
			unaryExp();
			setState(185);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 3670016L) != 0)) {
				{
				{
				setState(180);
				mulOp();
				setState(181);
				unaryExp();
				}
				}
				setState(187);
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
		enterRule(_localctx, 36, RULE_addExp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(188);
			mulExp();
			setState(194);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T_ADD || _la==T_SUB) {
				{
				{
				setState(189);
				addOp();
				setState(190);
				mulExp();
				}
				}
				setState(196);
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
		enterRule(_localctx, 38, RULE_mulOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(197);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 3670016L) != 0)) ) {
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
		enterRule(_localctx, 40, RULE_addOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(199);
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
	@SuppressWarnings("CheckReturnValue")
	public static class NotExpContext extends UnaryExpContext {
		public TerminalNode T_NOT() { return getToken(MiniCParser.T_NOT, 0); }
		public UnaryExpContext unaryExp() {
			return getRuleContext(UnaryExpContext.class,0);
		}
		public NotExpContext(UnaryExpContext ctx) { copyFrom(ctx); }
	}

	public final UnaryExpContext unaryExp() throws RecognitionException {
		UnaryExpContext _localctx = new UnaryExpContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_unaryExp);
		int _la;
		try {
			setState(212);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				_localctx = new PrimaryExpRuleContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(201);
				primaryExp();
				}
				break;
			case 2:
				_localctx = new NegExpContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(202);
				match(T_SUB);
				setState(203);
				unaryExp();
				}
				break;
			case 3:
				_localctx = new NotExpContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(204);
				match(T_NOT);
				setState(205);
				unaryExp();
				}
				break;
			case 4:
				_localctx = new FuncCallRuleContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(206);
				match(T_ID);
				setState(207);
				match(T_L_PAREN);
				setState(209);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 8053326856L) != 0)) {
					{
					setState(208);
					realParamList();
					}
				}

				setState(211);
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
		enterRule(_localctx, 44, RULE_primaryExp);
		try {
			setState(222);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T_L_PAREN:
				enterOuterAlt(_localctx, 1);
				{
				setState(214);
				match(T_L_PAREN);
				setState(215);
				expr();
				setState(216);
				match(T_R_PAREN);
				}
				break;
			case T_DIGIT:
				enterOuterAlt(_localctx, 2);
				{
				setState(218);
				match(T_DIGIT);
				}
				break;
			case T_OCTAL:
				enterOuterAlt(_localctx, 3);
				{
				setState(219);
				match(T_OCTAL);
				}
				break;
			case T_HEX:
				enterOuterAlt(_localctx, 4);
				{
				setState(220);
				match(T_HEX);
				}
				break;
			case T_ID:
				enterOuterAlt(_localctx, 5);
				{
				setState(221);
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
		enterRule(_localctx, 46, RULE_realParamList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(224);
			expr();
			setState(229);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T_COMMA) {
				{
				{
				setState(225);
				match(T_COMMA);
				setState(226);
				expr();
				}
				}
				setState(231);
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
		enterRule(_localctx, 48, RULE_lVal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(232);
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
		"\u0004\u0001#\u00eb\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0001\u0000\u0001\u0000\u0005\u00005\b\u0000\n\u0000\f\u00008\t\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0003\u0001@\b\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0005\u0002H\b\u0002\n\u0002\f\u0002K\t\u0002"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0003\u0004"+
		"R\b\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0004\u0005W\b\u0005\u000b"+
		"\u0005\f\u0005X\u0001\u0006\u0001\u0006\u0003\u0006]\b\u0006\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0005\u0007c\b\u0007\n\u0007\f\u0007"+
		"f\t\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\t\u0001\t\u0001"+
		"\t\u0003\to\b\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0003\n|\b\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0003\n\u0086\b\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0003\n\u0090\b\n\u0001"+
		"\u000b\u0001\u000b\u0001\f\u0001\f\u0001\f\u0005\f\u0097\b\f\n\f\f\f\u009a"+
		"\t\f\u0001\r\u0001\r\u0001\r\u0005\r\u009f\b\r\n\r\f\r\u00a2\t\r\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0003\u000e\u00a7\b\u000e\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0005\u000f\u00ad\b\u000f\n\u000f\f\u000f"+
		"\u00b0\t\u000f\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011\u0001\u0011"+
		"\u0001\u0011\u0005\u0011\u00b8\b\u0011\n\u0011\f\u0011\u00bb\t\u0011\u0001"+
		"\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0005\u0012\u00c1\b\u0012\n"+
		"\u0012\f\u0012\u00c4\t\u0012\u0001\u0013\u0001\u0013\u0001\u0014\u0001"+
		"\u0014\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001"+
		"\u0015\u0001\u0015\u0001\u0015\u0003\u0015\u00d2\b\u0015\u0001\u0015\u0003"+
		"\u0015\u00d5\b\u0015\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001"+
		"\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0003\u0016\u00df\b\u0016\u0001"+
		"\u0017\u0001\u0017\u0001\u0017\u0005\u0017\u00e4\b\u0017\n\u0017\f\u0017"+
		"\u00e7\t\u0017\u0001\u0018\u0001\u0018\u0001\u0018\u0000\u0000\u0019\u0000"+
		"\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c"+
		"\u001e \"$&(*,.0\u0000\u0004\u0001\u0000\u0017\u0018\u0001\u0000\u0004"+
		"\t\u0001\u0000\u0013\u0015\u0001\u0000\u0011\u0012\u00f1\u00006\u0001"+
		"\u0000\u0000\u0000\u0002;\u0001\u0000\u0000\u0000\u0004D\u0001\u0000\u0000"+
		"\u0000\u0006L\u0001\u0000\u0000\u0000\bO\u0001\u0000\u0000\u0000\nV\u0001"+
		"\u0000\u0000\u0000\f\\\u0001\u0000\u0000\u0000\u000e^\u0001\u0000\u0000"+
		"\u0000\u0010i\u0001\u0000\u0000\u0000\u0012k\u0001\u0000\u0000\u0000\u0014"+
		"\u008f\u0001\u0000\u0000\u0000\u0016\u0091\u0001\u0000\u0000\u0000\u0018"+
		"\u0093\u0001\u0000\u0000\u0000\u001a\u009b\u0001\u0000\u0000\u0000\u001c"+
		"\u00a6\u0001\u0000\u0000\u0000\u001e\u00a8\u0001\u0000\u0000\u0000 \u00b1"+
		"\u0001\u0000\u0000\u0000\"\u00b3\u0001\u0000\u0000\u0000$\u00bc\u0001"+
		"\u0000\u0000\u0000&\u00c5\u0001\u0000\u0000\u0000(\u00c7\u0001\u0000\u0000"+
		"\u0000*\u00d4\u0001\u0000\u0000\u0000,\u00de\u0001\u0000\u0000\u0000."+
		"\u00e0\u0001\u0000\u0000\u00000\u00e8\u0001\u0000\u0000\u000025\u0003"+
		"\u0002\u0001\u000035\u0003\u000e\u0007\u000042\u0001\u0000\u0000\u0000"+
		"43\u0001\u0000\u0000\u000058\u0001\u0000\u0000\u000064\u0001\u0000\u0000"+
		"\u000067\u0001\u0000\u0000\u000079\u0001\u0000\u0000\u000086\u0001\u0000"+
		"\u0000\u00009:\u0005\u0000\u0000\u0001:\u0001\u0001\u0000\u0000\u0000"+
		";<\u0007\u0000\u0000\u0000<=\u0005\u001d\u0000\u0000=?\u0005\n\u0000\u0000"+
		">@\u0003\u0004\u0002\u0000?>\u0001\u0000\u0000\u0000?@\u0001\u0000\u0000"+
		"\u0000@A\u0001\u0000\u0000\u0000AB\u0005\u000b\u0000\u0000BC\u0003\b\u0004"+
		"\u0000C\u0003\u0001\u0000\u0000\u0000DI\u0003\u0006\u0003\u0000EF\u0005"+
		"\u0010\u0000\u0000FH\u0003\u0006\u0003\u0000GE\u0001\u0000\u0000\u0000"+
		"HK\u0001\u0000\u0000\u0000IG\u0001\u0000\u0000\u0000IJ\u0001\u0000\u0000"+
		"\u0000J\u0005\u0001\u0000\u0000\u0000KI\u0001\u0000\u0000\u0000LM\u0003"+
		"\u0010\b\u0000MN\u0005\u001d\u0000\u0000N\u0007\u0001\u0000\u0000\u0000"+
		"OQ\u0005\r\u0000\u0000PR\u0003\n\u0005\u0000QP\u0001\u0000\u0000\u0000"+
		"QR\u0001\u0000\u0000\u0000RS\u0001\u0000\u0000\u0000ST\u0005\u000e\u0000"+
		"\u0000T\t\u0001\u0000\u0000\u0000UW\u0003\f\u0006\u0000VU\u0001\u0000"+
		"\u0000\u0000WX\u0001\u0000\u0000\u0000XV\u0001\u0000\u0000\u0000XY\u0001"+
		"\u0000\u0000\u0000Y\u000b\u0001\u0000\u0000\u0000Z]\u0003\u0014\n\u0000"+
		"[]\u0003\u000e\u0007\u0000\\Z\u0001\u0000\u0000\u0000\\[\u0001\u0000\u0000"+
		"\u0000]\r\u0001\u0000\u0000\u0000^_\u0003\u0010\b\u0000_d\u0003\u0012"+
		"\t\u0000`a\u0005\u0010\u0000\u0000ac\u0003\u0012\t\u0000b`\u0001\u0000"+
		"\u0000\u0000cf\u0001\u0000\u0000\u0000db\u0001\u0000\u0000\u0000de\u0001"+
		"\u0000\u0000\u0000eg\u0001\u0000\u0000\u0000fd\u0001\u0000\u0000\u0000"+
		"gh\u0005\f\u0000\u0000h\u000f\u0001\u0000\u0000\u0000ij\u0005\u0017\u0000"+
		"\u0000j\u0011\u0001\u0000\u0000\u0000kn\u0005\u001d\u0000\u0000lm\u0005"+
		"\u000f\u0000\u0000mo\u0003\u0016\u000b\u0000nl\u0001\u0000\u0000\u0000"+
		"no\u0001\u0000\u0000\u0000o\u0013\u0001\u0000\u0000\u0000pq\u0005\u0016"+
		"\u0000\u0000qr\u0003\u0016\u000b\u0000rs\u0005\f\u0000\u0000s\u0090\u0001"+
		"\u0000\u0000\u0000tu\u00030\u0018\u0000uv\u0005\u000f\u0000\u0000vw\u0003"+
		"\u0016\u000b\u0000wx\u0005\f\u0000\u0000x\u0090\u0001\u0000\u0000\u0000"+
		"y\u0090\u0003\b\u0004\u0000z|\u0003\u0016\u000b\u0000{z\u0001\u0000\u0000"+
		"\u0000{|\u0001\u0000\u0000\u0000|}\u0001\u0000\u0000\u0000}\u0090\u0005"+
		"\f\u0000\u0000~\u007f\u0005\u0019\u0000\u0000\u007f\u0080\u0005\n\u0000"+
		"\u0000\u0080\u0081\u0003\u0016\u000b\u0000\u0081\u0082\u0005\u000b\u0000"+
		"\u0000\u0082\u0085\u0003\u0014\n\u0000\u0083\u0084\u0005\u001a\u0000\u0000"+
		"\u0084\u0086\u0003\u0014\n\u0000\u0085\u0083\u0001\u0000\u0000\u0000\u0085"+
		"\u0086\u0001\u0000\u0000\u0000\u0086\u0090\u0001\u0000\u0000\u0000\u0087"+
		"\u0088\u0005\u001b\u0000\u0000\u0088\u0089\u0005\n\u0000\u0000\u0089\u008a"+
		"\u0003\u0016\u000b\u0000\u008a\u008b\u0005\u000b\u0000\u0000\u008b\u008c"+
		"\u0003\u0014\n\u0000\u008c\u0090\u0001\u0000\u0000\u0000\u008d\u008e\u0005"+
		"\u001c\u0000\u0000\u008e\u0090\u0005\f\u0000\u0000\u008fp\u0001\u0000"+
		"\u0000\u0000\u008ft\u0001\u0000\u0000\u0000\u008fy\u0001\u0000\u0000\u0000"+
		"\u008f{\u0001\u0000\u0000\u0000\u008f~\u0001\u0000\u0000\u0000\u008f\u0087"+
		"\u0001\u0000\u0000\u0000\u008f\u008d\u0001\u0000\u0000\u0000\u0090\u0015"+
		"\u0001\u0000\u0000\u0000\u0091\u0092\u0003\u0018\f\u0000\u0092\u0017\u0001"+
		"\u0000\u0000\u0000\u0093\u0098\u0003\u001a\r\u0000\u0094\u0095\u0005\u0002"+
		"\u0000\u0000\u0095\u0097\u0003\u001a\r\u0000\u0096\u0094\u0001\u0000\u0000"+
		"\u0000\u0097\u009a\u0001\u0000\u0000\u0000\u0098\u0096\u0001\u0000\u0000"+
		"\u0000\u0098\u0099\u0001\u0000\u0000\u0000\u0099\u0019\u0001\u0000\u0000"+
		"\u0000\u009a\u0098\u0001\u0000\u0000\u0000\u009b\u00a0\u0003\u001c\u000e"+
		"\u0000\u009c\u009d\u0005\u0001\u0000\u0000\u009d\u009f\u0003\u001c\u000e"+
		"\u0000\u009e\u009c\u0001\u0000\u0000\u0000\u009f\u00a2\u0001\u0000\u0000"+
		"\u0000\u00a0\u009e\u0001\u0000\u0000\u0000\u00a0\u00a1\u0001\u0000\u0000"+
		"\u0000\u00a1\u001b\u0001\u0000\u0000\u0000\u00a2\u00a0\u0001\u0000\u0000"+
		"\u0000\u00a3\u00a4\u0005\u0003\u0000\u0000\u00a4\u00a7\u0003\u001e\u000f"+
		"\u0000\u00a5\u00a7\u0003\u001e\u000f\u0000\u00a6\u00a3\u0001\u0000\u0000"+
		"\u0000\u00a6\u00a5\u0001\u0000\u0000\u0000\u00a7\u001d\u0001\u0000\u0000"+
		"\u0000\u00a8\u00ae\u0003$\u0012\u0000\u00a9\u00aa\u0003 \u0010\u0000\u00aa"+
		"\u00ab\u0003$\u0012\u0000\u00ab\u00ad\u0001\u0000\u0000\u0000\u00ac\u00a9"+
		"\u0001\u0000\u0000\u0000\u00ad\u00b0\u0001\u0000\u0000\u0000\u00ae\u00ac"+
		"\u0001\u0000\u0000\u0000\u00ae\u00af\u0001\u0000\u0000\u0000\u00af\u001f"+
		"\u0001\u0000\u0000\u0000\u00b0\u00ae\u0001\u0000\u0000\u0000\u00b1\u00b2"+
		"\u0007\u0001\u0000\u0000\u00b2!\u0001\u0000\u0000\u0000\u00b3\u00b9\u0003"+
		"*\u0015\u0000\u00b4\u00b5\u0003&\u0013\u0000\u00b5\u00b6\u0003*\u0015"+
		"\u0000\u00b6\u00b8\u0001\u0000\u0000\u0000\u00b7\u00b4\u0001\u0000\u0000"+
		"\u0000\u00b8\u00bb\u0001\u0000\u0000\u0000\u00b9\u00b7\u0001\u0000\u0000"+
		"\u0000\u00b9\u00ba\u0001\u0000\u0000\u0000\u00ba#\u0001\u0000\u0000\u0000"+
		"\u00bb\u00b9\u0001\u0000\u0000\u0000\u00bc\u00c2\u0003\"\u0011\u0000\u00bd"+
		"\u00be\u0003(\u0014\u0000\u00be\u00bf\u0003\"\u0011\u0000\u00bf\u00c1"+
		"\u0001\u0000\u0000\u0000\u00c0\u00bd\u0001\u0000\u0000\u0000\u00c1\u00c4"+
		"\u0001\u0000\u0000\u0000\u00c2\u00c0\u0001\u0000\u0000\u0000\u00c2\u00c3"+
		"\u0001\u0000\u0000\u0000\u00c3%\u0001\u0000\u0000\u0000\u00c4\u00c2\u0001"+
		"\u0000\u0000\u0000\u00c5\u00c6\u0007\u0002\u0000\u0000\u00c6\'\u0001\u0000"+
		"\u0000\u0000\u00c7\u00c8\u0007\u0003\u0000\u0000\u00c8)\u0001\u0000\u0000"+
		"\u0000\u00c9\u00d5\u0003,\u0016\u0000\u00ca\u00cb\u0005\u0012\u0000\u0000"+
		"\u00cb\u00d5\u0003*\u0015\u0000\u00cc\u00cd\u0005\u0003\u0000\u0000\u00cd"+
		"\u00d5\u0003*\u0015\u0000\u00ce\u00cf\u0005\u001d\u0000\u0000\u00cf\u00d1"+
		"\u0005\n\u0000\u0000\u00d0\u00d2\u0003.\u0017\u0000\u00d1\u00d0\u0001"+
		"\u0000\u0000\u0000\u00d1\u00d2\u0001\u0000\u0000\u0000\u00d2\u00d3\u0001"+
		"\u0000\u0000\u0000\u00d3\u00d5\u0005\u000b\u0000\u0000\u00d4\u00c9\u0001"+
		"\u0000\u0000\u0000\u00d4\u00ca\u0001\u0000\u0000\u0000\u00d4\u00cc\u0001"+
		"\u0000\u0000\u0000\u00d4\u00ce\u0001\u0000\u0000\u0000\u00d5+\u0001\u0000"+
		"\u0000\u0000\u00d6\u00d7\u0005\n\u0000\u0000\u00d7\u00d8\u0003\u0016\u000b"+
		"\u0000\u00d8\u00d9\u0005\u000b\u0000\u0000\u00d9\u00df\u0001\u0000\u0000"+
		"\u0000\u00da\u00df\u0005\u001e\u0000\u0000\u00db\u00df\u0005\u001f\u0000"+
		"\u0000\u00dc\u00df\u0005 \u0000\u0000\u00dd\u00df\u00030\u0018\u0000\u00de"+
		"\u00d6\u0001\u0000\u0000\u0000\u00de\u00da\u0001\u0000\u0000\u0000\u00de"+
		"\u00db\u0001\u0000\u0000\u0000\u00de\u00dc\u0001\u0000\u0000\u0000\u00de"+
		"\u00dd\u0001\u0000\u0000\u0000\u00df-\u0001\u0000\u0000\u0000\u00e0\u00e5"+
		"\u0003\u0016\u000b\u0000\u00e1\u00e2\u0005\u0010\u0000\u0000\u00e2\u00e4"+
		"\u0003\u0016\u000b\u0000\u00e3\u00e1\u0001\u0000\u0000\u0000\u00e4\u00e7"+
		"\u0001\u0000\u0000\u0000\u00e5\u00e3\u0001\u0000\u0000\u0000\u00e5\u00e6"+
		"\u0001\u0000\u0000\u0000\u00e6/\u0001\u0000\u0000\u0000\u00e7\u00e5\u0001"+
		"\u0000\u0000\u0000\u00e8\u00e9\u0005\u001d\u0000\u0000\u00e91\u0001\u0000"+
		"\u0000\u0000\u001646?IQX\\dn{\u0085\u008f\u0098\u00a0\u00a6\u00ae\u00b9"+
		"\u00c2\u00d1\u00d4\u00de\u00e5";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}