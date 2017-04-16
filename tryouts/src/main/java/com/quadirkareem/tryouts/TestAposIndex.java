package com.quadirkareem.tryouts;
public class TestAposIndex {

	public static void main(String[] args) {
		String jenkins = "jenkins -m";
		String[] commentArr = { "jenkins -m", "jenkins -m\"hello\"",
				"jenkins -m \"hello\"", "jenkins -m\"\"", "jenkins -m quadir",
				"jenkins -mquadir" };
		for (String mergeComment : commentArr) {
			String actualMergeComment = "";
			if (mergeComment != null && !mergeComment.isEmpty()) {
				mergeComment = mergeComment.substring(jenkins.length()).trim();
				int startIndex = (mergeComment.indexOf('"') == 0) ? 1 : 0;
				int endIndex = (mergeComment.lastIndexOf('"') == mergeComment
						.length() - 1) ? (mergeComment.length() - 1)
						: mergeComment.length();
				System.out.println("startIndex=" + startIndex + ", endIndex="
						+ endIndex);
				if (startIndex > -1 && endIndex > startIndex) {
					actualMergeComment += mergeComment.substring(startIndex,
							endIndex);
				}
			}
			System.out.println("comment=<" + actualMergeComment + ">");
		}
	}

}
