import java.util.List;
import java.util.ArrayList;

public
 class CliRouteElementPicker
{ public static
   RouteElement chooseRouteElement
    ( Application app
    , String name
    , String description)
  { List<RouteElement>
     routeElements =
      new ArrayList<RouteElement>()

  ; Boolean firstAddMoreElements
     = CliBoolDialog.ask
        ("Would you like to add any"
          + " route elements first?")

  ; if(firstAddMoreElements)
    { CliAdminMenu.showOptions(app); }

  ; routeElements.addAll
      (app.settlements)
  ; routeElements.addAll
      (app.roadSegments)

  ; CliChoiceDialog<RouteElement>
     choiceDialog
      = new CliChoiceDialog
          <RouteElement>()

  ; RouteElement[] newArray
     = new RouteElement
        [routeElements.size()]

  ; CliSelector.say
      ( String.format
         ( "Select %s for %s:"
         , description
         , name))
  ; RouteElement routeElement
     = choiceDialog
        . makeNumberedPassingChoice
           ( routeElements.toArray
              ( newArray))
  ; return routeElement; } }
