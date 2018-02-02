package at.fhhagenberg.sqe.domain;

public class Floor 
{
  private boolean upButton;
  private boolean downButton;
  private int nr;
  
  public Floor(int nr)
  {
    upButton = false;
    downButton = false;
    this.nr = nr;
  }

  public boolean getUpButton() 
  {
    return upButton;
  }

  public void setUpButton(boolean upButton) 
  {
    this.upButton = upButton;
  }

  public boolean getDownButton()
  {
    return downButton;
  }

  public void setDownButton(boolean downButton)
  {
    this.downButton = downButton;
  }
  
  public boolean getAnyButton()
  {
    return getDownButton() || getUpButton();
  }
  
  public int getNr()
  {
    return nr;
  }
}
