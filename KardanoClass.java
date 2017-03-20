import java.util.*;
import java.util.Random;
import java.util.Scanner;


public class KardanoClass {
    public void fillSquare()
    {
        boolean[][] cell = new boolean[0][];
        for (int i = 0; i < 4; ++i) {
            for (int j = 0; j < 4; ++j) {
                cell[i][j] = false;
            }
        }
        cell[0][2] = true;
        cell[1][1] = true;
        cell[3][0] = true;
        cell[3][2] = true;
    }

    public void RotateMask()
    {
        boolean[][] tmpMask = new boolean[4][4];
        boolean[][] cell = new boolean[0][];
        for (int i = 0; i<4; i++){
            for (int j = 0; j<4; j++) {
                tmpMask[j][3 - i] = cell[i][j];
            }
        }
        for (int i = 0; i<4; i++) {
            for (int j = 0; j < 4; j++) {
                cell[i][j] = tmpMask[i][j];
            }
        }
    }
    public void WriteBlock(String block)
    {
        int stringIterator = 0;
        for (int i = 0; i<4; i++)
            for (int j = 0; j<4; j++)
            {
                if (stringIterator > 3)
                    break;
                boolean[][] cell =  new boolean[0][];
                if (cell[i][j] == true)
                {
                    double[][] code = new double[0][];
                    code[i][j] = block[stringIterator++];
                }
            }
    }

    public  boolean EncodeWord(String inputStr)
    {

        if (inputStr.length() > 16)
            return false;
        int position = 0;
        fillSquare();
        while (inputStr.length() != 16)
        {
            inputStr += '#';
        }
        ArrayList<String> blockSeries= new ArrayList <String>();
        for (int i = 0; i < 4; ++i) {
            blockSeries.add(inputStr.substring(i * 4, 4));
        }
        for (String curBlock : blockSeries)
        {
            WriteBlock(curBlock);
            RotateMask();
        }
        return true;
    }

    public String DecodeWord(String inputStr)
    {
        if (inputStr.length() != 16)
            return "";
        int position = 0;
        fillSquare();
        ArrayList<String> blockSeries= new ArrayList <String>();
        for (int i = 0; i < 4; ++i)
            blockSeries.add(inputStr.substring(i *4, 4));
        double[][] code = new double[0][];
        for (int i = 0; i < 4; ++i)
            for (int j = 0; j < 4; ++j)
                code[i][j] = blockSeries[i][j];
        ArrayList<String> resultSeries= new ArrayList <String>();
        for (int i = 0; i < 4; ++i)
        {
            resultSeries.add(ReadBlock());
            RotateMask();
        }
        return CompileStr(resultSeries);
    }

    public String ReadBlock()
    {
        String result = "";
        boolean[][] mask = new boolean[0][];
        String[][] code = new String[0][];
        for (int i = 0; i < 4; ++i)
            for (int j = 0; j < 4; ++j)
                if (mask[i][j] == true)
                    result += code[i][j];
        return result;
    }
    
    public void InitCode()
    {
        double[][] code = new double[0][];
        for (int i = 0; i < 4; ++i)
            for (int j = 0; j < 4; ++j)
                code[i][j] = new Random().nextInt(254)  + 1;
    }

    public String CompileStr(ArrayList<String>  inputSeries)
    {
        String result = "";
        for (String curStr : inputSeries)
        {
            result += curStr;
        }
        return result;
    }

    public boolean EmptyState(int position)
    {
        if  (position >= 4){
        return true;
    }
        return false;
    }

    public String GetCodeWord()
    {
        String result = "";
        String[][] code = new String[0][];
        for (int i = 0; i < 4; ++i)
            for (int j = 0; j < 4; ++j)
                result += code[i][j];
        return result;
    }
    public static void main (String[]args){
        Scanner in = new Scanner(System.in);
        System.out.print("Введите строку: ");
        String sentence = in.nextLine();
//        boolean check= EncodeWord
    }
}
 //index = new Random().nextInt(62);