// Written by Jacob Margoliash
// CS 356 Project 1
// 8/13/15

import java.util.Random;

class Project1
{
	public static void main (String [] args)
	{
		Random random = new Random();
		String[] possibleAnswers = {"a", "b", "c", "d", "ab", "ac", "ad", "bc", "bd", "cd", "abc", "abd", "acd", "bcd", "abcd"};
		String[] possibleTypes = {"single", "multiple"};
		String type = possibleTypes[random.nextInt(2)];
		IVoteService ivs = new IVoteService(type);


		for (int i = 1; i <= 30; i++)
		{
			Student s;
			if (type.equals("single"))
				s = new Student(i, possibleAnswers[random.nextInt(4)]);
			else
				s = new Student(i, possibleAnswers[random.nextInt(15)]);

			ivs.setAnswers(s.getAnswers());
		}

		ivs.output();
	}
}

class Student
{
	private int id;
	private String answer;
	private int[] answers;

	public Student (int id, String answer)
	{
		this.id = id;
		this.answer = answer;

		answers = new int[4];

		if (answer.contains("a"))
			answers[0]++;
		if (answer.contains("b"))
			answers[1]++;
		if (answer.contains("c"))
			answers[2]++;
		if (answer.contains("d"))
			answers[3]++;
	}

	public int[] getAnswers()
	{
		return answers;
	}
}

class IVoteService
{
	private int[] allAnswers;
	private String type;

	public IVoteService(String type)
	{
		this.type = type;

		allAnswers = new int[4];
	}

	public void setAnswers(int[] answers)
	{
		for (int i = 0; i < 4; i++)
			allAnswers[i] += answers[i];	
	}

	public void output()
	{
		System.out.println("A: " + allAnswers[0]);
		System.out.println("B: " + allAnswers[1]);
		System.out.println("C: " + allAnswers[2]);
		System.out.println("D: " + allAnswers[3]);
	}
}