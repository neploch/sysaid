package sysAid;
import java.awt.*;

import static java.awt.event.KeyEvent.*;
import static java.awt.event.KeyEvent.VK_ALT;
import static java.awt.event.KeyEvent.VK_SHIFT;

    public class Keyboard
    {
        private static Robot robot;

        public Keyboard() throws AWTException {
            this.robot = new Robot();
        }

        public Keyboard(Robot robot) {
            this.robot = robot;
        }

        public static void type(CharSequence characters) {
            int length = characters.length();
            for (int i = 0; i < length; i++) {
                char character = characters.charAt(i);
                type(character);
            }
        }

        public static  void type(char character) {
            switch (character) {
                case 'a': doType(VK_A); break;
                case 'b': doType(VK_B); break;
                case 'c': doType(VK_C); break;
                case 'd': doType(VK_D); break;
                case 'e': doType(VK_E); break;
                case 'f': doType(VK_F); break;
                case 'g': doType(VK_G); break;
                case 'h': doType(VK_H); break;
                case 'i': doType(VK_I); break;
                case 'j': doType(VK_J); break;
                case 'k': doType(VK_K); break;
                case 'l': doType(VK_L); break;
                case 'm': doType(VK_M); break;
                case 'n': doType(VK_N); break;
                case 'o': doType(VK_O); break;
                case 'p': doType(VK_P); break;
                case 'q': doType(VK_Q); break;
                case 'r': doType(VK_R); break;
                case 's': doType(VK_S); break;
                case 't': doType(VK_T); break;
                case 'u': doType(VK_U); break;
                case 'v': doType(VK_V); break;
                case 'w': doType(VK_W); break;
                case 'x': doType(VK_X); break;
                case 'y': doType(VK_Y); break;
                case 'z': doType(VK_Z); break;
                case 'A': doType(VK_SHIFT, VK_A); break;
                case 'B': doType(VK_SHIFT, VK_B); break;
                case 'C': doType(VK_SHIFT, VK_C); break;
                case 'D': doType(VK_SHIFT, VK_D); break;
                case 'E': doType(VK_SHIFT, VK_E); break;
                case 'F': doType(VK_SHIFT, VK_F); break;
                case 'G': doType(VK_SHIFT, VK_G); break;
                case 'H': doType(VK_SHIFT, VK_H); break;
                case 'I': doType(VK_SHIFT, VK_I); break;
                case 'J': doType(VK_SHIFT, VK_J); break;
                case 'K': doType(VK_SHIFT, VK_K); break;
                case 'L': doType(VK_SHIFT, VK_L); break;
                case 'M': doType(VK_SHIFT, VK_M); break;
                case 'N': doType(VK_SHIFT, VK_N); break;
                case 'O': doType(VK_SHIFT, VK_O); break;
                case 'P': doType(VK_SHIFT, VK_P); break;
                case 'Q': doType(VK_SHIFT, VK_Q); break;
                case 'R': doType(VK_SHIFT, VK_R); break;
                case 'S': doType(VK_SHIFT, VK_S); break;
                case 'T': doType(VK_SHIFT, VK_T); break;
                case 'U': doType(VK_SHIFT, VK_U); break;
                case 'V': doType(VK_SHIFT, VK_V); break;
                case 'W': doType(VK_SHIFT, VK_W); break;
                case 'X': doType(VK_SHIFT, VK_X); break;
                case 'Y': doType(VK_SHIFT, VK_Y); break;
                case 'Z': doType(VK_SHIFT, VK_Z); break;
                case '`': doType(VK_BACK_QUOTE); break;
                case '0': doType(VK_0); break;
                case '1': doType(VK_1); break;
                case '2': doType(VK_2); break;
                case '3': doType(VK_3); break;
                case '4': doType(VK_4); break;
                case '5': doType(VK_5); break;
                case '6': doType(VK_6); break;
                case '7': doType(VK_7); break;
                case '8': doType(VK_8); break;
                case '9': doType(VK_9); break;
                case '-': doType(VK_MINUS); break;
                case '=': doType(VK_EQUALS); break;
                case '~': doType(VK_SHIFT, VK_BACK_QUOTE); break;
                case '!': doType(VK_SHIFT,VK_1); break;  //EXCLAMATION_MARK
                case '@': doType(VK_SHIFT,VK_2); break;  //VK_AT
                case '#': doType(VK_SHIFT,VK_3); break;  //VK_NUMBER_SIGN
                case '$': doType(VK_SHIFT,VK_4); break;  //VK_DOLLAR
                case '%': doType(VK_SHIFT, VK_5); break;
                case '^': doType(VK_SHIFT,VK_6); break;  //VK_CIRCUMFLEX
                case '&': doType(VK_SHIFT,VK_7); break;  //VK_AMPERSAND
                case '*': doType(VK_SHIFT,VK_8); break;  //VK_ASTERISK
                case '(': doType(VK_SHIFT,VK_9); break;  //VK_LEFT_PARENTHESIS
                case ')': doType(VK_SHIFT,VK_0); break;  //VK_RIGHT_PARENTHESIS
                case '_': doType(VK_SHIFT,VK_MINUS); break;  //VK_UNDERSCORE
                case '+': doType(VK_SHIFT,VK_EQUALS); break;  //VK_PLUS
                case '\t': doType(VK_TAB); break;
                case '\n': doType(VK_ENTER); break;
                case '[': doType(VK_OPEN_BRACKET); break;
                case ']': doType(VK_CLOSE_BRACKET); break;
                case '\\': doType(VK_BACK_SLASH); break;
                case '{': doType(VK_SHIFT, VK_OPEN_BRACKET); break;
                case '}': doType(VK_SHIFT, VK_CLOSE_BRACKET); break;
                case '|': doType(VK_SHIFT, VK_BACK_SLASH); break;
                case ';': doType(VK_SEMICOLON); break;
                case ':': doType(VK_SHIFT,VK_SEMICOLON); break;  //VK_COLON
                case '\'': doType(VK_QUOTE); break;
                case '"': doType(VK_SHIFT,VK_QUOTE); break;  //VK_QUOTEDBL
                case ',': doType(VK_COMMA); break;
                case '<': doType(VK_SHIFT, VK_COMMA); break;
                case '.': doType(VK_PERIOD); break;
                case '>': doType(VK_SHIFT, VK_PERIOD); break;
                case '/': doType(VK_SLASH); break;
                case '?': doType(VK_SHIFT, VK_SLASH); break;
                case ' ': doType(VK_SPACE); break;
                case 'א': doType(VK_ALT, VK_SHIFT); doType(VK_T); doType(VK_ALT, VK_SHIFT); break;
                case 'ב': doType(VK_ALT, VK_SHIFT); doType(VK_C); doType(VK_ALT, VK_SHIFT); break;
                case 'ג': doType(VK_ALT, VK_SHIFT); doType(VK_D); doType(VK_ALT, VK_SHIFT); break;
                case 'ד': doType(VK_ALT, VK_SHIFT); doType(VK_S); doType(VK_ALT, VK_SHIFT); break;
                case 'ה': doType(VK_ALT, VK_SHIFT); doType(VK_V); doType(VK_ALT, VK_SHIFT); break;
                case 'ו': doType(VK_ALT, VK_SHIFT); doType(VK_U); doType(VK_ALT, VK_SHIFT); break;
                case 'ז': doType(VK_ALT, VK_SHIFT); doType(VK_Z); doType(VK_ALT, VK_SHIFT); break;
                case 'ח': doType(VK_ALT, VK_SHIFT); doType(VK_J); doType(VK_ALT, VK_SHIFT); break;
                case 'ט': doType(VK_ALT, VK_SHIFT); doType(VK_Y); doType(VK_ALT, VK_SHIFT); break;
                case 'י': doType(VK_ALT, VK_SHIFT); doType(VK_H); doType(VK_ALT, VK_SHIFT); break;
                case 'כ': doType(VK_ALT, VK_SHIFT); doType(VK_F); doType(VK_ALT, VK_SHIFT); break;
                case 'ך': doType(VK_ALT, VK_SHIFT); doType(VK_L); doType(VK_ALT, VK_SHIFT); break;
                case 'ל': doType(VK_ALT, VK_SHIFT); doType(VK_K); doType(VK_ALT, VK_SHIFT); break;
                case 'מ': doType(VK_ALT, VK_SHIFT); doType(VK_N); doType(VK_ALT, VK_SHIFT); break;
                case 'ם': doType(VK_ALT, VK_SHIFT); doType(VK_O); doType(VK_ALT, VK_SHIFT); break;
                case 'נ': doType(VK_ALT, VK_SHIFT); doType(VK_B); doType(VK_ALT, VK_SHIFT); break;
                case 'ן': doType(VK_ALT, VK_SHIFT); doType(VK_I); doType(VK_ALT, VK_SHIFT); break;
                case 'ס': doType(VK_ALT, VK_SHIFT); doType(VK_X); doType(VK_ALT, VK_SHIFT); break;
                case 'ע': doType(VK_ALT, VK_SHIFT); doType(VK_G); doType(VK_ALT, VK_SHIFT); break;
                case 'פ': doType(VK_ALT, VK_SHIFT); doType(VK_P); doType(VK_ALT, VK_SHIFT); break;
                case 'ף': doType(VK_ALT, VK_SHIFT); doType(VK_SEMICOLON); doType(VK_ALT, VK_SHIFT); break;
                case 'צ': doType(VK_ALT, VK_SHIFT); doType(VK_M); doType(VK_ALT, VK_SHIFT); break;
                case 'ץ': doType(VK_ALT, VK_SHIFT); doType(VK_PERIOD); doType(VK_ALT, VK_SHIFT); break;
                case 'ק': doType(VK_ALT, VK_SHIFT); doType(VK_E); doType(VK_ALT, VK_SHIFT); break;
                case 'ר': doType(VK_ALT, VK_SHIFT); doType(VK_R); doType(VK_ALT, VK_SHIFT); break;
                case 'ש': doType(VK_ALT, VK_SHIFT); doType(VK_A); doType(VK_ALT, VK_SHIFT); break;
                case 'ת': doType(VK_ALT, VK_SHIFT); doType(VK_COMMA); doType(VK_ALT, VK_SHIFT); break;
                default:
                    throw new IllegalArgumentException("Cannot type character " + character);
            }
        }

        private static void doType(int... keyCodes) {
            doType(keyCodes, 0, keyCodes.length);
        }

        private static void doType(int[] keyCodes, int offset, int length) {
            if (length == 0) {
                return;
            }

            robot.keyPress(keyCodes[offset]);
            doType(keyCodes, offset + 1, length - 1);
            robot.keyRelease(keyCodes[offset]);
        }


    }
