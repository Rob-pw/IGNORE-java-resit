import java.util.List;

public
 class CliRouteDisplay
 implements
    CliShow
  , CliProvidesChoice<CliShow>
{ public
   Choice<CliShow> getCliChoice()
  { return
     new Choice<CliShow>
      ( (CliShow)this
      , "l"
      , "display all routes"); }

  public
   CliValidity isChoiceValid
    ( Application app)
  { return CliValidity.valid(); }

  public
   void show
    ( Application app)
  { CliSelector.say
     ( "Listing all routes.")

  ; List<Route> routes
     = app.routes
  ; for(Route
      route : routes)
    { String routeString
       = route.toString()

    ; System.out.println(routeString); } } }
