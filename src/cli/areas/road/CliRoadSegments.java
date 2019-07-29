import java.util.List;
import java.util.ArrayList;

public
 class CliRoadSegments
 implements
    CliShow
  , CliProvidesChoice<CliShow>
{ public
   Choice<CliShow> getCliChoice()
  { return
     new Choice<CliShow>
      ( (CliShow)this
      , "r"
      , "add new road segments"); }

  public
   CliValidity isChoiceValid
    ( Application app)
  { Integer sufficientRoutes
     = app.settlements.size()
        + app.roadSegments.size()
  ; if(sufficientRoutes < 2)
    { String validityMsg
       = "Requires at least two settlements"
          + " between which to connect."
    ; return
       CliValidity.notValid(validityMsg); }

    return CliValidity.valid(); }

  public
   void show
    ( Application app)
  { String name
      = CliSelector.askFor("name")
  ; Float miles
      = CliSelector.askForFloat("miles")

  ; RoadSegment segment
     = new RoadSegment(name)
  ; app.roadSegments
     . add( segment)
  ; segment.setMiles(miles)

  ; List<RouteElement> routeElements
     = new ArrayList<RouteElement>()
  ; Boolean addMore = true
  ; do
    { Boolean minimumMet
       = routeElements.size() >= 2

    ; if(minimumMet)
      { String prompt
         = String.format
            ( "Add more connections for %s?"
            , name)
      ; addMore = CliBoolDialog
          . ask(prompt); }
      else addMore = true

    ; if (addMore)
      { RouteElement chosenConnection
         = CliRouteElementPicker
            . chooseRouteElement
               ( app, name, "connections")
      ; routeElements
         . add(chosenConnection)
      ; segment.addRouteElement
         ( chosenConnection)
      ; chosenConnection.addRouteElement
         ( segment); } }
    while(addMore); } }
