package info;

import java.util.ArrayList;
import java.util.List;

import data.User;
import data.UserGroup;

public class PositiveTotal implements Visitor {
	
	private List<String> message;
	private final String[] POSITIVE_WORDS = {"hello", "world", "nice", "to", "meet", "you",
												"today", "is", "a", "good", "day"};
	
	public PositiveTotal() {
		message = new ArrayList<>();
	}

	@Override
	public void visit(UserGroup visitor) {
		
	}

	@Override
	public void visit(User visitor) {
		for (int i = 0;i < visitor.getFeed().size(); i++) {
			message.add(visitor.getFeed().get(i));
		}
	}
	
	/**
	 * Calculate the percentage of positive words with comparison to POSITIVE_WORDS list
	 * @return Positive percentage of words
	 */
	public float getTotal() {
		float count = 0f;
		for (int i = 0; i < message.size(); i++) {
			/**
			 * Check if any words from news feed match list of positive words
			 */
			for (int j = 0; j < POSITIVE_WORDS.length; j++) {
				if (message.get(i).toLowerCase().contains(POSITIVE_WORDS[j])) {
					count++;
				}
			}
		}
		return (count / message.size()) * 100;
	}

}
