/* The following code was generated by JFlex 1.4.3 on 22/11/18 02:50 PM */


package analizador_lexico;

import java_cup.runtime.*;

/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.4.3
 * on 22/11/18 02:50 PM from the specification file
 * <tt>D:/GitHub/Analizador-lexico/Analizador_lexico/src/analizador_lexico/Lexer.flex</tt>
 */
class Lexer implements java_cup.runtime.Scanner {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int YYINITIAL = 0;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0, 0
  };

  /** 
   * Translates characters to character classes
   */
  private static final String ZZ_CMAP_PACKED = 
    "\11\0\1\52\1\42\1\0\1\52\1\105\22\0\1\51\1\4\1\43"+
    "\1\54\1\0\1\104\1\6\1\41\1\34\1\33\1\47\1\26\1\32"+
    "\1\103\1\27\1\46\1\20\1\25\6\23\2\17\1\0\1\31\1\1"+
    "\1\3\1\2\2\0\1\73\1\24\2\22\1\30\1\22\1\101\1\45"+
    "\1\76\2\45\1\77\1\100\1\72\1\45\1\71\1\45\1\75\1\102"+
    "\4\45\1\21\2\45\1\36\1\0\1\35\1\0\1\44\1\0\1\14"+
    "\1\62\1\57\1\60\1\12\1\13\1\63\1\67\1\55\1\45\1\70"+
    "\1\15\1\65\1\56\1\61\1\50\1\45\1\10\1\16\1\7\1\11"+
    "\1\53\1\66\1\64\1\74\1\45\1\40\1\5\1\37\uff82\0";

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = zzUnpackCMap(ZZ_CMAP_PACKED);

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\1\0\1\1\1\2\1\3\1\4\1\5\2\1\6\6"+
    "\2\7\1\10\1\11\1\12\1\13\1\14\1\15\1\16"+
    "\1\17\1\20\1\21\1\1\1\22\2\1\1\23\1\24"+
    "\1\22\1\6\1\1\14\6\1\25\1\26\1\22\1\27"+
    "\1\30\1\31\1\32\10\6\1\33\2\0\1\7\4\0"+
    "\1\34\1\0\1\34\1\0\2\22\1\6\1\0\1\35"+
    "\24\6\1\36\1\6\1\0\3\7\4\22\1\6\1\0"+
    "\1\37\10\6\1\40\4\6\1\41\1\42\1\6\1\43"+
    "\2\6\1\33\5\0\1\22\1\44\1\0\2\6\1\45"+
    "\3\6\1\46\12\6\3\0\2\6\1\47\1\6\1\50"+
    "\1\51\1\52\6\6\1\53\1\6\1\54\1\0\2\6"+
    "\1\55\3\6\1\56\2\6\1\57\1\0\5\6\1\60"+
    "\1\61\1\62\2\6\1\63\1\6\1\64\1\65\2\6"+
    "\1\66\1\6\1\67";

  private static int [] zzUnpackAction() {
    int [] result = new int[207];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** 
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\106\0\214\0\322\0\u0118\0\u0118\0\u015e\0\u01a4"+
    "\0\u01ea\0\u0230\0\u0276\0\u02bc\0\u0302\0\u0348\0\u038e\0\u03d4"+
    "\0\u041a\0\106\0\106\0\106\0\106\0\106\0\106\0\u0460"+
    "\0\106\0\u04a6\0\u04ec\0\u0532\0\u0578\0\u05be\0\u0604\0\106"+
    "\0\106\0\u064a\0\u0690\0\u06d6\0\u071c\0\u0762\0\u07a8\0\u07ee"+
    "\0\u0834\0\u087a\0\u08c0\0\u0906\0\u094c\0\u0992\0\u09d8\0\u041a"+
    "\0\106\0\u0a1e\0\106\0\106\0\106\0\106\0\u0a64\0\u0aaa"+
    "\0\u0af0\0\u0b36\0\u0b7c\0\u0bc2\0\u0c08\0\u0c4e\0\u0c94\0\u0cda"+
    "\0\u0d20\0\u0d66\0\u0dac\0\u0df2\0\u0e38\0\u04ec\0\u04ec\0\u0578"+
    "\0\u0578\0\u05be\0\u0e7e\0\u0ec4\0\u0f0a\0\u0f50\0\u0276\0\u0f96"+
    "\0\u0fdc\0\u1022\0\u1068\0\u10ae\0\u10f4\0\u113a\0\u1180\0\u11c6"+
    "\0\u120c\0\u1252\0\u1298\0\u12de\0\u1324\0\u136a\0\u13b0\0\u13f6"+
    "\0\u143c\0\u1482\0\u14c8\0\u0276\0\u150e\0\u1554\0\u0dac\0\u0df2"+
    "\0\u159a\0\u15e0\0\u1626\0\u166c\0\u16b2\0\u16f8\0\u173e\0\u1784"+
    "\0\u17ca\0\u1810\0\u1856\0\u189c\0\u18e2\0\u1928\0\u196e\0\u19b4"+
    "\0\u19fa\0\u1a40\0\u1a86\0\u1acc\0\u1b12\0\u0276\0\u0276\0\u1b58"+
    "\0\u0276\0\u1b9e\0\u1be4\0\u1c2a\0\u1c2a\0\u15e0\0\u1c70\0\u16b2"+
    "\0\u1cb6\0\u1cfc\0\u0276\0\u1d42\0\u1d88\0\u1dce\0\u0276\0\u1e14"+
    "\0\u1e5a\0\u1ea0\0\u0276\0\u1ee6\0\u1f2c\0\u1f72\0\u1fb8\0\u1ffe"+
    "\0\u2044\0\u208a\0\u20d0\0\u2116\0\u215c\0\u1cfc\0\u21a2\0\u21e8"+
    "\0\u222e\0\u2274\0\u0276\0\u22ba\0\u0276\0\u0276\0\u0276\0\u2300"+
    "\0\u2346\0\u238c\0\u23d2\0\u2418\0\u245e\0\u0276\0\u24a4\0\u0276"+
    "\0\u24ea\0\u2530\0\u2576\0\u0276\0\u25bc\0\u2602\0\u2648\0\u0276"+
    "\0\u268e\0\u26d4\0\u0276\0\u271a\0\u2760\0\u27a6\0\u27ec\0\u2832"+
    "\0\u2878\0\u0276\0\u0276\0\106\0\u28be\0\u2904\0\u0276\0\u294a"+
    "\0\u0276\0\u0276\0\u2990\0\u29d6\0\u0276\0\u2a1c\0\u0276";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[207];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11"+
    "\1\12\1\13\1\14\1\15\2\13\1\16\1\17\1\20"+
    "\2\13\1\17\1\13\1\17\1\21\1\22\1\13\1\23"+
    "\1\24\1\25\1\26\1\27\1\30\1\31\1\32\1\33"+
    "\1\34\1\35\1\36\1\13\1\37\1\40\1\13\2\41"+
    "\1\42\1\43\1\44\1\45\1\46\1\47\1\13\1\50"+
    "\3\13\1\51\2\13\1\52\1\53\2\13\1\54\2\13"+
    "\1\55\1\56\1\57\1\60\1\61\1\62\111\0\1\63"+
    "\105\0\1\64\105\0\1\65\107\0\1\66\106\0\1\66"+
    "\106\0\1\13\1\67\15\13\2\0\1\13\13\0\2\13"+
    "\2\0\1\13\2\0\1\13\1\0\12\13\1\70\13\13"+
    "\12\0\3\13\1\71\13\13\2\0\1\13\13\0\2\13"+
    "\2\0\1\13\2\0\1\13\1\0\26\13\12\0\17\13"+
    "\2\0\1\13\13\0\2\13\2\0\1\13\2\0\1\13"+
    "\1\0\26\13\12\0\6\13\1\72\10\13\2\0\1\13"+
    "\13\0\2\13\2\0\1\13\2\0\1\13\1\0\7\13"+
    "\1\73\16\13\12\0\5\13\1\74\11\13\2\0\1\13"+
    "\13\0\2\13\2\0\1\13\2\0\1\13\1\0\4\13"+
    "\1\75\21\13\12\0\1\76\16\13\2\0\1\13\13\0"+
    "\2\13\2\0\1\13\2\0\1\13\1\0\26\13\22\0"+
    "\2\17\2\0\1\17\1\0\1\17\1\0\1\77\20\0"+
    "\1\100\54\0\1\101\1\102\1\103\1\0\1\102\1\104"+
    "\1\102\1\0\1\77\20\0\1\100\11\0\1\104\1\0"+
    "\1\103\41\0\1\105\122\0\1\41\107\0\1\41\46\0"+
    "\41\106\1\107\1\0\43\106\16\0\1\34\23\0\1\34"+
    "\6\0\3\34\31\0\1\34\42\110\1\0\1\111\42\110"+
    "\7\0\10\13\2\0\2\13\1\0\1\13\3\0\1\13"+
    "\13\0\1\112\1\13\2\0\1\13\2\0\1\13\1\0"+
    "\26\13\51\0\1\113\1\114\45\0\17\13\2\0\1\13"+
    "\13\0\2\13\2\0\1\13\2\0\1\13\1\0\4\13"+
    "\1\115\21\13\60\0\1\116\37\0\4\13\1\117\12\13"+
    "\2\0\1\13\13\0\2\13\2\0\1\13\2\0\1\13"+
    "\1\0\1\13\1\120\6\13\1\121\15\13\12\0\2\13"+
    "\1\122\14\13\2\0\1\13\13\0\2\13\2\0\1\13"+
    "\2\0\1\13\1\0\26\13\12\0\6\13\1\123\10\13"+
    "\2\0\1\13\13\0\2\13\2\0\1\13\2\0\1\13"+
    "\1\0\26\13\12\0\17\13\2\0\1\13\13\0\2\13"+
    "\2\0\1\13\2\0\1\13\1\0\4\13\1\124\21\13"+
    "\12\0\1\13\1\125\15\13\2\0\1\13\13\0\2\13"+
    "\2\0\1\13\2\0\1\13\1\0\4\13\1\126\21\13"+
    "\12\0\17\13\2\0\1\13\13\0\2\13\2\0\1\13"+
    "\2\0\1\13\1\0\12\13\1\127\13\13\12\0\1\13"+
    "\1\130\15\13\2\0\1\13\13\0\2\13\2\0\1\13"+
    "\2\0\1\13\1\0\26\13\12\0\3\13\1\131\13\13"+
    "\2\0\1\13\13\0\2\13\2\0\1\13\2\0\1\13"+
    "\1\0\26\13\12\0\3\13\1\132\13\13\2\0\1\13"+
    "\13\0\2\13\2\0\1\13\2\0\1\13\1\0\26\13"+
    "\12\0\5\13\1\133\11\13\2\0\1\13\13\0\2\13"+
    "\2\0\1\13\2\0\1\13\1\0\26\13\12\0\3\13"+
    "\1\134\13\13\2\0\1\13\13\0\2\13\2\0\1\13"+
    "\2\0\1\13\1\0\26\13\12\0\3\13\1\135\13\13"+
    "\2\0\1\13\13\0\2\13\2\0\1\13\2\0\1\13"+
    "\1\0\26\13\45\0\1\62\42\0\1\62\7\0\2\13"+
    "\1\136\14\13\2\0\1\13\13\0\2\13\2\0\1\13"+
    "\2\0\1\13\1\0\26\13\12\0\17\13\2\0\1\13"+
    "\13\0\2\13\2\0\1\13\2\0\1\13\1\0\1\137"+
    "\25\13\12\0\1\140\16\13\2\0\1\13\13\0\2\13"+
    "\2\0\1\13\2\0\1\13\1\0\26\13\12\0\7\13"+
    "\1\141\7\13\2\0\1\13\13\0\2\13\2\0\1\13"+
    "\2\0\1\13\1\0\26\13\12\0\1\142\16\13\2\0"+
    "\1\13\13\0\2\13\2\0\1\13\2\0\1\13\1\0"+
    "\26\13\12\0\6\13\1\143\10\13\2\0\1\13\13\0"+
    "\2\13\2\0\1\13\2\0\1\13\1\0\26\13\12\0"+
    "\1\13\1\144\15\13\2\0\1\13\13\0\2\13\2\0"+
    "\1\13\2\0\1\13\1\0\26\13\12\0\1\13\1\145"+
    "\15\13\2\0\1\13\13\0\2\13\2\0\1\13\2\0"+
    "\1\13\1\0\26\13\15\0\1\146\4\0\2\77\2\0"+
    "\1\77\1\0\1\77\2\0\1\146\64\0\1\41\115\0"+
    "\2\101\2\0\1\101\1\0\1\101\1\0\1\77\20\0"+
    "\1\100\54\0\1\101\1\102\2\0\1\102\1\0\1\102"+
    "\1\0\1\77\20\0\1\100\47\0\1\147\1\0\2\147"+
    "\4\0\1\147\1\0\1\147\3\0\1\147\24\0\1\147"+
    "\1\0\2\147\1\0\1\147\2\0\1\147\5\0\1\147"+
    "\32\0\1\150\4\0\1\150\100\0\1\151\1\103\1\0"+
    "\1\151\1\104\1\151\34\0\1\104\1\0\1\103\21\0"+
    "\42\113\1\0\43\113\16\152\1\153\23\152\1\154\4\152"+
    "\1\155\2\152\2\153\31\152\1\153\7\0\17\13\2\0"+
    "\1\13\13\0\2\13\2\0\1\13\2\0\1\13\1\0"+
    "\1\156\25\13\61\0\1\157\36\0\1\160\16\13\2\0"+
    "\1\13\13\0\2\13\2\0\1\13\2\0\1\13\1\0"+
    "\26\13\12\0\17\13\2\0\1\13\13\0\2\13\2\0"+
    "\1\161\2\0\1\13\1\0\26\13\12\0\6\13\1\162"+
    "\10\13\2\0\1\13\13\0\2\13\2\0\1\13\2\0"+
    "\1\13\1\0\26\13\12\0\5\13\1\163\11\13\2\0"+
    "\1\13\13\0\2\13\2\0\1\13\2\0\1\13\1\0"+
    "\26\13\12\0\2\13\1\164\14\13\2\0\1\13\13\0"+
    "\2\13\2\0\1\13\2\0\1\13\1\0\26\13\12\0"+
    "\3\13\1\165\13\13\2\0\1\13\13\0\2\13\2\0"+
    "\1\13\2\0\1\13\1\0\26\13\12\0\17\13\2\0"+
    "\1\13\13\0\2\13\2\0\1\13\2\0\1\13\1\0"+
    "\4\13\1\166\21\13\12\0\17\13\2\0\1\13\13\0"+
    "\2\13\2\0\1\13\2\0\1\13\1\0\1\167\25\13"+
    "\12\0\17\13\2\0\1\13\13\0\2\13\2\0\1\13"+
    "\2\0\1\13\1\0\1\170\25\13\12\0\17\13\2\0"+
    "\1\13\13\0\2\13\2\0\1\13\2\0\1\13\1\0"+
    "\11\13\1\171\14\13\12\0\5\13\1\172\11\13\2\0"+
    "\1\13\13\0\2\13\2\0\1\13\2\0\1\13\1\0"+
    "\26\13\12\0\6\13\1\173\10\13\2\0\1\13\13\0"+
    "\2\13\2\0\1\13\2\0\1\13\1\0\26\13\12\0"+
    "\1\174\16\13\2\0\1\13\13\0\2\13\2\0\1\13"+
    "\2\0\1\13\1\0\26\13\12\0\1\175\16\13\2\0"+
    "\1\13\13\0\2\13\2\0\1\13\2\0\1\13\1\0"+
    "\26\13\12\0\3\13\1\176\13\13\2\0\1\13\13\0"+
    "\2\13\2\0\1\13\2\0\1\13\1\0\26\13\12\0"+
    "\7\13\1\177\7\13\2\0\1\13\13\0\2\13\2\0"+
    "\1\13\2\0\1\13\1\0\26\13\12\0\2\13\1\200"+
    "\14\13\2\0\1\13\13\0\2\13\2\0\1\13\2\0"+
    "\1\13\1\0\26\13\12\0\3\13\1\201\13\13\2\0"+
    "\1\13\13\0\2\13\2\0\1\13\2\0\1\13\1\0"+
    "\26\13\12\0\3\13\1\202\13\13\2\0\1\13\13\0"+
    "\2\13\2\0\1\13\2\0\1\13\1\0\26\13\12\0"+
    "\7\13\1\136\7\13\2\0\1\13\13\0\2\13\2\0"+
    "\1\13\2\0\1\13\1\0\26\13\12\0\17\13\2\0"+
    "\1\13\13\0\2\13\2\0\1\13\2\0\1\13\1\0"+
    "\1\203\25\13\22\0\2\204\2\0\1\204\1\0\1\204"+
    "\1\205\54\0\1\205\22\0\1\151\2\0\1\151\1\0"+
    "\1\151\60\0\42\206\1\207\4\206\1\210\54\206\1\153"+
    "\23\206\1\154\4\206\1\210\2\206\2\153\31\206\1\153"+
    "\16\207\1\154\23\207\1\154\4\207\1\211\2\207\2\154"+
    "\31\207\1\154\42\206\1\207\3\206\1\212\1\210\36\206"+
    "\7\0\17\13\2\0\1\13\13\0\2\13\2\0\1\13"+
    "\2\0\1\13\1\0\3\13\1\213\22\13\62\0\1\214"+
    "\35\0\3\13\1\215\13\13\2\0\1\13\13\0\2\13"+
    "\2\0\1\13\2\0\1\13\1\0\26\13\12\0\6\13"+
    "\1\216\10\13\2\0\1\13\13\0\2\13\2\0\1\13"+
    "\2\0\1\13\1\0\26\13\12\0\6\13\1\217\10\13"+
    "\2\0\1\13\13\0\2\13\2\0\1\13\2\0\1\13"+
    "\1\0\26\13\12\0\7\13\1\220\7\13\2\0\1\13"+
    "\13\0\2\13\2\0\1\13\2\0\1\13\1\0\26\13"+
    "\12\0\17\13\2\0\1\13\13\0\2\13\2\0\1\13"+
    "\2\0\1\13\1\0\5\13\1\221\20\13\12\0\5\13"+
    "\1\222\11\13\2\0\1\13\13\0\2\13\2\0\1\13"+
    "\2\0\1\13\1\0\26\13\12\0\6\13\1\223\10\13"+
    "\2\0\1\13\13\0\2\13\2\0\1\13\2\0\1\13"+
    "\1\0\26\13\12\0\6\13\1\224\10\13\2\0\1\13"+
    "\13\0\2\13\2\0\1\13\2\0\1\13\1\0\26\13"+
    "\12\0\17\13\2\0\1\13\13\0\2\13\2\0\1\13"+
    "\2\0\1\13\1\0\1\13\1\225\24\13\12\0\17\13"+
    "\2\0\1\13\13\0\2\13\2\0\1\13\2\0\1\13"+
    "\1\0\16\13\1\226\7\13\12\0\17\13\2\0\1\13"+
    "\13\0\2\13\2\0\1\13\2\0\1\13\1\0\3\13"+
    "\1\227\22\13\12\0\6\13\1\230\10\13\2\0\1\13"+
    "\13\0\2\13\2\0\1\13\2\0\1\13\1\0\26\13"+
    "\12\0\15\13\1\231\1\13\2\0\1\13\13\0\2\13"+
    "\2\0\1\13\2\0\1\13\1\0\26\13\12\0\15\13"+
    "\1\232\1\13\2\0\1\13\13\0\2\13\2\0\1\13"+
    "\2\0\1\13\1\0\26\13\12\0\1\13\1\233\15\13"+
    "\2\0\1\13\13\0\2\13\2\0\1\13\2\0\1\13"+
    "\1\0\26\13\12\0\17\13\2\0\1\13\13\0\2\13"+
    "\2\0\1\13\2\0\1\13\1\0\1\13\1\234\24\13"+
    "\12\0\17\13\2\0\1\13\13\0\2\13\2\0\1\13"+
    "\2\0\1\13\1\0\1\13\1\235\24\13\22\0\2\204"+
    "\2\0\1\204\1\0\1\204\60\0\47\207\1\211\104\207"+
    "\1\41\1\211\36\207\42\236\1\0\4\236\1\237\36\236"+
    "\15\0\1\240\77\0\1\13\1\241\15\13\2\0\1\13"+
    "\13\0\2\13\2\0\1\13\2\0\1\13\1\0\26\13"+
    "\12\0\3\13\1\242\13\13\2\0\1\13\13\0\2\13"+
    "\2\0\1\13\2\0\1\13\1\0\26\13\12\0\7\13"+
    "\1\243\7\13\2\0\1\13\13\0\2\13\2\0\1\13"+
    "\2\0\1\13\1\0\26\13\12\0\6\13\1\244\10\13"+
    "\2\0\1\13\13\0\2\13\2\0\1\13\2\0\1\13"+
    "\1\0\26\13\12\0\17\13\2\0\1\13\13\0\2\13"+
    "\2\0\1\13\2\0\1\13\1\0\13\13\1\245\12\13"+
    "\12\0\3\13\1\246\13\13\2\0\1\13\13\0\2\13"+
    "\2\0\1\13\2\0\1\13\1\0\26\13\12\0\1\247"+
    "\16\13\2\0\1\13\13\0\2\13\2\0\1\13\2\0"+
    "\1\13\1\0\26\13\12\0\1\13\1\250\15\13\2\0"+
    "\1\13\13\0\2\13\2\0\1\13\2\0\1\13\1\0"+
    "\26\13\12\0\17\13\2\0\1\13\13\0\2\13\2\0"+
    "\1\13\2\0\1\13\1\0\21\13\1\251\1\252\3\13"+
    "\12\0\17\13\2\0\1\13\13\0\2\13\2\0\1\13"+
    "\2\0\1\13\1\0\4\13\1\253\21\13\12\0\17\13"+
    "\2\0\1\13\13\0\2\13\2\0\1\13\2\0\1\13"+
    "\1\0\17\13\1\254\6\13\12\0\17\13\2\0\1\13"+
    "\13\0\2\13\2\0\1\13\2\0\1\13\1\0\17\13"+
    "\1\255\6\13\12\0\17\13\2\0\1\13\13\0\2\13"+
    "\2\0\1\13\2\0\1\13\1\0\1\13\1\256\24\13"+
    "\12\0\17\13\2\0\1\13\13\0\2\13\2\0\1\13"+
    "\2\0\1\13\1\0\3\13\1\257\22\13\12\0\17\13"+
    "\2\0\1\13\13\0\2\13\2\0\1\13\2\0\1\13"+
    "\1\0\6\13\1\260\17\13\3\0\42\236\1\0\3\236"+
    "\1\212\1\237\36\236\11\0\1\261\103\0\4\13\1\262"+
    "\12\13\2\0\1\13\13\0\2\13\2\0\1\13\2\0"+
    "\1\13\1\0\26\13\12\0\17\13\2\0\1\13\13\0"+
    "\2\13\2\0\1\13\2\0\1\13\1\0\10\13\1\263"+
    "\15\13\12\0\3\13\1\264\13\13\2\0\1\13\13\0"+
    "\2\13\2\0\1\13\2\0\1\13\1\0\26\13\12\0"+
    "\1\13\1\265\15\13\2\0\1\13\13\0\2\13\2\0"+
    "\1\13\2\0\1\13\1\0\26\13\12\0\17\13\2\0"+
    "\1\13\13\0\2\13\2\0\1\13\2\0\1\13\1\0"+
    "\1\13\1\266\24\13\12\0\17\13\2\0\1\13\13\0"+
    "\2\13\2\0\1\13\2\0\1\13\1\0\1\267\25\13"+
    "\12\0\17\13\2\0\1\13\13\0\2\13\2\0\1\13"+
    "\2\0\1\13\1\0\2\13\1\270\23\13\12\0\1\271"+
    "\16\13\2\0\1\13\13\0\2\13\2\0\1\13\2\0"+
    "\1\13\1\0\26\13\12\0\1\272\16\13\2\0\1\13"+
    "\13\0\2\13\2\0\1\13\2\0\1\13\1\0\26\13"+
    "\12\0\7\13\1\273\7\13\2\0\1\13\13\0\2\13"+
    "\2\0\1\13\2\0\1\13\1\0\26\13\63\0\1\274"+
    "\34\0\5\13\1\275\11\13\2\0\1\13\13\0\2\13"+
    "\2\0\1\13\2\0\1\13\1\0\26\13\12\0\3\13"+
    "\1\276\13\13\2\0\1\13\13\0\2\13\2\0\1\13"+
    "\2\0\1\13\1\0\26\13\12\0\5\13\1\277\11\13"+
    "\2\0\1\13\13\0\2\13\2\0\1\13\2\0\1\13"+
    "\1\0\26\13\12\0\1\300\16\13\2\0\1\13\13\0"+
    "\2\13\2\0\1\13\2\0\1\13\1\0\26\13\12\0"+
    "\17\13\2\0\1\13\13\0\2\13\2\0\1\13\2\0"+
    "\1\13\1\0\1\13\1\301\24\13\12\0\3\13\1\302"+
    "\13\13\2\0\1\13\13\0\2\13\2\0\1\13\2\0"+
    "\1\13\1\0\26\13\12\0\3\13\1\303\13\13\2\0"+
    "\1\13\13\0\2\13\2\0\1\13\2\0\1\13\1\0"+
    "\26\13\15\0\1\304\102\0\17\13\2\0\1\13\13\0"+
    "\2\13\2\0\1\13\2\0\1\13\1\0\2\13\1\305"+
    "\23\13\12\0\17\13\2\0\1\13\13\0\2\13\2\0"+
    "\1\13\2\0\1\13\1\0\1\13\1\306\24\13\12\0"+
    "\17\13\2\0\1\13\13\0\2\13\2\0\1\13\2\0"+
    "\1\13\1\0\17\13\1\307\6\13\12\0\3\13\1\310"+
    "\13\13\2\0\1\13\13\0\2\13\2\0\1\13\2\0"+
    "\1\13\1\0\26\13\12\0\3\13\1\311\13\13\2\0"+
    "\1\13\13\0\2\13\2\0\1\13\2\0\1\13\1\0"+
    "\26\13\12\0\3\13\1\312\13\13\2\0\1\13\13\0"+
    "\2\13\2\0\1\13\2\0\1\13\1\0\26\13\12\0"+
    "\1\313\16\13\2\0\1\13\13\0\2\13\2\0\1\13"+
    "\2\0\1\13\1\0\26\13\12\0\17\13\2\0\1\13"+
    "\13\0\2\13\2\0\1\13\2\0\1\13\1\0\6\13"+
    "\1\314\17\13\12\0\7\13\1\315\7\13\2\0\1\13"+
    "\13\0\2\13\2\0\1\13\2\0\1\13\1\0\26\13"+
    "\12\0\3\13\1\316\13\13\2\0\1\13\13\0\2\13"+
    "\2\0\1\13\2\0\1\13\1\0\26\13\12\0\1\13"+
    "\1\317\15\13\2\0\1\13\13\0\2\13\2\0\1\13"+
    "\2\0\1\13\1\0\26\13\3\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[10850];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /* error messages for the codes above */
  private static final String ZZ_ERROR_MSG[] = {
    "Unkown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\1\0\1\11\17\1\6\11\1\1\1\11\6\1\2\11"+
    "\17\1\1\11\1\1\4\11\11\1\2\0\1\1\4\0"+
    "\1\1\1\0\1\1\1\0\3\1\1\0\27\1\1\0"+
    "\10\1\1\0\25\1\5\0\2\1\1\0\21\1\3\0"+
    "\20\1\1\0\12\1\1\0\7\1\1\11\13\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[207];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the input device */
  private java.io.Reader zzReader;

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private char zzBuffer[] = new char[ZZ_BUFFERSIZE];

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /** number of newlines encountered up to the start of the matched text */
  private int yyline;

  /** the number of characters up to the start of the matched text */
  private int yychar;

  /**
   * the number of characters from the last newline up to the start of the 
   * matched text
   */
  private int yycolumn;

  /** 
   * zzAtBOL == true <=> the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;

  /* user code: */
    public int linenumber = 0;
    public int columnnumber = 0;
    public String lexeme;
    public int errornumber = 0;
    public int errornumberLength = 0;
    public String Errors = "";
    public void getErrors(String error){
        errornumber++;
       System.out.println( errornumber + " Lexic Message Line: " + linenumber + " Col: " + columnnumber + " Text: " + error);
    }
    public void getIdenterror(String error){
        errornumberLength++;
       System.out.println( errornumberLength + " Lenght Message Line: " + linenumber + " Col: " + columnnumber + " Text: " + error);
    }
    private Symbol symbol(int type) {
        return new Symbol(type, yyline, yycolumn, yytext());
    }
    private Symbol symbol(int type, Object value) {
        return new Symbol(type, yyline, yycolumn, value);
    }




  /**
   * Creates a new scanner
   * There is also a java.io.InputStream version of this constructor.
   *
   * @param   in  the java.io.Reader to read input from.
   */
  Lexer(java.io.Reader in) {
    this.zzReader = in;
  }

  /**
   * Creates a new scanner.
   * There is also java.io.Reader version of this constructor.
   *
   * @param   in  the java.io.Inputstream to read input from.
   */
  Lexer(java.io.InputStream in) {
    this(new java.io.InputStreamReader(in));
  }

  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    char [] map = new char[0x10000];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < 178) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }


  /**
   * Refills the input buffer.
   *
   * @return      <code>false</code>, iff there was new input.
   * 
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (zzStartRead > 0) {
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead-zzStartRead);

      /* translate stored positions */
      zzEndRead-= zzStartRead;
      zzCurrentPos-= zzStartRead;
      zzMarkedPos-= zzStartRead;
      zzStartRead = 0;
    }

    /* is the buffer big enough? */
    if (zzCurrentPos >= zzBuffer.length) {
      /* if not: blow it up */
      char newBuffer[] = new char[zzCurrentPos*2];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
    }

    /* finally: fill the buffer with new input */
    int numRead = zzReader.read(zzBuffer, zzEndRead,
                                            zzBuffer.length-zzEndRead);

    if (numRead > 0) {
      zzEndRead+= numRead;
      return false;
    }
    // unlikely but not impossible: read 0 characters, but not at end of stream    
    if (numRead == 0) {
      int c = zzReader.read();
      if (c == -1) {
        return true;
      } else {
        zzBuffer[zzEndRead++] = (char) c;
        return false;
      }     
    }

	// numRead < 0
    return true;
  }

    
  /**
   * Closes the input stream.
   */
  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true;            /* indicate end of file */
    zzEndRead = zzStartRead;  /* invalidate buffer    */

    if (zzReader != null)
      zzReader.close();
  }


  /**
   * Resets the scanner to read from a new input stream.
   * Does not close the old reader.
   *
   * All internal variables are reset, the old input stream 
   * <b>cannot</b> be reused (internal buffer is discarded and lost).
   * Lexical state is set to <tt>ZZ_INITIAL</tt>.
   *
   * @param reader   the new input stream 
   */
  public final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzAtBOL  = true;
    zzAtEOF  = false;
    zzEOFDone = false;
    zzEndRead = zzStartRead = 0;
    zzCurrentPos = zzMarkedPos = 0;
    yyline = yychar = yycolumn = 0;
    zzLexicalState = YYINITIAL;
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final String yytext() {
    return new String( zzBuffer, zzStartRead, zzMarkedPos-zzStartRead );
  }


  /**
   * Returns the character at position <tt>pos</tt> from the 
   * matched text. 
   * 
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch. 
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBuffer[zzStartRead+pos];
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occured while scanning.
   *
   * In a wellformed scanner (no or only correct usage of 
   * yypushback(int) and a match-all fallback rule) this method 
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  } 


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Contains user EOF-code, which will be executed exactly once,
   * when the end of file is reached
   */
  private void zzDoEOF() throws java.io.IOException {
    if (!zzEOFDone) {
      zzEOFDone = true;
      yyclose();
    }
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public java_cup.runtime.Symbol next_token() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char [] zzBufferL = zzBuffer;
    char [] zzCMapL = ZZ_CMAP;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      boolean zzR = false;
      for (zzCurrentPosL = zzStartRead; zzCurrentPosL < zzMarkedPosL;
                                                             zzCurrentPosL++) {
        switch (zzBufferL[zzCurrentPosL]) {
        case '\u000B':
        case '\u000C':
        case '\u0085':
        case '\u2028':
        case '\u2029':
          yyline++;
          yycolumn = 0;
          zzR = false;
          break;
        case '\r':
          yyline++;
          yycolumn = 0;
          zzR = true;
          break;
        case '\n':
          if (zzR)
            zzR = false;
          else {
            yyline++;
            yycolumn = 0;
          }
          break;
        default:
          zzR = false;
          yycolumn++;
        }
      }

      if (zzR) {
        // peek one character ahead if it is \n (if we have counted one line too much)
        boolean zzPeek;
        if (zzMarkedPosL < zzEndReadL)
          zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        else if (zzAtEOF)
          zzPeek = false;
        else {
          boolean eof = zzRefill();
          zzEndReadL = zzEndRead;
          zzMarkedPosL = zzMarkedPos;
          zzBufferL = zzBuffer;
          if (eof) 
            zzPeek = false;
          else 
            zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        }
        if (zzPeek) yyline--;
      }
      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;
  
      zzState = ZZ_LEXSTATE[zzLexicalState];


      zzForAction: {
        while (true) {
    
          if (zzCurrentPosL < zzEndReadL)
            zzInput = zzBufferL[zzCurrentPosL++];
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = zzBufferL[zzCurrentPosL++];
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMapL[zzInput] ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          int zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
        case 44: 
          { return new Symbol(sym.STRING, yyline, yycolumn, yytext());
          }
        case 56: break;
        case 2: 
          { return new Symbol(sym.Less, yyline, yycolumn, yytext());
          }
        case 57: break;
        case 28: 
          { return new Symbol(sym.STRINGCONSTANT, yyline, yycolumn, yytext());
          }
        case 58: break;
        case 48: 
          { return new Symbol(sym.GETBYTE, yyline, yycolumn, yytext());
          }
        case 59: break;
        case 47: 
          { return new Symbol(sym.EXTENDS, yyline, yycolumn, yytext());
          }
        case 60: break;
        case 25: 
          { return new Symbol(sym.Comparison_op, yyline, yycolumn, yytext());
          }
        case 61: break;
        case 37: 
          { return new Symbol(sym.NULL, yyline, yycolumn, yytext());
          }
        case 62: break;
        case 26: 
          { return new Symbol(sym.Logical_Op, yyline, yycolumn, yytext());
          }
        case 63: break;
        case 43: 
          { return new Symbol(sym.RETURN, yyline, yycolumn, yytext());
          }
        case 64: break;
        case 42: 
          { return new Symbol(sym.PRINT, yyline, yycolumn, yytext());
          }
        case 65: break;
        case 45: 
          { return new Symbol(sym.DOUBLE, yyline, yycolumn, yytext());
          }
        case 66: break;
        case 34: 
          { return new Symbol(sym.THIS, yyline, yycolumn, yytext());
          }
        case 67: break;
        case 51: 
          { return new Symbol(sym.NEWARRAY, yyline, yycolumn, yytext());
          }
        case 68: break;
        case 50: 
          { return new Symbol(sym.INCLUDE, yyline, yycolumn, yytext());
          }
        case 69: break;
        case 22: 
          { return new Symbol(sym.mod, yyline, yycolumn, yytext());
          }
        case 70: break;
        case 35: 
          { return new Symbol(sym.ELSE, yyline, yycolumn, yytext());
          }
        case 71: break;
        case 52: 
          { return new Symbol(sym.READLINE, yyline, yycolumn, yytext());
          }
        case 72: break;
        case 38: 
          { return new Symbol(sym.BOOL, yyline, yycolumn, yytext());
          }
        case 73: break;
        case 19: 
          { return new Symbol(sym.div, yyline, yycolumn, yytext());
          }
        case 74: break;
        case 53: 
          { return new Symbol(sym.INTERFACE, yyline, yycolumn, yytext());
          }
        case 75: break;
        case 24: 
          { return new Symbol(sym.GreaterEqual, yyline, yycolumn, yytext());
          }
        case 76: break;
        case 32: 
          { return new Symbol(sym.NEW, yyline, yycolumn, yytext());
          }
        case 77: break;
        case 6: 
          { lexeme=yytext();
                    if(lexeme.length()<31)
                        return new Symbol(sym.ident, yyline, yycolumn, yytext());
                    linenumber=yyline;
                    columnnumber=yycolumn;
                    String temp = lexeme.substring(0, 30);
                    getIdenterror(temp);
          }
        case 78: break;
        case 9: 
          { return new Symbol(sym.Point, yyline, yycolumn, yytext());
          }
        case 79: break;
        case 55: 
          { return new Symbol(sym.READINTEGER, yyline, yycolumn, yytext());
          }
        case 80: break;
        case 10: 
          { return new Symbol(sym.Semicolon, yyline, yycolumn, yytext());
          }
        case 81: break;
        case 15: 
          { return new Symbol(sym.LeftBrace, yyline, yycolumn, yytext());
          }
        case 82: break;
        case 7: 
          { return new Symbol(sym.INTCONSTANT, yyline, yycolumn, new Integer(yytext()));
          }
        case 83: break;
        case 12: 
          { return new Symbol(sym.RightParenthesis, yyline, yycolumn, yytext());
          }
        case 84: break;
        case 33: 
          { return new Symbol(sym.BOOLCONSTANT, yyline, yycolumn, new Boolean(yytext()));
          }
        case 85: break;
        case 30: 
          { return new Symbol(sym.FOR, yyline, yycolumn, yytext());
          }
        case 86: break;
        case 3: 
          { return new Symbol(sym.Greater, yyline, yycolumn, yytext());
          }
        case 87: break;
        case 13: 
          { return new Symbol(sym.LeftParenthesis, yyline, yycolumn, yytext());
          }
        case 88: break;
        case 14: 
          { return new Symbol(sym.RightBrace, yyline, yycolumn, yytext());
          }
        case 89: break;
        case 1: 
          { lexeme=yytext();linenumber=yyline;columnnumber=yycolumn;getErrors(lexeme);
          }
        case 90: break;
        case 49: 
          { return new Symbol(sym.SETBYTE, yyline, yycolumn, yytext());
          }
        case 91: break;
        case 46: 
          { return new Symbol(sym.MALLOC, yyline, yycolumn, yytext());
          }
        case 92: break;
        case 31: 
          { return new Symbol(sym.INT, yyline, yycolumn, yytext());
          }
        case 93: break;
        case 5: 
          { return new Symbol(sym.EXCLA, yyline, yycolumn, yytext());
          }
        case 94: break;
        case 11: 
          { return new Symbol(sym.Comma, yyline, yycolumn, yytext());
          }
        case 95: break;
        case 17: 
          { return new Symbol(sym.LeftBracket, yyline, yycolumn, yytext());
          }
        case 96: break;
        case 21: 
          { return new Symbol(sym.Negation, yyline, yycolumn, yytext());
          }
        case 97: break;
        case 29: 
          { return new Symbol(sym.IF, yyline, yycolumn, yytext());
          }
        case 98: break;
        case 54: 
          { return new Symbol(sym.IMPLEMENTS, yyline, yycolumn, yytext());
          }
        case 99: break;
        case 39: 
          { return new Symbol(sym.CLASS, yyline, yycolumn, yytext());
          }
        case 100: break;
        case 4: 
          { return new Symbol(sym.Equal, yyline, yycolumn, yytext());
          }
        case 101: break;
        case 20: 
          { return new Symbol(sym.mult, yyline, yycolumn, yytext());
          }
        case 102: break;
        case 27: 
          { return new Symbol(sym.DOUBLECONSTANT, yyline, yycolumn, new Double(yytext()));
          }
        case 103: break;
        case 8: 
          { return new Symbol(sym.plus, yyline, yycolumn, yytext());
          }
        case 104: break;
        case 40: 
          { return new Symbol(sym.BREAK, yyline, yycolumn, yytext());
          }
        case 105: break;
        case 16: 
          { return new Symbol(sym.RightBracket, yyline, yycolumn, yytext());
          }
        case 106: break;
        case 36: 
          { return new Symbol(sym.VOID, yyline, yycolumn, yytext());
          }
        case 107: break;
        case 23: 
          { return new Symbol(sym.LessEqual, yyline, yycolumn, yytext());
          }
        case 108: break;
        case 41: 
          { return new Symbol(sym.WHILE, yyline, yycolumn, yytext());
          }
        case 109: break;
        case 18: 
          { 
          }
        case 110: break;
        default: 
          if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
            zzAtEOF = true;
            zzDoEOF();
              { return new java_cup.runtime.Symbol(sym.EOF); }
          } 
          else {
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }


}
