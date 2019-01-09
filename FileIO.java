import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/* Contains defintions for functions that operate on IO streams. */
public class FileIO {
  public static void main(String[] args) {
    if (args.length > 0) {
      switch(args[0]) {
        case "c":
          if (args.length == 3) {
            copyCharacters(args[1], args[2]);
          }
          else {
            System.out.println("Please input two file paths.");
          }
          break;
        case "w":
          if (args.length == 2) {
            writeCharacters(args[1]);
          }
          else {
            System.out.println("Please input a file path to write to.");
          }
          break;
        default:
          System.out.println("Invalid command.");
      }
    }
    else {
      System.out.println("Please input a command.");
    }
  }

  /* Copies all characters from one path to another (overwriting). */
  public static void copyCharacters(String file1, String file2) {
    FileReader reader = null;
    FileWriter writer = null;
    int charCount = 0;

    try {
      reader = new FileReader(file1);
      writer = new FileWriter(file2);

      int c;
      while ((c = reader.read()) != -1) {
        writer.write(c);
        charCount++;
      }

      reader.close();
      writer.close();

      System.out.println("Operation complete. Wrote " +
      charCount + " characters to path.");
    }
    catch(Exception e) {
      System.out.println(e.getMessage());
    }
  }

  /* Writes all characters inputted into the path. */
  public static void writeCharacters(String file) {
    Scanner s = new Scanner(System.in);
    FileWriter writer;
    String next;
    int charCount = 0;

    try {
      writer = new FileWriter(file);

      // Get the input line by line
      do {
        next = s.nextLine();
        if (next.equals("q"))
          break;
        writer.write(next + "\n");
        charCount += next.length();
      }
      while (!next.equals("q"));

      writer.close();
      System.out.println("Operation complete. Wrote " + charCount +
      " characters to path.");
    }
    catch(Exception e) {
      System.out.println(e.getMessage());
    }
  }
}
