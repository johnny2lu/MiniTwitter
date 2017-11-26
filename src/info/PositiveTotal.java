package info;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import data.User;
import data.UserGroup;

public class PositiveTotal implements Visitor {
	
	private ArrayList<String> message;
	private final String[] POSITIVE_WORDS = {"hello", "world", "nice", "to", "meet", "you",
												"today", "is", "good", "day"};
	
	public PositiveTotal() {
		message = new ArrayList<>();
	}

	@Override
	public void visit(UserGroup visitor) {
		
	}

	/**
	 * Add each newsFeed message into message
	 * @param visitor
	 */
	@Override
	public void visit(User visitor) {
		message = Collections.list(visitor.getFeed().elements());
	}
	
	/**
	 * Calculate the percentage of positive words with comparison to POSITIVE_WORDS list
	 * @return Positive percentage of words
	 */
	public float getTotal() {
		float count = 0f;
		int countWords = 0;
		for (int i = 0; i < message.size(); i++) {
			/**
			 * Check if any words from news feed match list of positive words
			 */
			for (int j = 0; j < POSITIVE_WORDS.length; j++) {
				if (message.get(i).toLowerCase().contains(POSITIVE_WORDS[j])) {
					count++;
				}
			}
			// Get word count separated by white space
			countWords += message.get(i).split("\\s+").length;
		}
		return (count / countWords) * 100;
	}

}
