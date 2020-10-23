import java.nio.file.*;
import parser.Actions;
import parser.PGN;
import parser.TreeNode;
import parser.ParseError;
import static parser.PGN.parse;

public class TestPgn{
    private static Actions actions ;
    private static TreeNode _parse ;
    public static String readFileAsString(String fileName)throws Exception
    {
        String data = "";
        data = new String(Files.readAllBytes(Paths.get(fileName)));
        return data;
    }

    public static void main(String[] args) throws Exception
    {
        String data = readFileAsString("/Users/enrique/IdeaProjects/Parser/one.pgn");
        //System.out.println(data);
        _parse = parse(data);
    }
}
