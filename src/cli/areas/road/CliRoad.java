import java.util.List;
import java.util.ArrayList;

public
 class CliRoad
 implements
    CliShow
  , CliProvidesChoice<CliShow>
{ public
   void show
    ( Application app)
  { String name
     = CliSelector.askFor
        ( "name of the road")

  ; CliChoiceDialog roadTypeChoiceDialog
     = new CliChoiceDialog<RoadType>()
  ; RoadType type
     = (RoadType)roadTypeChoiceDialog
        . makeNumberedPassingChoice
           ( RoadType.values())

  ; Road road
     = new Road(name, type)
  ; Boolean associate
     = CliBoolDialog
        . ask("Associate with road segments?")

  ; List<RoadSegment> chosen
     = new ArrayList<RoadSegment>()
  ; if(associate)
    { CliChoiceDialog<RoadSegment>
       choiceDialog
        = new CliChoiceDialog<RoadSegment>()
    ; chosen = choiceDialog
       . selectMultiple
          ( 1
          , app.roadSegments.toArray
              ( new RoadSegment
                 [app.roadSegments.size()])
          , "road segments"); }

  ; road.addRouteElements
     ( chosen)

  ; app.roads.add(road); }

  public
   Choice<CliShow> getCliChoice()
  { return
     new Choice<CliShow>
      ( (CliShow)this
      , "o"
      , "add a road"); }

  public
   CliValidity isChoiceValid
    ( Application app)
  { return CliValidity.valid(); } }
