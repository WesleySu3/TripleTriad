import java.awt.Color;
import java.awt.Font;

public abstract class GUI {
  public String title = "";
  public Color titleColor = StdDraw.BLACK;


  // Fonts
  Font heading = new Font("Papyrus", Font.ITALIC, 96);
  Font papyrus16 = new Font("Papyrus", Font.BOLD, 16);
  Font papyrus24 = new Font("Papyrus", Font.BOLD, 24);
  Font papyrus32 = new Font("Papyrus", Font.BOLD, 32);
  Font papyrus48 = new Font("Papyrus", Font.BOLD, 48);

  // Colors
  Color background = new Color(230, 165, 0);
  Color button = new Color(139, 69, 19);
  Color selected = new Color(210, 105, 30);
  Color cardRed = new Color(240, 128, 128);
  Color cardBlue = new Color(0, 191, 255);

  // Available to subtypes
  public Box[] boxes;

  public void setTitleAndColor(String title, Color titleColor) {
    this.title = title;
    this.titleColor = titleColor;
  }

  /*
   * This is something that the main game should call
   * Returns 0 if no valid move has been made.
   * Returns an integer representing the move if one has been made
   * This should work for any type of GUI -> the code gets written here.
   */
  public int getMove(){
    if(StdDraw.mousePressed()) {
      while(StdDraw.mousePressed()) {
      }
      double x = StdDraw.mouseX();
      double y = StdDraw.mouseY();
      for(int i=0; i < boxes.length; i++) {
        if(boxes[i].contains(x,y)) {
          return boxes[i].getBoxcode();
        }
      }
    }
    return -1;
  }


  // Display output to the screen
  abstract void draw();

  // Available to subtypes
  public class Box{
    public double x0,y0,x1,y1;
    public int boxcode;

    public Box(double x0, double y0, double x1, double y1, int boxcode) {
      this.x0 = x0;
      this.y0 = y0;
      this.x1 = x1;
      this.y1 = y1;
      this.boxcode = boxcode;
    }

    public void display(Font _font, String _text, Color _boxColor,
                   Color _boundaryColor, Color _textColor) {

      // Draw box background
      StdDraw.setPenColor(_boxColor);
      StdDraw.filledRectangle((x1+x0)/2, (y1+y0)/2,
      (x1-x0)/2, (y1-y0)/2);

      // Draw box boundary
      StdDraw.setPenColor(_boundaryColor);
      StdDraw.rectangle((x1+x0)/2, (y1+y0)/2,
      (x1-x0)/2, (y1-y0)/2);

      // Draw box text
      StdDraw.setFont(_font);
      StdDraw.setPenColor(_textColor);
      StdDraw.text((x1+x0)/2, (y1+y0)/2 + .1, _text);

    }


    // Returns true if this Box contains this point
    public boolean contains(double x, double y) {
      return(x0 < x && x < x1 && y0 < y && y < y1);
    }

    public int getBoxcode() {
      return boxcode;
    }

  }




}