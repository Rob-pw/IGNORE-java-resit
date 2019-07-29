import java.util.List;
import java.util.ArrayList;

public
 class CliChoiceDialog
  <T>
{ public
    String getEntry()
  { String response
    = CliSelector.askFor("choice")

  ; String charEntered
     = response

  ; return charEntered; }

  public
   void printDialogChoices
    ( ChoiceConditional<T>[] dialogChoices)
  { for(ChoiceConditional<T>
      dialogChoice : dialogChoices)
    { printOption
       ( dialogChoice); }

     System.out.println(); }

  public
   void printOption
    ( Choice<T> choice)
  { ChoiceConditional<T>
      choiceConditional
        = passingChoice(choice)

  ; printOption(choiceConditional); }

  public
   void printOption
    ( ChoiceConditional<T> choice)
  { String activatedBy
     = choice.activatedBy
  ; String activationInfo
     = choice.description

  ; CliValidity validity
     = choice.validity

  ; printOption
      ( activatedBy
      , activationInfo
      , validity); }

  public
   void printOption
    ( String activatedBy
    , String activationInfo
    , CliValidity validity)
  { Boolean isChoiceValid
     = validity.isValid()

  ; String dialogChoice
     = String.format
        ( ">> [%s] - %s"
        , activatedBy
        , activationInfo)

  ; if(isChoiceValid == false)
    { dialogChoice +=
       String.format
        ( " [disabled: %s]"
        , validity.validityMessage()); }

  ; System.out.println(dialogChoice); }

  public
   ChoiceConditional<T> passingChoice
    ( Choice<T> choice)
  { ChoiceConditional<T>
      choiceConditional
        = new ChoiceConditional<T>
            ( choice
            , CliValidity.valid())

  ; return choiceConditional; }

  public
   T makeNumberedPassingChoice
    ( T[] targets)
  { Choice<T>[] choices
      = new Choice[targets.length]
  ; Integer index = 0
  ; for(T
      target : targets)
    { Choice<T> choice
       = new Choice<T>
          ( target
          , index.toString()
          , target.toString())
    ; choices[index] = choice
    ; index += 1; }

  ; return makeChoice(choices); }

  public
   List<T> selectMultiple
    ( Integer minimumOf
    , T[] selectOf
    , String subjectName)
  { List<T> chosenChoices
     = new ArrayList<T>()
  ; Boolean addMore = true
  ; do
    { Boolean minimumMet
       = chosenChoices.size() >= minimumOf

    ; if(minimumMet)
      { String prompt
         = String.format
            ( "Select more %s?"
            , subjectName)
      ; addMore = CliBoolDialog
          . ask(prompt); }
      else addMore = true

    ; if (addMore)
      { T chosen =
         this.makeNumberedPassingChoice
           ( selectOf)
      ; chosenChoices
         . add(chosen); } }
    while(addMore)

  ; return chosenChoices; }

  public
   T makeChoice
    ( Choice<T>[] choices)
  { List<ChoiceConditional<T>>
      choiceConditionals
        = new ArrayList<ChoiceConditional<T>>()

  ; for(Choice<T>
      choice : choices)
    { choiceConditionals.add
        ( passingChoice(choice)); }

  ; return (T)makeChoice
      (choiceConditionals.toArray
        (new ChoiceConditional
          [choiceConditionals.size()])); }

  public
   T makeChoice
    ( ChoiceConditional<T>[] choices)
  { printDialogChoices(choices)

  ; String characterEntered
     = getEntry()

   ; T chosen
      = selectChoice
         ( characterEntered
         , choices)

   ; return chosen; }

  public
   T selectChoice
    ( String charEntered
    , ChoiceConditional<T>[] choices)
  { ChoiceConditional<T> selection
      = null

  ; for(ChoiceConditional<T>
      choice : choices)
    { if(charEntered
          .equals( choice.activatedBy))
      { selection = choice; } }

  ; if(selection == null)
    { System.out.println
       ("Invalid choice entered"
          + ", please try again..")
    ; return this.makeChoice(choices); }

  ; CliValidity validity
     = selection.validity
  ; if(validity.isValid() == false)
    { System.out.println
        ("That choice is disabled: \n"
          + validity.validityMessage())
    ; return this.makeChoice(choices); }

  ; return selection.target; } }
