import java.util.Scanner;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

public
 class CliSelector
{ private Application app
; private Scanner scanner
; private CliShow[] dialogs
; private String exitChar = "."
; private boolean isTopLevel = false;

  public
   CliSelector
    ( CliShow[] dialogs)
  { this.scanner = scanner
  ; this.dialogs = dialogs; }

  public static
   CliSelector createFrom
    ( CliShow ...dialogs)
  { return
      new CliSelector
        ( dialogs); }

  public static
   void show
    ( Application app
    , CliShow cli)
  { CliSelector cliSelector
     = CliSelector.createFrom
        ( cli)
  ; while(cliSelector.engage(app)); }

  public
   Boolean engage
    (Application app)
  { System.out.println()
  ; CliSelector.say
     ( "Please select one of these options..")

  ; CliChoiceDialog choiceDialog
    = new CliChoiceDialog<CliShow>()

  ; choiceDialog.printOption
      ( exitChar
      , String.format
          ( "(to %s.)"
          , this.isTopLevel
              ? "quit"
              : "return up")
      , CliValidity.valid())

  ; ChoiceConditional<CliShow>[]
      choiceConditionals
       = getChoiceConditionals
          ( app
          , this.dialogs)

  ; choiceDialog.printDialogChoices
      (choiceConditionals)

  ; String characterEntered
     = choiceDialog.getEntry()

  ; if(shouldExit(characterEntered))
     return false

  ; CliShow chosenDialog
     = (CliShow)choiceDialog.selectChoice
        ( characterEntered
        , choiceConditionals)

  ; if (chosenDialog == null)
    { System.out.println
       ("Invalid choice entered"
          + ", please try again..")
    ; return this.engage(app); }

  ; chosenDialog.show(app)

  ; return this.engage(app); }

  public static
   Float askForFloat
    (String ask)
  { try
    { return
        Float.parseFloat
         ( CliSelector.askFor(ask)); }
    catch(Exception ex)
    { System.out.println("That wasn't a float.., try again (e.g., -21.534)")
    ; return CliSelector.askForFloat(ask); } }

  public static
   Integer askForInt
    (String ask)
  { try
    { return
        Integer.parseInt
         ( CliSelector.askFor(ask)); }
    catch(Exception ex)
    { System.out.println("That wasn't a integer.., try again (e.g., +4)")
    ; return CliSelector.askForInt(ask); } }

  public static
   String askFor
    (String ask)
  { CliSelector.say
     ( String.format
        ( "Type (%s) and enter"
        , ask))

  ; Scanner scanner
     = new Scanner(System.in)

  ; String line
     = scanner.nextLine()

  ; if(line == null
       || line.length() == 0)
    { return CliSelector.askFor(ask); }

  ; return line; }

  public static
   void say
    (String toSay)
  { System.out.println
     ( String.format
        ( "Navigator> %s."
        , toSay)); }

  private
   Boolean shouldExit
    (String charEntered)
  { if(mayExit()
      && this.exitChar
          .equals(charEntered))
    { return true; /*exit parent loops*/ }

    return false; }

  private
   Boolean mayExit()
  { return this.exitChar != null; }

  private
   ChoiceConditional<CliShow>[]
    getChoiceConditionals
     ( Application app
     , CliShow[]
        cliInterfaces)
  { List<ChoiceConditional<CliShow>>
     choiceConditionals
      = new ArrayList<ChoiceConditional<CliShow>>()

  ; for(CliShow
      cliInterface : cliInterfaces)
    { Boolean isChoiceProvider
        = cliInterface
           instanceof CliProvidesChoice
    ; if(isChoiceProvider == false)
      { continue; }

      CliProvidesChoice<CliShow>
        choiceProvider
          = (CliProvidesChoice)cliInterface

    ; Choice<CliShow> choice
       = choiceProvider.getCliChoice()

    ; CliValidity isChoiceValid
       = choiceProvider.isChoiceValid(app)

    ; ChoiceConditional<CliShow>
       choiceConditional =
        new ChoiceConditional<CliShow>
         (choice, isChoiceValid)

    ; choiceConditionals.add
        (choiceConditional); }

    return
      choiceConditionals.toArray
        (new ChoiceConditional
          [choiceConditionals.size()]); }

  public
   void setTopLevel()
  { this.isTopLevel = true; }

  public
   void exitOn(String exitChar)
  { this.exitChar = exitChar; } }
