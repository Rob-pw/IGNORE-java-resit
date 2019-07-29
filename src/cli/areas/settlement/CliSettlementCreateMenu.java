import java.util.List;
import java.util.ArrayList;

public
 class CliSettlementCreateMenu
 implements
    CliShow
  , CliProvidesChoice<CliShow>
{ public
   Choice<CliShow> getCliChoice()
  { return
     new Choice<CliShow>
      ( (CliShow)this
      , "a"
      , "add a new settlement"); }

  public
   CliValidity isChoiceValid
    (Application app)
  { return CliValidity.valid(); }

  public
   void show
    ( Application app)
  { String settlementName
     = CliSelector.askFor("settlement name")

  ; Choice<SettlementType>[]
     choices = formSettlementTypeChoices()
  ; SettlementType settlementType
      = chooseSettlementType(choices)

  ; Settlement settlement
     = new Settlement
        ( settlementName
        , settlementType)

  ; Integer population
     = CliSelector.askForInt
        ( settlement.type.toString()
           + " population (n.b.: integer)")
  ; settlement.setPopulation(population)

  ; Float latitude
     = CliSelector.askForFloat
        ( "latitude (n.b.: decimal/float)")
  ; Float longitude
     = CliSelector.askForFloat
        ( "longitude (n.b.: decimal/float)")
  ; settlement.setLatLong
      (latitude, longitude)

  ; app.settlements.add(settlement); }

  private
   SettlementType chooseSettlementType
    ( Choice<SettlementType>[] choices)
  { CliChoiceDialog choiceDialog
     = new CliChoiceDialog<SettlementType>()

  ; return (SettlementType)
     choiceDialog.makeChoice
      (choices); }

  private
   Choice<SettlementType>[]
    formSettlementTypeChoices()
  { List<Choice<SettlementType>>
     choices =
      new ArrayList<Choice<SettlementType>>()

  ; Choice<SettlementType> villageChoice
      = new Choice<SettlementType>
         ( SettlementType.Village
         , "v"
         , "Village")
  ; Choice<SettlementType> townChoice
     = new Choice<SettlementType>
        ( SettlementType.Town
        , "t"
        , "Town")

  ; choices.add(villageChoice)
  ; choices.add(townChoice)

  ; return
     choices.toArray
      (new Choice
        [choices.size()]); } }
