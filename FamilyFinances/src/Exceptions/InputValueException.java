package Exceptions;

@SuppressWarnings("serial")
public
class InputValueException extends Exception {
	public InputValueException(String str)
	{
		super(str);
	}
}