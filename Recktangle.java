public class Recktangle
{
	public static void main(String args[])
	{
		if(args.length != 3){System.exit(0);}
		String word = args[0].toUpperCase();
		int width = Integer.parseInt(args[1]);
		int height = Integer.parseInt(args[2]);
		printRektangle(word, width, height);
	}

	public static void printRektangle(String word, int width, int height)
	{
		int length = word.length();
		char[] chars = (word.substring(0,word.length()-1)+reverse(word).substring(0,word.length()-1)).toCharArray();
		int charHeight = (height * length) - (height-1);
		int charWidth = (width * length) - (width-1);
		//System.out.println(""+charWidth + " x " + charHeight + " grid.");
		char[][] rektangle = new char[charHeight][charWidth];
		for(int i = 0; i < charWidth; i++)
		{
			for(int j = 0; j < charHeight; j=j+(length-1)*2)
			{
				rektangle[j][i] = chars[i%chars.length];
			}
			for(int j = length-1; j < charHeight; j=j+(length-1)*2)
			{
				rektangle[j][i] = chars[(length+i-1)%chars.length];
				//System.out.println(rektangle[i][j]+" -> " + (length+i-1)%chars.length);
			}
		}

		for(int i = 0; i < charHeight; i++)
		{
			for(int j = 0; j < charWidth; j=j+(length-1)*2)
			{
				rektangle[i][j] = chars[i%chars.length];
			}
			for(int j = length-1; j < charWidth; j=j+(length-1)*2)
			{
				rektangle[i][j] = chars[(length+i-1)%chars.length];
				//System.out.println(rektangle[i][j]+" -> " + (length+i-1)%chars.length);
			}
		}

		for(int i = 0; i < rektangle.length; i++)
		{
			for(int j = 0; j < rektangle[0].length; j++)
			{
				if(rektangle[i][j]==0){rektangle[i][j]=' ';} 
			}
		}
		System.out.println(arrToString(rektangle));

	}

	public static String reverse(String s)
	{
		String str = "";
		for(char c : s.toCharArray()){str = c+""+str;}
		return str;
	}

	public static String arrToString(char[][] arr)
	{
		String str = "";
		for(char[] x : arr)
		{
			for(char y : x){str = str+y;}
			str = str + "\n";
		}
		return str;
	}
}