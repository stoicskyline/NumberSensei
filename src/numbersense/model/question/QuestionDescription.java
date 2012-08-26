package numbersense.model.question;

import numbersense.util.Utility;

/**
 * Format of a problem description:
 * [question] _______ [appendix]
 *
 * e.g.
 * 300 minutes = _________ hours
 * 840 - 400 = _________________
 * XXV = _____ (Arabic numerals)
 *
 * @author George Chen
 * @since 12/19/11 5:01 PM
 */
public class QuestionDescription {
	public String question;
	public String appendix;

	public QuestionDescription(String question) {
		this(question, null);
	}

	public QuestionDescription(String question, String appendix) {
		this.question = question;
		this.appendix = appendix;
	}

	public String getQuestion() {
		return (question == null ? "" : question);
	}

	public String getAppendix() {
		return (appendix == null ? "" : appendix);
	}

	/**
	 * @param stringLength
	 * @return formatted question with a blank inserted.  If stringLength is too short, the blank defaults to one underline.
	 */
	public String toStringWithLength(int stringLength) {
		int questionLength = getQuestion().length();
		int appendixLength = getAppendix().length();

		int blankLength = stringLength - questionLength - appendixLength;
		String blank;
		if (blankLength > 2) {
			blank = Utility.UNDERSCORES.substring(0, blankLength);
		}
		else {
			blank = "_";
		}

		return getQuestion() + " " + blank + " " + getAppendix();
	}

	@Override
	public String toString() {
		return getQuestion() + " ____ " + getAppendix();
	}
}
